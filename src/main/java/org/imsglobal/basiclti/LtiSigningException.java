package org.imsglobal.basiclti;

import oauth.signpost.exception.OAuthException;

/**
 * Created by pgray on 8/23/14.
 */
public class LtiSigningException extends Exception {
    public LtiSigningException(String message, Exception exception) {
        super(message, exception);
    }
}
