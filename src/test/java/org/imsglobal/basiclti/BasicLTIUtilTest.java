package org.imsglobal.basiclti;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import net.oauth.OAuthMessage;
import net.oauth.SimpleOAuthValidator;
import net.oauth.server.OAuthServlet;
import net.oauth.signature.OAuthSignatureMethod;
import org.junit.Assert;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({OAuthServlet.class, OAuthSignatureMethod.class})
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
    public void testValidateMessageFailsWhenNoConsumerKey() throws IOException, Exception{
        
        HttpServletRequest requestMock = Mockito.mock(HttpServletRequest.class);
        String url = "https://example.com/lti-launch";
        
        PowerMockito.mockStatic(OAuthServlet.class);
        OAuthMessage messageMock = Mockito.mock(OAuthMessage.class);
        
        PowerMockito.when(OAuthServlet.getMessage(requestMock, url)).thenReturn(messageMock);

        Mockito.when(messageMock.getConsumerKey()).thenThrow(new IOException("io exception"));

        LtiVerificationResult result = BasicLTIUtil.validateMessage(requestMock, url, "secret");

        Assert.assertEquals(LtiError.BAD_REQUEST, result.getError());
        Assert.assertEquals(false, result.getSuccess());
        
    }
    
    
    @Test
    public void testValidateMessageFailWhenUriIsMalformed() throws Exception {
        
        HttpServletRequest requestMock = Mockito.mock(HttpServletRequest.class);
        String url = "https://example.com/lti-launch";
        
        PowerMockito.mockStatic(OAuthSignatureMethod.class);
        PowerMockito.when(OAuthSignatureMethod.getBaseString(Matchers.any(OAuthMessage.class))).thenThrow(new URISyntaxException("","",0));
        
        //Mockito.doThrow(new URISyntaxException("","",0)).when(sovMock).validateMessage(Matchers.any(OAuthMessage.class), Matchers.any(OAuthAccessor.class));

        LtiVerificationResult result = BasicLTIUtil.validateMessage(requestMock, url, "secret");

        Assert.assertEquals(LtiError.BAD_REQUEST, result.getError());
        Assert.assertEquals(false, result.getSuccess());
        
    }

}
