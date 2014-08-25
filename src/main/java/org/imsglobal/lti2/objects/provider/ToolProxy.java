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
import org.imsglobal.lti2.objects.BaseJson;

/**
 *
 * @author pgray
 */
public class ToolProxy extends BaseJson {

    @JsonProperty("@id")
    @org.codehaus.jackson.annotate.JsonProperty("@id")
    private String id;
    @JsonProperty("@context")
    @org.codehaus.jackson.annotate.JsonProperty("@context")
    private String context;
    @JsonProperty("@type")
    @org.codehaus.jackson.annotate.JsonProperty("@type")
    private String type;
    private String tool_proxy_guid;
    private String custom_url;

    public static final String CONTENT_TYPE = "application/vnd.ims.lti.v2.toolproxy+json";
    public static final String CONTEXT_URL = "http://purl.imsglobal.org/ctx/lti/v2/ToolProxyId";

    public ToolProxy(){
    }

    public ToolProxy(String id, String type, String tool_proxy_guid, String custom_url) {
        this.id = id;
        this.type = type;
        this.tool_proxy_guid = tool_proxy_guid;
        this.custom_url = custom_url;
        this.context = CONTEXT_URL;
    }

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

    public String getTool_proxy_guid() {
        return tool_proxy_guid;
    }

    public void setTool_proxy_guid(String tool_proxy_guid) {
        this.tool_proxy_guid = tool_proxy_guid;
    }

    public String getCustom_url() {
        return custom_url;
    }

    public void setCustom_url(String custom_url) {
        this.custom_url = custom_url;
    }
}
