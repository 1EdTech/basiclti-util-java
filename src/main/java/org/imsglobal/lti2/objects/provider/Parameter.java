package org.imsglobal.lti2.objects.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Parameter Object
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Parameter {
    @JsonProperty("variable")
    private String variable;
    @JsonProperty("name")
    private String name;
    @JsonProperty("fixed")
    private String fixed;

    @JsonProperty("variable")
    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("fixed")
    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }
}
