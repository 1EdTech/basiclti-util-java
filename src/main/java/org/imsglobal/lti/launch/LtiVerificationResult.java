/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.imsglobal.lti.launch;

import org.imsglobal.lti.launch.LtiError;
import org.imsglobal.lti.launch.LtiLaunch;

/**
 *
 * @author pgray
 */
public class LtiVerificationResult {

    private Boolean success;
    private LtiError error;
    private String message;
    private LtiLaunch ltiLaunchResult;

    public LtiVerificationResult() {
    }

    public LtiVerificationResult(Boolean success, LtiError error, String message) {
        this.success = success;
        this.error = error;
        this.message = message;
    }

    public LtiVerificationResult(Boolean success, LtiLaunch ltiLaunchResult) {
        this.ltiLaunchResult = ltiLaunchResult;
        this.success = success;
    }

    public LtiVerificationResult(Boolean success, LtiError error, String message, LtiLaunch ltiLaunchResult) {
        this.success = success;
        this.error = error;
        this.message = message;
        this.ltiLaunchResult = ltiLaunchResult;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LtiError getError() {
        return error;
    }

    public void setError(LtiError error) {
        this.error = error;
    }

    public LtiLaunch getLtiLaunchResult() {
        return ltiLaunchResult;
    }

    public void setLtiLaunchResult(LtiLaunch ltiLaunchResult) {
        this.ltiLaunchResult = ltiLaunchResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
