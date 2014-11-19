/*
 * Copyright 2014 IMS Global Learning Consortium.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.imsglobal.lti2.objects.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.imsglobal.lti2.objects.consumer.ProductInstance;

/**
 *
 * @author paul
 */
public class ToolProfile {

    @JsonProperty("@id")
    @org.codehaus.jackson.annotate.JsonProperty("@id")
    private String id;
    private String lti_version;
    private JsonNode base_url_choice;
    private ProductInstance product_instance;
    private JsonNode resource_handler;
    private JsonNode message;

    public ToolProfile() {
    }

    public ToolProfile(String id, String lti_version, JsonNode base_url_choice, ProductInstance product_instance, JsonNode resource_handler, JsonNode message) {
        this.id = id;
        this.lti_version = lti_version;
        this.base_url_choice = base_url_choice;
        this.product_instance = product_instance;
        this.resource_handler = resource_handler;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLti_version() {
        return lti_version;
    }

    public void setLti_version(String lti_version) {
        this.lti_version = lti_version;
    }

    public ProductInstance getProduct_instance() {
        return product_instance;
    }

    public void setProduct_instance(ProductInstance product_instance) {
        this.product_instance = product_instance;
    }

    public JsonNode getBase_url_choice() {
        return base_url_choice;
    }

    public void setBase_url_choice(JsonNode base_url_choice) {
        this.base_url_choice = base_url_choice;
    }

    public JsonNode getResource_handler() {
        return resource_handler;
    }

    public void setResource_handler(JsonNode resource_handler) {
        this.resource_handler = resource_handler;
    }

    public JsonNode getMessage() {
        return message;
    }

    public void setMessage(JsonNode message) {
        this.message = message;
    }

}
