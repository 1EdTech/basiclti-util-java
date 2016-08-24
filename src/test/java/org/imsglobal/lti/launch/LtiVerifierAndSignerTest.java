package org.imsglobal.lti.launch;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.junit.Test;

import static org.junit.Assert.*;
import java.net.URI;


/**
 * Created by paul on 8/24/16.
 */
public class LtiVerifierAndSignerTest {

    LtiVerifier verifier = new LtiOauthVerifier();
    LtiSigner signer = new LtiOauthSigner();

    @Test
    public void verifierShouldVerifyCorrectlySignedLtiLaunches() throws Exception {

        String key = "key";
        String secret = "secret";
        HttpPost ltiLaunch = new HttpPost(new URI("http://example.com/test"));

        signer.sign(ltiLaunch, key, secret);
        LtiVerificationResult result = verifier.verify(new MockHttpPost(ltiLaunch), secret);

        assertTrue(result.getSuccess());
    }

    @Test
    public void verifierShouldRejectIncorrectlySignedLtiLaunches() throws Exception {

        String key = "key";
        String secret = "secret";
        HttpPost ltiLaunch = new HttpPost(new URI("http://example.com/test"));

        signer.sign(ltiLaunch, key, secret);
        LtiVerificationResult result = verifier.verify(new MockHttpPost(ltiLaunch), "wrongSecret");

        assertFalse(result.getSuccess());
    }

}
