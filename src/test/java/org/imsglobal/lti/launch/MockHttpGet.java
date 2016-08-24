package org.imsglobal.lti.launch;

import org.apache.http.client.methods.HttpGet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  Paul Gray
 */
public class MockHttpGet extends BaseMockHttpServletRequest {

    private HttpGet get;

    public MockHttpGet(HttpGet req) throws Exception {
        super(req);
        this.get = req;
    }

    @Override
    public String getMethod() {
        return "GET";
    }

    @Override
    public Map getParameterMap() {
        String q = this.getQueryString();
        if(q == null) {
            return new HashMap();
        } else {
            return this.getQueryMap(this.getQueryString());
        }
    }

}
