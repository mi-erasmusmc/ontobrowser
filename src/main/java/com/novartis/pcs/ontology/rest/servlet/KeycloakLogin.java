package com.novartis.pcs.ontology.rest.servlet;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.novartis.pcs.ontology.entity.Curator;
import com.novartis.pcs.ontology.entity.InvalidEntityException;
import com.novartis.pcs.ontology.rest.json.KeycloakTokenPayload;
import com.novartis.pcs.ontology.rest.json.controlledvocabulary.KeycloakTokenResponse;
import com.novartis.pcs.ontology.service.OntologyCuratorServiceLocal;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static java.nio.charset.StandardCharsets.UTF_8;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@WebServlet("/login")
public class KeycloakLogin extends HttpServlet {

    private static final String CODE = "code";
    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_SECRET = "client_secret";
    private static final String GRANT_TYPE = "grant_type";
    private static final String REDIRECT_URI = "redirect_uri";
    private static final String ACCEPT = "Accept";
    private static final String CURATOR = "curator";

    @Resource(lookup = "java:global/keycloak/host")
    private String keycloakHost;


    private Logger logger = Logger.getLogger(getClass().getName());
    private ObjectMapper mapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

    @EJB
    private OntologyCuratorServiceLocal curatorService;


    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        response.setIntHeader("Access-Control-Max-Age", 60 * 60 * 24);
        response.setContentLength(0);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        resp.setContentLength(0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        resp.setContentLength(0);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        resp.setContentLength(0);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter(CODE);

        try (CloseableHttpClient client = HttpClients.createDefault()) {

            HttpPost post = getPost(code);
            HttpResponse keycloakResp = client.execute(post);

            String token = getTokenFromResponse(keycloakResp);
            Curator curator = loadCuratorFromToken(token);

            request.getSession(true).setAttribute(CURATOR, curator);
            response.sendRedirect("http://localhost:8080");

        } catch (IOException e) {
            logger.log(Level.WARNING, "Something went wrong requesting the keycloak token: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    private String getTokenFromResponse(HttpResponse keycloakResponse) throws IOException {

        String responseString = IOUtils.toString(keycloakResponse.getEntity().getContent(), UTF_8);


        if (keycloakResponse.getStatusLine().getStatusCode() != 200) {
            String message = String.format("Received a %d %s response from Keycloak after requesting the token with message: %s",
                    keycloakResponse.getStatusLine().getStatusCode(), keycloakResponse.getStatusLine().getReasonPhrase(), responseString);
            logger.log(Level.WARNING, message);
            return null;
        }

        return mapper.readValue(responseString, KeycloakTokenResponse.class).getAccessToken();
    }


    private HttpPost getPost(String code) {
        try {
            URI uri = getDevUri();

            HttpPost post = new HttpPost(uri);
            post.setHeader(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_FORM_URLENCODED));
            post.setHeader(new BasicHeader(ACCEPT, APPLICATION_JSON));
            post.setEntity(getEntity(code));

            return post;

        } catch (URISyntaxException | IOException e) {
            logger.log(Level.WARNING, "Something went wrong creating the token request: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private UrlEncodedFormEntity getEntity(String code) throws UnsupportedEncodingException {
        List<NameValuePair> params = new ArrayList<>(5);

        params.add(new BasicNameValuePair(CLIENT_ID, "ontobrowser"));
        params.add(new BasicNameValuePair(CLIENT_SECRET, "26f5b221-7912-46c0-862d-e3af6e3aa480"));
        params.add(new BasicNameValuePair(CODE, code));
        params.add(new BasicNameValuePair(GRANT_TYPE, "authorization_code"));
        params.add(new BasicNameValuePair(REDIRECT_URI, "http://localhost:8080/login"));

        return new UrlEncodedFormEntity(params);
    }

    private URI getDevUri() throws URISyntaxException {
        return new URIBuilder()
                .setScheme("http")
                .setHost(keycloakHost)
                .setPath("/auth/realms/KH/protocol/openid-connect/token")
                .build();
    }

    private Curator loadCuratorFromToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String jsonString = new String(Base64.getDecoder().decode(jwt.getPayload()));
        Curator curator = null;

        try {
            KeycloakTokenPayload payload = mapper.readValue(jsonString, KeycloakTokenPayload.class);
            String username = payload.getUsername();
            if (payload.containsCuratorRole()) {
                curator = curatorService.loadByUsername(username);
                if (curator == null) {
                    logger.info("Creating new curator: " + username);
                    curator = new Curator(username, curatorService.loadByUsername("SYSTEM"));
                    curatorService.save(curator);
                }
            } else {
                logger.log(Level.WARNING, "No curator loaded. User [" + payload.getUsername() + "] does not have curator permission");
            }
        } catch (IOException e) {
            // TODO: return bad request
            logger.log(Level.WARNING, "Received request with malformed token payload: " + jsonString);
        } catch (InvalidEntityException e) {
            logger.log(Level.WARNING, "Something went wrong trying to store a new curator for: " + jsonString);
        }
        return curator;
    }

}
