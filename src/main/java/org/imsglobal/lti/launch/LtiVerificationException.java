package org.imsglobal.lti.launch;

/**
 * Created by pgray on 8/28/14.
 */
public class LtiVerificationException  extends Exception {
    public LtiVerificationException(String message, Exception exception) {
        super(message, exception);
    }
}
