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

import org.imsglobal.lti2.LTI2Config;
import org.imsglobal.lti2.objects.consumer.ToolConsumer;

/**
 *
 * @author pgray
 */
public class TestLtiConsumerProfile implements LTI2Config {

    public static String GUID = "1";
    public static String SUPPORT_EMAIL = "test@example.com";

    @Override
    public String getGuid() {
        return GUID;
    }

    @Override
    public String getSupport_email() {
        return SUPPORT_EMAIL;
    }

    @Override
    public String getService_owner_id() {
        return null;
    }

    @Override
    public String getService_owner_owner_name() {
        return null;
    }

    @Override
    public String getService_owner_description() {
        return null;
    }

    @Override
    public String getService_owner_support_email() {
        return null;
    }

    @Override
    public String getService_provider_id() {
        return null;
    }

    @Override
    public String getService_provider_provider_name() {
        return null;
    }

    @Override
    public String getService_provider_description() {
        return null;
    }

    @Override
    public String getService_provider_support_email() {
        return null;
    }

    @Override
    public String getProduct_family_product_code() {
        return null;
    }

    @Override
    public String getProduct_family_vendor_code() {
        return null;
    }

    @Override
    public String getProduct_family_vendor_name() {
        return null;
    }

    @Override
    public String getProduct_family_vendor_description() {
        return null;
    }

    @Override
    public String getProduct_family_vendor_website() {
        return null;
    }

    @Override
    public String getProduct_family_vendor_contact() {
        return null;
    }

    @Override
    public String getProduct_info_product_name() {
        return null;
    }

    @Override
    public String getProduct_info_product_version() {
        return "1.0.0";
    }

    @Override
    public String getProduct_info_product_description() {
        return null;
    }

    public String[] getCapabilities() {
        String[] caps = {
            ToolConsumer.LtiCapability.BASICLTI_LAUNCH,
            ToolConsumer.LtiCapability.USER_ID
        };
        return caps;
    }
}
