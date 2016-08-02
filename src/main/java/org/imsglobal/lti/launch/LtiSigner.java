package org.imsglobal.lti.launch;

import org.apache.http.HttpRequest;

import java.util.Map;

/**
 * This interface contains methods that <b>sign</b> HttpRequests
 * and generic request parameters according to the LTI
 * specification.
 * @author  Paul Gray
 * @since   1.1
*/
public interface LtiSigner {

    /**
     * This method will return a <b>signed</b> HttpRequest object.
     * Once returned, adding new parameters or changing the
     * body will invalidate the signature. This method should
     * be used for server to server connection requests.
     * For example, posting an LTI Outcome back to the LTI
     * Consumer.
     * @param request the HttpRequest that will be signed
     * @param key the key that will be added to the request.
     * @param secret the secret to be used
     * @return a signed HttpRequest object
     * @throws LtiSigningException
     */
    public HttpRequest sign(HttpRequest request, String key, String secret) throws LtiSigningException;

    /**
     * This method will return a list of <b>signed</b> parameters.
     * Once returned, adding new parameters or changing the
     * body will invalidate the signature. This method will
     * overwrite reserved parameters from the underlying
     * specification. For example, if you are using the Oauth
     * implementation, <b>oauth_signature</b> will be removed
     * &amp; replaced with the generated signature from the properties.
     * @param parameters the parameters that will be signed. mapped by key &amp; value
     * @param key the key that will be added to the request.
     * @param secret the secret to be sign the parameters with
     * @return a map of signed parameters (including the signature)
     * @throws LtiSigningException
     */
    public Map<String, String> signParameters(Map<String, String> parameters, String key, String secret, String url, String method) throws LtiSigningException;

}
