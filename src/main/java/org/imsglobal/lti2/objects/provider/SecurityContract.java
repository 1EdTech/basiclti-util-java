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

import java.util.List;

/**
 *
 * @author paul
 */
public class SecurityContract {

    private String shared_secret;
    private List<Object> tool_service;
    private List<Object> end_user_service;

    public SecurityContract() {
    }

    public SecurityContract(String shared_secret, List<Object> tool_service, List<Object> end_user_service) {
        this.shared_secret = shared_secret;
        this.tool_service = tool_service;
        this.end_user_service = end_user_service;
    }

    public String getShared_secret() {
        return shared_secret;
    }

    public void setShared_secret(String shared_secret) {
        this.shared_secret = shared_secret;
    }

    public List<Object> getTool_service() {
        return tool_service;
    }

    public void setTool_service(List<Object> tool_service) {
        this.tool_service = tool_service;
    }

    public List<Object> getEnd_user_service() {
        return end_user_service;
    }

    public void setEnd_user_service(List<Object> end_user_service) {
        this.end_user_service = end_user_service;
    }

}
