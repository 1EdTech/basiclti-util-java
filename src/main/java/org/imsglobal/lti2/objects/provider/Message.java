package org.imsglobal.lti2.objects.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * Message Object
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Message {
    @JsonProperty("path")
    private String path;
    @JsonProperty("parameter")
    private List<Parameter> parameter;
    @JsonProperty("message_type")
    private String messageType;
    @JsonProperty("enabled_capability")
    private List<String> enabledCapability;

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("parameter")
    public List<Parameter> getParameter() {
        return parameter;
    }

    public void setParameter(List<Parameter> parameter) {
        this.parameter = parameter;
    }

    @JsonProperty("message_type")
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @JsonProperty("enabled_capability")
    public List<String> getEnabledCapability() {
        return enabledCapability;
    }

    public void setEnabledCapability(List<String> enabledCapability) {
        this.enabledCapability = enabledCapability;
    }
}
