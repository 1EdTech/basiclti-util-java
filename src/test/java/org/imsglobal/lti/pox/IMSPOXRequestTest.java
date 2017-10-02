package org.imsglobal.lti.pox;

import net.oauth.OAuthMessage;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.params.HttpParams;
import org.imsglobal.pox.IMSPOXRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

/**
 * Created by pgray on 7/5/14.
 */
public class IMSPOXRequestTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test(){

        String inputTestData = String.format(IMSPOXRequest.replaceResultMessage, "123", "3124567", "A", "");
        IMSPOXRequest pox = new IMSPOXRequest(inputTestData);
        Assert.assertEquals("V1.0", pox.getHeaderVersion());
		Assert.assertEquals("123", pox.getHeaderMessageIdentifier());
        Assert.assertEquals("replaceResultRequest", pox.getOperation());
        Map<String,String> bodyMap = pox.getBodyMap();
        String guid = bodyMap.get("/resultRecord/sourcedGUID/sourcedId");
        Assert.assertEquals("3124567", guid);
        String grade = bodyMap.get("/resultRecord/result/resultScore/textString");
        Assert.assertEquals("A", grade);

    }

    @Test
    public void testBuildReplaceResult() throws Exception {
		HttpPost post = IMSPOXRequest.buildReplaceResult("http://example.com", "key", "secret", "sourcedid", "0.95", "A", false);
		String header = post.getHeaders("Authorization")[0].getValue();
		InputStream input = post.getEntity().getContent();
		Reader reader = new InputStreamReader(input);
		String body = IMSPOXRequest.readPostBody(reader);

		IMSPOXRequest pox = new IMSPOXRequest(body);
		pox.setAuthHeader(header);
		pox.validatePostBody();
		Assert.assertNull(pox.errorMessage);
    }
}
