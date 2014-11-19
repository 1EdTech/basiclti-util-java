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

/**
 *
 * @author paul
 */
public class BaseUrlChoice {

    private String default_base_url;
    private String secure_base_url;
    private Object selector;

    public BaseUrlChoice() {
    }

    public BaseUrlChoice(String default_base_url, String secure_base_url, Object selector) {
        this.default_base_url = default_base_url;
        this.secure_base_url = secure_base_url;
        this.selector = selector;
    }

    public String getDefault_base_url() {
        return default_base_url;
    }

    public void setDefault_base_url(String default_base_url) {
        this.default_base_url = default_base_url;
    }

    public String getSecure_base_url() {
        return secure_base_url;
    }

    public void setSecure_base_url(String secure_base_url) {
        this.secure_base_url = secure_base_url;
    }

    public Object getSelector() {
        return selector;
    }

    public void setSelector(Object selector) {
        this.selector = selector;
    }

}
