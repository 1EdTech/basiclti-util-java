package org.imsglobal.lti;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.SimpleOAuthValidator;
import net.oauth.server.OAuthServlet;
import net.oauth.signature.OAuthSignatureMethod;
import org.imsglobal.lti.launch.LtiError;
import org.imsglobal.lti.launch.LtiVerificationResult;
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
@PrepareForTest({OAuthServlet.class, OAuthSignatureMethod.class, SimpleOAuthValidator.class, BasicLTIUtil.class})
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
        Assert.assertEquals(Boolean.FALSE, result.getSuccess());
        
    }
    
    
    @Test
    public void testValidateMessageFailWhenUriIsMalformed() throws Exception {
        
        HttpServletRequest requestMock = Mockito.mock(HttpServletRequest.class);
        String url = "https://example.com/lti-launch";
        
        PowerMockito.mockStatic(OAuthSignatureMethod.class);
        PowerMockito.when(OAuthSignatureMethod.getBaseString(Matchers.any(OAuthMessage.class))).thenThrow(new URISyntaxException("","",0));

        LtiVerificationResult result = BasicLTIUtil.validateMessage(requestMock, url, "secret");

        Assert.assertEquals(LtiError.BAD_REQUEST, result.getError());
        Assert.assertEquals(Boolean.FALSE, result.getSuccess());
        
    }
    
    @Test
    public void testValidateMessageFailOnIOException() throws Exception {
        
        HttpServletRequest requestMock = Mockito.mock(HttpServletRequest.class);
        String url = "https://example.com/lti-launch";
        
        PowerMockito.mockStatic(OAuthSignatureMethod.class);
        PowerMockito.when(OAuthSignatureMethod.getBaseString(Matchers.any(OAuthMessage.class))).thenThrow(new IOException(""));

        LtiVerificationResult result = BasicLTIUtil.validateMessage(requestMock, url, "secret");

        Assert.assertEquals(LtiError.BAD_REQUEST, result.getError());
        Assert.assertEquals(Boolean.FALSE, result.getSuccess());
        
    }

    @Test
    public void testValidateMessageFailOnValidateMessageIOException() throws Exception {

        SimpleOAuthValidator sov = Mockito.mock(SimpleOAuthValidator.class);
        PowerMockito.whenNew(SimpleOAuthValidator.class).withNoArguments().thenReturn(sov);
        Mockito.doThrow(new IOException("failed")).when(sov).validateMessage(Matchers.any(OAuthMessage.class), Matchers.any(OAuthAccessor.class));
        PowerMockito.mockStatic(OAuthSignatureMethod.class);
        PowerMockito.when(OAuthSignatureMethod.getBaseString(Matchers.any(OAuthMessage.class))).thenReturn("");

        LtiVerificationResult result = BasicLTIUtil.validateMessage(Mockito.mock(HttpServletRequest.class), "https://example.com/lti-launch", "secret");        

        Assert.assertEquals(LtiError.BAD_REQUEST, result.getError());
        Assert.assertEquals(Boolean.FALSE, result.getSuccess());
        Assert.assertEquals(null, result.getLtiLaunchResult());
    }

    @Test
    public void testValidateMessageFailOnValidateMessageOAuthException() throws Exception {

        SimpleOAuthValidator sov = Mockito.mock(SimpleOAuthValidator.class);
        PowerMockito.whenNew(SimpleOAuthValidator.class).withNoArguments().thenReturn(sov);
        Mockito.doThrow(new OAuthException("failed")).when(sov).validateMessage(Matchers.any(OAuthMessage.class), Matchers.any(OAuthAccessor.class));
        PowerMockito.mockStatic(OAuthSignatureMethod.class);
        PowerMockito.when(OAuthSignatureMethod.getBaseString(Matchers.any(OAuthMessage.class))).thenReturn("");

        LtiVerificationResult result = BasicLTIUtil.validateMessage(Mockito.mock(HttpServletRequest.class), "https://example.com/lti-launch", "secret");

        Assert.assertEquals(LtiError.BAD_REQUEST, result.getError());
        Assert.assertEquals(Boolean.FALSE, result.getSuccess());
        Assert.assertEquals(null, result.getLtiLaunchResult());
    }

    @Test
    public void testValidateMessageFailOnValidateMessageURISyntaxException() throws Exception {

        SimpleOAuthValidator sov = Mockito.mock(SimpleOAuthValidator.class);
        PowerMockito.whenNew(SimpleOAuthValidator.class).withNoArguments().thenReturn(sov);
        Mockito.doThrow(new URISyntaxException("failed", "failed")).when(sov).validateMessage(Matchers.any(OAuthMessage.class), Matchers.any(OAuthAccessor.class));
        PowerMockito.mockStatic(OAuthSignatureMethod.class);
        PowerMockito.when(OAuthSignatureMethod.getBaseString(Matchers.any(OAuthMessage.class))).thenReturn("");

        LtiVerificationResult result = BasicLTIUtil.validateMessage(Mockito.mock(HttpServletRequest.class), "https://example.com/lti-launch", "secret");        

        Assert.assertEquals(LtiError.BAD_REQUEST, result.getError());
        Assert.assertEquals(Boolean.FALSE, result.getSuccess());
        Assert.assertEquals(null, result.getLtiLaunchResult());
    }

    @Test
    public void testValidateMessagePass() throws Exception {

        SimpleOAuthValidator sov = Mockito.mock(SimpleOAuthValidator.class);
        PowerMockito.whenNew(SimpleOAuthValidator.class).withNoArguments().thenReturn(sov);
        Mockito.doNothing().when(sov).validateMessage(Matchers.any(OAuthMessage.class), Matchers.any(OAuthAccessor.class));
        PowerMockito.mockStatic(OAuthSignatureMethod.class);
        PowerMockito.when(OAuthSignatureMethod.getBaseString(Matchers.any(OAuthMessage.class))).thenReturn("");
        
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        Mockito.when(req.getParameter("user_id")).thenReturn("pgray");
        Mockito.when(req.getParameter("roles")).thenReturn("instructor, teacher,administrator");
        Mockito.when(req.getParameter("lti_version")).thenReturn("lpv1");
        Mockito.when(req.getParameter("lti_message_type")).thenReturn("lti");
        Mockito.when(req.getParameter("resource_link_id")).thenReturn("12345");
        Mockito.when(req.getParameter("context_id")).thenReturn("9876");
        Mockito.when(req.getParameter("launch_presentation_return_url")).thenReturn("http://example.com/return");
        Mockito.when(req.getParameter("tool_consumer_instance_guid")).thenReturn("instance_id");

        LtiVerificationResult result = BasicLTIUtil.validateMessage(req, "https://example.com/lti-launch", "secret1");        

        Assert.assertEquals(null, result.getError());
        Assert.assertEquals(Boolean.TRUE, result.getSuccess());
        Assert.assertNotNull(result.getLtiLaunchResult());
        
        Assert.assertEquals("pgray", result.getLtiLaunchResult().getUser().getId());
        Assert.assertEquals(3, result.getLtiLaunchResult().getUser().getRoles().size());
        Assert.assertTrue(result.getLtiLaunchResult().getUser().getRoles().contains("instructor"));
        Assert.assertTrue(result.getLtiLaunchResult().getUser().getRoles().contains("teacher"));
        Assert.assertTrue(result.getLtiLaunchResult().getUser().getRoles().contains("administrator"));
        
        Assert.assertEquals("lpv1", result.getLtiLaunchResult().getVersion());
        Assert.assertEquals("lti", result.getLtiLaunchResult().getMessageType());
        Assert.assertEquals("12345", result.getLtiLaunchResult().getResourceLinkId());
        Assert.assertEquals("9876", result.getLtiLaunchResult().getContextId());
        Assert.assertEquals("http://example.com/return", result.getLtiLaunchResult().getLaunchPresentationReturnUrl());
        Assert.assertEquals("instance_id", result.getLtiLaunchResult().getToolConsumerInstanceGuid());
        
    }
    
}
