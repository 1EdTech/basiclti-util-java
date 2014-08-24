package org.imsglobal.basiclti;

import org.apache.http.HttpRequest;

/**
 * Created by pgray on 8/23/14.
 */
public interface LtiSigner {

    public HttpRequest sign(HttpRequest request, String key, String secret) throws LtiSigningException;

}
