package org.imsglobal.basiclti;

import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpRequest;

/**
 * Created by pgray on 8/23/14.
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

}
