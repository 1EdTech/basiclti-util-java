package org.imsglobal.lti.lti2;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.imsglobal.lti2.objects.consumer.ProductInstance;
import org.imsglobal.lti2.objects.provider.Message;
import org.imsglobal.lti2.objects.provider.ResourceHandler;
import org.imsglobal.lti2.objects.provider.ToolProfile;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Test ToolProfile
 */
public class ToolProfileTest {
    String testToolProfile = "{\n" +
            "    \"@type\": \"ToolProfile\",\n" +
            "    \"@id\":\"testProfileId\",\n"+
            "    \"product_instance\": {\n" +
            "        \"product_info\": {\n" +
            "            \"product_version\": \"1.0\",\n" +
            "            \"technical_description\": {\n" +
            "                \"default_value\": \"Support provided forLTI 2\",\n" +
            "                \"key\": \"tool.technical\"\n" +
            "            },\n" +
            "            \"product_name\": {\n" +
            "                \"default_value\": \"Course Viewer\",\n" +
            "                \"key\": \"tool.name\"\n" +
            "            },\n" +
            "            \"description\": {\n" +
            "                \"default_value\": \"LMS Course Viewer\",\n" +
            "                \"key\": \"tool.description\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"support\": {\n" +
            "            \"email\": \"support@support.com\"\n" +
            "        },\n" +
            "        \"guid\": \"fd75124a-140e-470f-944c-114d2d92bb40\",\n" +
            "        \"service_provider\": {\n" +
            "            \"support\": {\n" +
            "                \"email\": \"support@support.com\"\n" +
            "            },\n" +
            "            \"description\": {\n" +
            "                \"default_value\": \"Provider of high performance managed hosting environments\",\n" +
            "                \"key\": \"service_provider.description\"\n" +
            "            },\n" +
            "            \"timestamp\": \"2012-04-05T09:08:16-04:00\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"lti_version\": \"LTI-2p0\",\n" +
            "    \"message\": [\n" +
            "        {\n" +
            "            \"message_type\":\"ToolProxyRegistrationRequest\"\n," +
            "            \"enabled_capability\": [\n" +
            "               \"ToolConsumerProfile.url\"\n" +
            "            ],\n" +
            "            \"path\": \"/Registrations\",\n" +
            "            \"parameter\": [\n" +
            "                {\n" +
            "                    \"variable\": \"ToolConsumerProfile.url\",\n" +
            "                    \"name\": \"tc_profile_url\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"resource_handler\": [\n" +
            "        {\n" +
            "            \"message\": [\n" +
            "                {\n" +
            "                    \"path\": \"/bookshelves\",\n" +
            "                    \"parameter\": [\n" +
            "                        {\n" +
            "                            \"variable\": \"CourseOffering.label\",\n" +
            "                            \"name\": \"course_label\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"enabled_capability\": [\n" +
            "                       \"CourseOffering.label\"\n" +
            "                      ],\n" +
            "                    \"message_type\": \"basic-lti-launch-request\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"name\": {\n" +
            "                \"default_value\": \"Bookshelf\",\n" +
            "                \"key\": \"resource.name\"\n" +
            "            },\n" +
            "            \"resource_type\": \"bookshelf\",\n" +
            "            \"description\": {\n" +
            "                \"default_value\": \"VitalSource Bookshelf\",\n" +
            "                \"key\": \"resource.description\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"message\": [\n" +
            "                {\n" +
            "                    \"path\": \"/echoes\",\n" +
            "                    \"parameter\": [\n" +
            "                        {\n" +
            "                            \"fixed\": \"Narcissus\",\n" +
            "                            \"name\": \"referrer\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"fixed\": \"3.14159\",\n" +
            "                            \"name\": \"pi\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"variable\": \"Person.email.primary\",\n" +
            "                            \"name\": \"user_primary_email\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"variable\": \"CourseOffering.label\",\n" +
            "                            \"name\": \"discipline\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"enabled_capability\": [\n" +
            "                         \"Person.email.primary\",\n" +
            "                         \"CourseOffering.label\"\n" +
            "                      ],\n" +
            "                    \"message_type\": \"basic-lti-launch-request\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"name\": {\n" +
            "                \"default_value\": \"Echo\",\n" +
            "                \"key\": \"resource.name\"\n" +
            "            },\n" +
            "            \"resource_type\": \"echo\",\n" +
            "            \"description\": {\n" +
            "                \"default_value\": \"Echo service\",\n" +
            "                \"key\": \"resource.description\"\n" +
            "            }\n" +
            "        }\n" +
            "    ],\n" +
            "    \"base_url_choice\": [\n" +
            "        {\n" +
            "            \"selector\": {\n" +
            "                \"applies_to\": [\n" +
            "                    \"IconEndpoint\",\n" +
            "                    \"MessageHandler\"\n" +
            "                ]\n" +
            "            },\n" +
            "            \"secure_base_url\": \"viewer/secure/url\",\n" +
            "            \"default_base_url\": \"viewer/base/url\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    private ToolProfile toolProfile;
    @Before
    public void setUp() throws IOException {
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        toolProfile = mapper.readValue(testToolProfile,ToolProfile.class);
    }

    @Test
    public void testToolProfile(){
        assertTrue("ToolProfile".equalsIgnoreCase(toolProfile.get_type()));
        assertTrue("testProfileId".equalsIgnoreCase(toolProfile.get_id()));
        assertTrue("LTI-2p0".equalsIgnoreCase(toolProfile.getLti_version()));
        List<Message> toolMessage = toolProfile.getMessage();
        assertTrue("/Registrations".equalsIgnoreCase(toolMessage.get(0).getPath()));
        assertTrue("ToolProxyRegistrationRequest".equalsIgnoreCase(toolMessage.get(0).getMessageType()));
        assertTrue("ToolConsumerProfile.url".equalsIgnoreCase(toolMessage.get(0).getEnabledCapability().get(0)));
        assertTrue("ToolConsumerProfile.url".equalsIgnoreCase(toolMessage.get(0).getParameter().get(0).getVariable()));
        ProductInstance productInstance = toolProfile.getProduct_instance();
        assertTrue("fd75124a-140e-470f-944c-114d2d92bb40".equalsIgnoreCase(productInstance.getGuid()));
        assertTrue("1.0".equalsIgnoreCase(productInstance.getProduct_info().getProduct_version()));
        assertTrue("support@support.com".equalsIgnoreCase(productInstance.getService_provider().getSupport().getEmail()));
    }

    @Test
    public void testToolProfileGetResourceHandlers(){
        List<ResourceHandler> resourceHandlerNodeList = toolProfile.getResource_handler();
        assertTrue(2== resourceHandlerNodeList.size());
        ResourceHandler resourceHandler1 = resourceHandlerNodeList.get(0);
        Message message1 = resourceHandler1.getMessage().get(0);
        assertTrue("/bookshelves".equalsIgnoreCase(message1.getPath()));
        ResourceHandler resourceHandler2 = resourceHandlerNodeList.get(1);
        Message message2 = resourceHandler2.getMessage().get(0);
        assertTrue("/echoes".equalsIgnoreCase(message2.getPath()));
    }

}
