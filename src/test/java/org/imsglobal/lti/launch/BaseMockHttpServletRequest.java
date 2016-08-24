package org.imsglobal.lti.launch;


import org.apache.http.Header;
import org.apache.http.HttpRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.Principal;
import java.util.*;

/**
 * @author  Paul Gray
 */
public abstract class BaseMockHttpServletRequest implements HttpServletRequest {

    HttpRequest req;

    public BaseMockHttpServletRequest(HttpRequest req) {
        this.req = req;
    }

    @Override
    public String getAuthType() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Cookie[] getCookies() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public long getDateHeader(String name) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getHeader(String name) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Enumeration getHeaders(String name) {
        List<String> headerStrs = new ArrayList<>();
        for(Header hdr: Arrays.asList(req.getHeaders(name))){
            headerStrs.add(hdr.getValue());
        }
        return Collections.enumeration(headerStrs);
    }

    @Override
    public Enumeration getHeaderNames() {
        List<String> headerNames = new LinkedList<>();
        for(Header hdr: req.getAllHeaders()) {
            headerNames.add(hdr.getName());
        }
        return Collections.enumeration(headerNames);
    }

    @Override
    public int getIntHeader(String name) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getMethod() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getPathInfo() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getPathTranslated() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getContextPath() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getQueryString() {
        try {
            String q = new URI(req.getRequestLine().getUri()).getQuery();
            return q;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getRemoteUser() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public boolean isUserInRole(String role) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Principal getUserPrincipal() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getRequestedSessionId() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getRequestURI() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public StringBuffer getRequestURL() {
        try {
            String url = req.getRequestLine().getUri().replaceFirst("\\?(.*)", "");
            return new StringBuffer(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getServletPath() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public HttpSession getSession(boolean create) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public HttpSession getSession() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Object getAttribute(String name) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Enumeration getAttributeNames() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getCharacterEncoding() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException {

    }

    @Override
    public int getContentLength() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getContentType() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getParameter(String name) {
        return (String) this.getParameterMap().get(name);
    }

    @Override
    public Enumeration getParameterNames() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String[] getParameterValues(String name) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Map getParameterMap() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getProtocol() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getScheme() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getServerName() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public int getServerPort() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public BufferedReader getReader() throws IOException {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getRemoteAddr() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getRemoteHost() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public void setAttribute(String name, Object o) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public Locale getLocale() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Enumeration getLocales() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public boolean isSecure() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getRealPath(String path) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public int getRemotePort() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getLocalName() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public String getLocalAddr() {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public int getLocalPort() {
        throw new UnsupportedOperationException("unsupported");
    }

    protected static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }
}
