package com.novartis.pcs.ontology.rest.servlet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.novartis.pcs.ontology.entity.Curator;
import com.novartis.pcs.ontology.entity.InvalidEntityException;
import com.novartis.pcs.ontology.rest.json.ErrorResponse;
import com.novartis.pcs.ontology.rest.json.controlledvocabulary.ControlledVocabularyDTO;
import com.novartis.pcs.ontology.service.OntologyCuratorServiceLocal;
import com.novartis.pcs.ontology.service.importer.ControlledVocabularyImportServiceLocal;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.apache.commons.lang.CharEncoding.UTF_8;

@WebServlet("/controlledvocabularies")
public class ControlledVocabulariesServlet extends HttpServlet {

    @EJB
    private ControlledVocabularyImportServiceLocal importService;

    @EJB
    private OntologyCuratorServiceLocal curatorService;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
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
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log("Received controlled vocabulary import request");
        String mediaType = getExpectedMediaType(request);
        String encoding = StringUtils.trimToNull(request.getCharacterEncoding());
        // TODO: See if the user of this endpoint needs a particular reference
        Curator curator = curatorService.loadByUsername("SYSTEM");


        if (!StringUtils.equalsIgnoreCase(mediaType, APPLICATION_JSON)
                || !StringUtils.equalsIgnoreCase(encoding, UTF_8)) {
            log("Failed to import controlled vocabulary: invalid media type or encoding "
                    + mediaType + ";charset=" + encoding);
            returnError(response, HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                    "UNSUPPORTED MEDIA TYPE",
                    String.format("Received Accept header containing: %s;charset=%s . Expected: %s;charset=%s",
                            mediaType, encoding, APPLICATION_JSON, UTF_8));

        } else {
            try {
                String jsonString = IOUtils.toString(request.getReader());
                ControlledVocabularyDTO controlledVocab = mapper.readValue(jsonString, ControlledVocabularyDTO.class);
                log("Started import controlled vocabulary");
                importService.importControlledVocabulary(controlledVocab, curator);
                log("Finished import controlled vocabulary");
                response.setStatus(HttpServletResponse.SC_ACCEPTED);
            } catch (IOException e) {
                log("Something went wrong parsing the request body, most likely the request was malformed");
                log(Arrays.toString(e.getStackTrace()));
                returnError(response, HttpServletResponse.SC_BAD_REQUEST, "BAD REQUEST",
                        "Something went wrong parsing the request body, most likely request was malformed");
            } catch (InvalidEntityException e) {
                log("Import contained an invalid entity " + e.getMessage());
                returnError(response, HttpServletResponse.SC_BAD_REQUEST, "BAD REQUEST", e.getMessage());
            }
        }
        response.setContentLength(0);

    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) {
        String mediaType = getExpectedMediaType(request);

        if (APPLICATION_JSON.equals(mediaType)) {
            // Preflight CORS support
            response.setStatus(HttpServletResponse.SC_OK);
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "PUT");
            response.setIntHeader("Access-Control-Max-Age", 60 * 60 * 24);
            response.setContentType(mediaType + ";charset=utf-8");
            response.setContentLength(0);
        } else {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            response.setContentLength(0);
        }
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        return System.currentTimeMillis();
    }

    private String getExpectedMediaType(HttpServletRequest request) {
        String mediaType = null;
        String acceptHeader = request.getHeader("Accept");
        if (acceptHeader != null) {
            mediaType = StringUtils.trimToNull(
                    MIMEParse.bestMatch(Collections.singleton(APPLICATION_JSON), acceptHeader));
        }
        return mediaType;
    }


    private void returnError(HttpServletResponse response, int responseCode, String error, String message)
            throws IOException {
        String errorJson = mapper.writeValueAsString(new ErrorResponse(error, message));
        response.setStatus(responseCode);
        response.getWriter().write(errorJson);
        response.getWriter().close();
        response.getWriter().flush();
    }
}

