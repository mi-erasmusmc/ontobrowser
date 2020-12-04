package com.novartis.pcs.ontology.service.util;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.user.server.rpc.SerializationPolicy;
import com.google.gwt.user.server.rpc.SerializationPolicyLoader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

/**
 * ContextRemoteServiceServlet is an extension of RemoteServiceServlet that
 * loads the RPC serialization policy based on the context name rather than URL if it is
 * not successfully loaded using the GWT's default method. This is useful if
 * you're proxying requests to RPC servlets from one server to another and the
 * paths to the servlets don't match perfectly (causing the RPC policy file to fail to load).
 */
public class ContextRemoteServiceServlet extends RemoteServiceServlet {

    private static final long serialVersionUID = -4332306688541651819L;

    /**
     * Attempt to load the RPC serialization policy normally. If it isn't found,
     * try loading it using the context path instead of the URL.
     */
    @Override
    protected SerializationPolicy doGetSerializationPolicy(HttpServletRequest request, String moduleBaseURL, String strongName) {
        moduleBaseURL = "http://localhost:8080/ContextRemoteServiceServlet/";
        SerializationPolicy policy = super.doGetSerializationPolicy(request, moduleBaseURL, strongName);
        if (policy == null) {
            return ContextRemoteServiceServlet.loadSerializationPolicy(this, strongName);
        } else {
            return policy;
        }
    }

    /**
     * Load the RPC serialization policy via the context path.
     */
    static SerializationPolicy loadSerializationPolicy(HttpServlet servlet, String strongName) {
        // The serialization policy path depends only by context path
        SerializationPolicy serializationPolicy = null;
        String serializationPolicyFilePath = SerializationPolicyLoader.getSerializationPolicyFileName("/ontobrowser/"
                + strongName);

        // Open the RPC resource file and read its contents.

        try (InputStream is = servlet.getServletContext().getResourceAsStream(serializationPolicyFilePath)) {
            if (is != null) {
                try {
                    serializationPolicy = SerializationPolicyLoader.loadFromStream(is, null);
                } catch (ParseException e) {
                    servlet.log("ERROR: Failed to parse the policy file '" + serializationPolicyFilePath + "'", e);
                } catch (IOException e) {
                    servlet.log("ERROR: Could not read the policy file '" + serializationPolicyFilePath + "'", e);
                }
            } else {
                String message = "ERROR: The serialization policy file '" + serializationPolicyFilePath +
                        "' was not found; did you forget to include it in this deployment?";
                servlet.log(message);
            }

        } catch (IOException ignored) {
        }

        return serializationPolicy;

    }

}
