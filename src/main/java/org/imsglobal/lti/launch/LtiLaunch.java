package org.imsglobal.lti.launch;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by paul on 5/28/14.
 */
public class LtiLaunch {

    private LtiUser user;

    private String version;
    private String messageType;
    private String resourceLinkId;

    private String contextId;
    private String launchPresentationReturnUrl;
    private String toolConsumerInstanceGuid;

    public LtiLaunch(HttpServletRequest request) {
        this.user = new LtiUser(request);
        this.version = request.getParameter("lti_version");
        this.messageType = request.getParameter("lti_message_type");
        this.resourceLinkId = request.getParameter("resource_link_id");
        this.contextId = request.getParameter("context_id");
        this.launchPresentationReturnUrl = request.getParameter("launch_presentation_return_url");
        this.toolConsumerInstanceGuid = request.getParameter("tool_consumer_instance_guid");
    }

    public LtiLaunch(Map<String, String> parameters) {
        this.user = new LtiUser(parameters);
        this.version = parameters.get("lti_version");
        this.messageType = parameters.get("lti_message_type");
        this.resourceLinkId = parameters.get("resource_link_id");
        this.contextId = parameters.get("context_id");
        this.launchPresentationReturnUrl = parameters.get("launch_presentation_return_url");
        this.toolConsumerInstanceGuid = parameters.get("tool_consumer_instance_guid");
    }

    public LtiUser getUser() {
        return user;
    }

    public void setUser(LtiUser user) {
        this.user = user;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getResourceLinkId() {
        return resourceLinkId;
    }

    public void setResourceLinkId(String resourceLinkId) {
        this.resourceLinkId = resourceLinkId;
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    public String getLaunchPresentationReturnUrl() {
        return launchPresentationReturnUrl;
    }

    public void setLaunchPresentationReturnUrl(String launchPresentationReturnUrl) {
        this.launchPresentationReturnUrl = launchPresentationReturnUrl;
    }

    public String getToolConsumerInstanceGuid() {
        return toolConsumerInstanceGuid;
    }

    public void setToolConsumerInstanceGuid(String toolConsumerInstanceGuid) {
        this.toolConsumerInstanceGuid = toolConsumerInstanceGuid;
    }
}
