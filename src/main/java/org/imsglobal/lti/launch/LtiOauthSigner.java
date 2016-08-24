package org.imsglobal.lti.launch;

import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.HttpParameters;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class <b>signs</b> LTI requests according to the Oauth 1.0 spec
 * @author  Paul Gray
 * @since   1.1
 */
public class LtiOauthSigner implements LtiSigner {

    private MessageDigest md;

    public LtiOauthSigner() {
        try{
            md = MessageDigest.getInstance("SHA1");
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not construct new instance of LtiOauthSigner", e);
        }
    }

    public LtiOauthSigner(MessageDigest md) {
        this.md = md;
    }

    @Override
    public HttpRequest sign(HttpRequest request, String key, String secret) throws LtiSigningException {
        CommonsHttpOAuthConsumer signer = new CommonsHttpOAuthConsumer(key, secret);
        try {
            String body = getRequestBody(request);
            String bodyHash = new String(Base64.encodeBase64(md.digest(body.getBytes())));

            HttpParameters params = new HttpParameters();
            params.put("oauth_body_hash", URLEncoder.encode(bodyHash, "UTF-8"));
            signer.setAdditionalParameters(params);

            signer.sign(request);
        } catch (OAuthMessageSignerException|OAuthExpectationFailedException|OAuthCommunicationException|IOException e) {
            throw new LtiSigningException("Exception encountered while singing Lti request...", e);
        }
        return request;
    }

    @Override
    public Map<String, String> signParameters(Map<String, String> parameters, String key, String secret, String url, String method) throws LtiSigningException {
        OAuthMessage oam = new OAuthMessage(method, url, parameters.entrySet());
        OAuthConsumer cons = new OAuthConsumer(null, key, secret, null);
        OAuthAccessor acc = new OAuthAccessor(cons);
        try {
            oam.addRequiredParameters(acc);

            Map<String, String> signedParameters = new HashMap<>();
            for(Map.Entry<String, String> param : oam.getParameters()){
                signedParameters.put(param.getKey(), param.getValue());
            }
            return signedParameters;
        } catch (OAuthException |IOException |URISyntaxException e) {
            throw new LtiSigningException("Error signing LTI request.", e);
        }
    }

    private String getRequestBody(HttpRequest req) throws IOException {
        if(req instanceof HttpEntityEnclosingRequest){
            HttpEntity body = ((HttpEntityEnclosingRequest) req).getEntity();
            if(body == null) {
                return "";
            } else {
                return IOUtils.toString(body.getContent());
            }
        } else {
            // requests with no entity have an empty string as the body
            return "";
        }
    }

}
