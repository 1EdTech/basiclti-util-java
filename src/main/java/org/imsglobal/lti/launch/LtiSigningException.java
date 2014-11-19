package org.imsglobal.lti.launch;

/**
 * This exception is thrown to indicate that there was an error when signing an LTI request.
 *
 * Created by pgray on 8/23/14.
 */
public class LtiSigningException extends Exception {
    public LtiSigningException(String message, Exception exception) {
        super(message, exception);
    }
}
