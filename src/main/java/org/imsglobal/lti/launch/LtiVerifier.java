package org.imsglobal.lti.launch;


import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

/**
 * This interface contains methods that <b>verify</b> HttpRequests
 * and generic request parameters according to the LTI
 * specification.
 * @author  Paul Gray
 * @since   1.1
 */
public interface LtiVerifier {

    /**
     * This method will verify the HttpServletRequest.
     *
     * @param request the HttpServletRequest that will be verified
     * @param secret the secret to verify the properties with
     * @return an LtiVerificationResult which will
     * contain information about the request (whether or
     * not it is valid, and if it is valid, contextual
     * information about the request).
     * @throws LtiVerificationException
     */
    LtiVerificationResult verify(HttpServletRequest request, String secret) throws LtiVerificationException;

    /**
     * This method will verify a list of properties (mapped
     * by key &amp; value).
     * @param parameters the parameters that will be verified. mapped by key &amp; value. This should only include parameters explicitly included in the body (not the url).


     * @param parameters the parameters that will be verified. mapped by key &amp; value. This should include parameters explicitly included in the body
     *                   (if this collection also includes parameters from the url, those parameters must be omitted in the `url` parameter to this method).
     *                   The entries must be of type `Entry&lt;String,String&gt;`. If a specific key has multiple values (i.e. an array), each value must be in its own entry, each
     *                   with the same key.
     * @param url The url this request was made at. The url passed should be the same as sent for the request if the request includes parameters,
     *            they may be optionally included here, or in the collection passed to parameters.
     * @param method the method this url was requested with
     * @param secret the secret to verify the properties with
     * @return an LtiVerificationResult which will
     * contain information about the request (whether or
     * not it is valid, and if it is valid, contextual
     * information about the request).
     * @throws LtiVerificationException
     */
    LtiVerificationResult verifyParameters(Map<String, String> parameters, String url, String method, String secret) throws LtiVerificationException;

    /**
     * This method will verify a list of properties (mapped
     * by key &amp; value).
     * @param parameters the parameters that will be verified. mapped by key &amp; value. This should include parameters explicitly included in the body
     *                   (if this collection also includes parameters from the url, those parameters must be omitted in the `url` parameter to this method).
     *                   The entries must be of type `Entry&lt;String,String&gt;`. If a specific key has multiple values (i.e. an array), each value must be in its own entry, each
     *                   with the same key.
     * @param url The url this request was made at. The url passed should be the same as sent for the request if the request includes parameters,
     *            they may be optionally included here, or in the collection passed to parameters.
     * @param method the method this url was requested with
     * @param secret the secret to verify the properties with
     * @return an LtiVerificationResult which will
     * contain information about the request (whether or
     * not it is valid, and if it is valid, contextual
     * information about the request).
     * @throws LtiVerificationException
     */
    LtiVerificationResult verifyParameters(Collection<? extends Map.Entry<String, String>> parameters, String url, String method, String secret) throws LtiVerificationException;

}
