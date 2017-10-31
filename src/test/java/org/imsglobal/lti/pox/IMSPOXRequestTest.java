package org.imsglobal.lti.pox;

import org.apache.http.client.methods.HttpPost;
import org.imsglobal.pox.IMSPOXRequest;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

/**
 * Created by pgray on 7/5/14.
 */
public class IMSPOXRequestTest {

    @Test
    public void test() {

        String messageId = String.valueOf(new Date().getTime());
        String inputTestData = String.format(IMSPOXRequest.ReplaceResultMessageTemplate, messageId, "3124567", "A", "");
        IMSPOXRequest pox = new IMSPOXRequest(inputTestData);
        Assert.assertEquals("V1.0", pox.getHeaderVersion());
        Assert.assertEquals("replaceResultRequest", pox.getOperation());
        Assert.assertEquals("should match messageId", messageId, pox.getHeaderMessageIdentifier());

        Map<String, String> bodyMap = pox.getBodyMap();
        String guid = bodyMap.get("/resultRecord/sourcedGUID/sourcedId");
        Assert.assertEquals("3124567", guid);
        String grade = bodyMap.get("/resultRecord/result/resultScore/textString");
        Assert.assertEquals("A", grade);
        String resultScoreLang = bodyMap.get("/resultRecord/result/resultScore/language");
        Assert.assertEquals("should have resultScore lang set to en", "en", resultScoreLang);
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
