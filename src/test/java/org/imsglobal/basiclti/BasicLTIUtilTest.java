package org.imsglobal.basiclti;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BasicLTIUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetRealPath() {
        String fixed = BasicLTIUtil.getRealPath("http://localhost/path/blah/", "https://right.com");
        assertEquals("https://right.com/path/blah/", fixed);
        fixed = BasicLTIUtil.getRealPath("https://localhost/path/blah/", "https://right.com");
        assertEquals("https://right.com/path/blah/", fixed);
        fixed = BasicLTIUtil.getRealPath("https://localhost/path/blah/", "http://right.com");
        assertEquals("http://right.com/path/blah/", fixed);

        // Test folks sending in URL with extra stuff...
        fixed = BasicLTIUtil.getRealPath("https://localhost/path/blah/", "https://right.com/path/blah");
        assertEquals("https://right.com/path/blah/", fixed);
    }
    
    @Test
    public void testValidateMessage(){
        
        HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
        
        
        Mockito.when(mockRequest.getRequestURL()).thenReturn(new StringBuffer("http://lti-chat.paulgray.net/lti"));
        Mockito.when(mockRequest.getMethod()).thenReturn("POST");
        Map<String, String[]> parameters = new HashMap<String, String[]>();
        parameters.put("context_title", new String[]{"Stephen Thomas"});
        parameters.put("context_id", new String[]{"10050204"});
        parameters.put("launch_presentation_locale", new String[]{"en_US"});
        parameters.put("lis_person_name_full", new String[]{"Administrator User"});
        parameters.put("resource_link_id", new String[]{"10053400"});
        parameters.put("lti_version", new String[]{"LTI-1p0"});
        parameters.put("lis_person_name_given", new String[]{"Administrator"});
        parameters.put("lis_person_contact_email_primary", new String[]{""});
        parameters.put("lti_message_type", new String[]{"basic-lti-launch-request"});
        parameters.put("lis_person_name_family", new String[]{"User"});
        parameters.put("launch_presentation_return_url", new String[]{"https://localhost:8181/Users/Stephen.Thomas"});
        parameters.put("lis_person_sourced_id", new String[]{"root"});
        parameters.put("user_id", new String[]{"root"});
        parameters.put("context_type", new String[]{"User"});
        parameters.put("oauth_consumer_key", new String[]{"key"});
        parameters.put("oauth_signature_method", new String[]{"HMAC-SHA1"});
        parameters.put("oauth_timestamp", new String[]{"1400813143"});
        parameters.put("oauth_nonce", new String[]{"29897184915117"});
        parameters.put("oauth_version", new String[]{"1.0"});
        parameters.put("oauth_signature", new String[]{"bm44kRiVAFNmn4Svk4DGpL5krDw="});
        
        Mockito.when(mockRequest.getParameterMap()).thenReturn(parameters);
        
        System.out.println("******" + BasicLTIUtil.validateMessage(mockRequest, "http://lti-chat.paulgray.net/lti", "secret"));
        
        
    }

}
