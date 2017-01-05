package org.imsglobal.lti2.objects.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.imsglobal.lti2.objects.consumer.Description;
import org.imsglobal.lti2.objects.consumer.Name;

import java.util.List;

/**
 * Resource Handler Object
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResourceHandler {
    @JsonProperty("message")
    private List<Message> message;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("resource_type")
    private String resourceType;
    @JsonProperty("description")
    private Description description;

    @JsonProperty("message")
    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("resource_type")
    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @JsonProperty("description")
    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
