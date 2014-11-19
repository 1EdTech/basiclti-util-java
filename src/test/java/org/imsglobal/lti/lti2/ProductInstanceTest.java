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

package org.imsglobal.lti.lti2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import junit.framework.Assert;
import org.imsglobal.lti2.objects.consumer.ProductInstance;
import org.junit.Test;

/**
 *
 * @author pgray
 */
public class ProductInstanceTest {
    
    public String getJson(Object o, Boolean prettyPrint) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if(prettyPrint){
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
        return mapper.writeValueAsString(o);
    }
    
    public <T> T toObject(String json, Class<T> claz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, claz);
    }
    
    @Test
    public void serializeProfile() throws JsonProcessingException{
        ProductInstance ppi = new ProductInstance(new TestLtiConsumerProfile());
        ppi.addAdditionalProperty("test", "yolo");
        ppi.addAdditionalProperty("another_test", "swag");
        System.out.println(getJson(ppi, true));
    }
    
    @Test
    public void deserializeProfile() throws JsonProcessingException, IOException{
        ProductInstance ppi = new ProductInstance(new TestLtiConsumerProfile());
        ppi.addAdditionalProperty("test", "yolo");
        ppi.addAdditionalProperty("another_test", "swag");
        
        String json = getJson(ppi, false);
        
        ProductInstance pi = toObject(json, ProductInstance.class);
        
        Assert.assertEquals("1", pi.getGuid());
        Assert.assertEquals("yolo", pi.getAdditionalProperties().get("test"));
        Assert.assertEquals("swag", pi.getAdditionalProperties().get("another_test"));
    }
    
}
