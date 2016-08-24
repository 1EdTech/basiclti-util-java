package org.imsglobal.lti.launch;

import org.apache.http.client.methods.HttpPost;

import java.util.*;

/**
 * @author  Paul Gray
 */
public class MockHttpPost extends BaseMockHttpServletRequest {

    private HttpPost post;

    public MockHttpPost(HttpPost req) throws Exception {
        super(req);
        this.post = req;
    }

    @Override
    public String getMethod() {
        return "POST";
    }

    @Override
    public Map getParameterMap() {
        //todo: merge this with multipart body
        String q = this.getQueryString();
        if(q == null) {
            return new HashMap();
        } else {
            return this.getQueryMap(this.getQueryString());
        }
    }
}
