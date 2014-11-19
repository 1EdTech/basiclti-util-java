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

import org.codehaus.jackson.JsonNode;
import org.imsglobal.lti2.objects.BaseJsonLd;

/**
 *
 * @author pgray
 */
public class ToolProxy extends BaseJsonLd {

    private String tool_proxy_guid;
    private String custom_url;
    private String lti_version;
    private String tool_consumer_profile;
    private ToolProfile tool_profile;
    private Object custom;
    private SecurityContract security_contract;

    public static final String CONTENT_TYPE = "application/vnd.ims.lti.v2.toolproxy+json";
    public static final String CONTEXT_URL = "http://purl.imsglobal.org/ctx/lti/v2/ToolProxyId";
    public static final String TYPE = "http://purl.imsglobal.org/ctx/lti/v2/ToolProxyId";

    public ToolProxy(){
    }

    public ToolProxy(String id, String type, String tool_proxy_guid, String custom_url) {
        this.id = id;
        this.type = type;
        this.tool_proxy_guid = tool_proxy_guid;
        this.custom_url = custom_url;
        this.context = CONTEXT_URL;
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

    public String getLti_version() {
        return lti_version;
    }

    public void setLti_version(String lti_version) {
        this.lti_version = lti_version;
    }

    public String getTool_consumer_profile() {
        return tool_consumer_profile;
    }

    public void setTool_consumer_profile(String tool_consumer_profile) {
        this.tool_consumer_profile = tool_consumer_profile;
    }

    public ToolProfile getTool_profile() {
        return tool_profile;
    }

    public void setTool_profile(ToolProfile tool_profile) {
        this.tool_profile = tool_profile;
    }

    public Object getCustom() {
        return custom;
    }

    public void setCustom(Object custom) {
        this.custom = custom;
    }

    public SecurityContract getSecurity_contract() {
        return security_contract;
    }

    public void setSecurity_contract(SecurityContract security_contract) {
        this.security_contract = security_contract;
    }
    
}
