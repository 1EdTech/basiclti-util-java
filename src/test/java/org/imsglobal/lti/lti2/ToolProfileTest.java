package org.imsglobal.lti.lti2;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
    String testToolProfile = "{" +
            "    \"@context\": \"http://purl.imsglobal.org/ctx/lti/v2/ToolProfile\",\n" +
            "    \"@type\": \"ToolProfile\",\n" +
            "    \"@id\": \"testProfileId\",\n" +
            "    \"lti_version\": \"LTI-2p0\",\n" +
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
            "    ],\n" +
            "    \"product_instance\": {\n" +
            "        \"guid\": \"fd75124a-140e-470f-944c-114d2d92bb40\",\n" +
            "        \"product_info\": {\n" +
            "            \"product_name\": {\n" +
            "                \"default_value\": \"CourseViewer\",\n" +
            "                \"key\": \"tool.name\",\n" +
            "                \"additionalProperties\": {\n" +
            "                \"default_value\": \"Test Description\",\n" +
            "                \"key\": \"test_description\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"product_version\": \"1.0\",\n" +
            "            \"description\": {\n" +
            "                \"default_value\": \"LMSCourseViewer\",\n" +
            "                \"key\": \"tool.description\",\n" +
            "                \"additionalProperties\": {\n" +
            "                \"default_value\": \"Test Description\",\n" +
            "                \"key\": \"test_description\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"technical_description\": {\n" +
            "                \"default_value\": \"SupportprovidedforLTI2\",\n" +
            "                \"key\": \"tool.technical\",\n" +
            "                \"additionalProperties\": {\n" +
            "                \"default_value\": \"test technical description\",\n" +
            "                \"key\": \"test_technical_description\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"product_family\": null\n" +
            "        },\n" +
            "        \"service_owner\": null,\n" +
            "        \"service_provider\": {\n" +
            "            \"_id\": null,\n" +
            "            \"service_provider_name\": null,\n" +
            "            \"description\": {\n" +
            "                \"default_value\": \"Providerofhighperformancemanagedhostingenvironments\",\n" +
            "                \"key\": \"service_provider.description\",\n" +
            "                \"additionalProperties\": {\n" +
            "                \"default_value\": \"Service_Provider\",\n" +
            "                \"key\": \"service_provider\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"timestamp\": \"2012-04-05T09: 08: 16-04: 00\",\n" +
            "            \"support\": {\n" +
            "                \"email\": \"support@support.com\",\n" +
            "                \"additionalProperties\": {\n" +
            "                    \n" +
            "                }\n" +
            "            },\n" +
            "            \"additionalProperties\": {\n" +
            "                \n" +
            "            }\n" +
            "        },\n" +
            "        \"support\": {\n" +
            "            \"email\": \"support@support.com\",\n" +
            "            \"additionalProperties\": {\n" +
            "                \n" +
            "            }\n" +
            "        }\n" +
            "    },\n" +
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
            "                    \"message_type\": \"basic-lti-launch-request\",\n" +
            "                    \"enabled_capability\": [\n" +
            "                        \"CourseOffering.label\"\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"name\": {\n" +
            "                \"default_value\": \"Bookshelf\",\n" +
            "                \"key\": \"resource.name\",\n" +
            "                \"additionalProperties\": {\n" +
            "                \"default_value\": \"message name\",\n" +
            "                \"key\": \"message_name\"\n" +
            "                    \n" +
            "                }\n" +
            "            },\n" +
            "            \"resource_type\": \"bookshelf\",\n" +
            "            \"description\": {\n" +
            "                \"default_value\": \"VitalSourceBookshelf\",\n" +
            "                \"key\": \"resource.description\",\n" +
            "                \"additionalProperties\": {\n" +
            "                \"default_value\": \"message description\",\n" +
            "                \"key\": \"message_description\"\n" +
            "                    \n" +
            "                }\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"message\": [\n" +
            "                {\n" +
            "                    \"path\": \"/echoes\",\n" +
            "                    \"parameter\": [\n" +
            "                        {\n" +
            "                            \"name\": \"referrer\",\n" +
            "                            \"fixed\": \"Narcissus\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"name\": \"pi\",\n" +
            "                            \"fixed\": \"3.14159\"\n" +
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
            "                    \"message_type\": \"basic-lti-launch-request\",\n" +
            "                    \"enabled_capability\": [\n" +
            "                        \"Person.email.primary\",\n" +
            "                        \"CourseOffering.label\"\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"name\": {\n" +
            "                \"default_value\": \"Echo\",\n" +
            "                \"key\": \"resource.name\",\n" +
            "                \"additionalProperties\": {\n" +
            "                    \n" +
            "                }\n" +
            "            },\n" +
            "            \"resource_type\": \"echo\",\n" +
            "            \"description\": {\n" +
            "                \"default_value\": \"Echoservice\",\n" +
            "                \"key\": \"resource.description\",\n" +
            "                \"additionalProperties\": {\n" +
            "                    \n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    ],\n" +
            "    \"message\": [\n" +
            "        {\n" +
            "            \"path\": \"/Registrations\",\n" +
            "            \"parameter\": [\n" +
            "                {\n" +
            "                    \"variable\": \"ToolConsumerProfile.url\",\n" +
            "                    \"name\": \"tc_profile_url\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"message_type\": \"ToolProxyRegistrationRequest\",\n" +
            "            \"enabled_capability\": [\n" +
            "                \"ToolConsumerProfile.url\"\n" +
            "            ]\n" +
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
        assertTrue("http://purl.imsglobal.org/ctx/lti/v2/ToolProfile".equalsIgnoreCase(toolProfile.get_context().toString()));
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
        assertTrue("Test Description".equalsIgnoreCase((String)productInstance.getProduct_info().getDescription().getAdditionalProperties().get("default_value")));
        assertTrue("test_description".equalsIgnoreCase((String)productInstance.getProduct_info().getDescription().getAdditionalProperties().get("key")));
        assertTrue("Service_Provider".equalsIgnoreCase((String) productInstance.getService_provider().getDescription().getAdditionalProperties().get("default_value")));
        assertTrue("service_provider".equalsIgnoreCase((String) productInstance.getService_provider().getDescription().getAdditionalProperties().get("key")));
        assertTrue("test technical description".equalsIgnoreCase((String) productInstance.getProduct_info().getTechnical_description().getAdditionalProperties().get("default_value")));
        assertTrue("test_technical_description".equalsIgnoreCase((String) productInstance.getProduct_info().getTechnical_description().getAdditionalProperties().get("key")));
        assertTrue("support@support.com".equalsIgnoreCase(productInstance.getService_provider().getSupport().getEmail()));
        assertTrue("Test Description".equalsIgnoreCase((String)productInstance.getProduct_info().getProduct_name().getAdditionalProperties().get("default_value")));
        assertTrue("test_description".equalsIgnoreCase((String)productInstance.getProduct_info().getProduct_name().getAdditionalProperties().get("key")));

    }

    @Test
    public void testToolProfileGetResourceHandlers(){
        List<ResourceHandler> resourceHandlerNodeList = toolProfile.getResource_handler();
        assertTrue(2== resourceHandlerNodeList.size());
        ResourceHandler resourceHandler1 = resourceHandlerNodeList.get(0);
        assertTrue("message name".equalsIgnoreCase((String)resourceHandler1.getName().getAdditionalProperties().get("default_value")));
        assertTrue("message_name".equalsIgnoreCase((String)resourceHandler1.getName().getAdditionalProperties().get("key")));
        assertTrue("message description".equalsIgnoreCase((String)resourceHandler1.getDescription().getAdditionalProperties().get("default_value")));
        assertTrue("message_description".equalsIgnoreCase((String) resourceHandler1.getDescription().getAdditionalProperties().get("key")));
        Message message1 = resourceHandler1.getMessage().get(0);
        assertTrue("/bookshelves".equalsIgnoreCase(message1.getPath()));
        ResourceHandler resourceHandler2 = resourceHandlerNodeList.get(1);
        Message message2 = resourceHandler2.getMessage().get(0);
        assertTrue("/echoes".equalsIgnoreCase(message2.getPath()));
    }

    @Test
    public void testDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        String json = mapper.writeValueAsString(toolProfile);
        json = json.replaceAll("\\s+","");
        String testToolProfileWithoutWhiteSpaces = testToolProfile.replaceAll("\\s+", "");
        System.out.println(testToolProfileWithoutWhiteSpaces);
        System.out.println(json);
        assertTrue(testToolProfileWithoutWhiteSpaces.equalsIgnoreCase(json));
    }

}
