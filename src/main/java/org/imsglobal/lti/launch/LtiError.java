package org.imsglobal.lti.launch;

/**
 * Created by paul on 5/28/14.
 */
public class LtiError {

    private final String label;

    public static final LtiError INVALID_HASH = new LtiError("invalid_hash");
    public static final LtiError TIMESTAMP_MISMATCH = new LtiError("timestamp_mismatch");
    public static final LtiError BAD_REQUEST = new LtiError("bad_request");

    private LtiError(String label){
        this.label = label;
    }

    public String toString(){
        return label;
    }

}
