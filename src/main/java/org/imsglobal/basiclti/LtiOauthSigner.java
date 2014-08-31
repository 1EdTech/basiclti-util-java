package org.imsglobal.basiclti;

import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpRequest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.imsglobal.basiclti.BasicLTIConstants.*;

/**
 * This class <b>signs</b> LTI requests according to the Oauth 1.0 spec
 * @author  Paul Gray
 * @since   1.1
 */
public class LtiOauthSigner implements LtiSigner {

    @Override
    public HttpRequest sign(HttpRequest request, String key, String secret) throws LtiSigningException {
        CommonsHttpOAuthConsumer signer = new CommonsHttpOAuthConsumer(key, secret);
        try {
            signer.sign(request);
        } catch (OAuthMessageSignerException|OAuthExpectationFailedException|OAuthCommunicationException e) {
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

}
