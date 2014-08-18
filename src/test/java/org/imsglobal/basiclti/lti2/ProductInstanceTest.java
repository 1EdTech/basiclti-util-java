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

package org.imsglobal.basiclti.lti2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.imsglobal.lti2.objects.ProductInstance;
import org.imsglobal.lti2.objects.ToolConsumer;
import org.junit.Test;

/**
 *
 * @author pgray
 */
public class ProductInstanceTest {
    
    public void printObject(Object o) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(mapper.writeValueAsString(o));
    }
    
    @Test
    public void TestProfile() throws JsonProcessingException{
        ProductInstance ppi = new ProductInstance(new TestLtiConsumerProfile());
        ppi.setAdditionalProperties("test", "yolo");
        printObject(ppi);
    }
    
}
