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

import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;

/**
 *
 * @author pgray
 */
public class BaseJson {
    
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    @com.fasterxml.jackson.annotation.JsonAnyGetter
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    
    @com.fasterxml.jackson.annotation.JsonAnySetter
    @JsonAnySetter
    public void addAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
}
