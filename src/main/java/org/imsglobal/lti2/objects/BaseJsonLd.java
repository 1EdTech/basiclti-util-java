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
package org.imsglobal.lti2.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author paul
 */
public class BaseJsonLd extends BaseJson {

    @JsonProperty("@id")
    @org.codehaus.jackson.annotate.JsonProperty("@id")
    protected String id;
    @JsonProperty("@context")
    @org.codehaus.jackson.annotate.JsonProperty("@context")
    protected String context;
    @JsonProperty("@type")
    @org.codehaus.jackson.annotate.JsonProperty("@type")
    protected String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
