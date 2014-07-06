package org.imsglobal.basiclti.pox;

import org.imsglobal.basiclti.XMLMap;
import org.imsglobal.pox.IMSPOXRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

        String inputTestData = String.format(IMSPOXRequest.replaceResultMessage, "3124567", "A", "");
        IMSPOXRequest pox = new IMSPOXRequest(inputTestData);
        Assert.assertEquals("V1.0", pox.getHeaderVersion());
        Assert.assertEquals("replaceResultRequest", pox.getOperation());
        Map<String,String> bodyMap = pox.getBodyMap();
        String guid = bodyMap.get("/resultRecord/sourcedGUID/sourcedId");
        Assert.assertEquals("3124567", guid);
        String grade = bodyMap.get("/resultRecord/result/resultScore/textString");
        Assert.assertEquals("A", grade);

    }
}
