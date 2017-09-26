package org.imsglobal.lti.launch;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.junit.Test;

import static org.junit.Assert.*;
import java.net.URI;
import java.util.*;


/**
 * @author  Paul Gray
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

    @Test
    public void verifierShouldVerifyCorrectlySignedLtiGetServiceRequests() throws Exception {

        String key = "key";
        String secret = "secret";
        HttpGet ltiServiceGetRequest = new HttpGet(new URI("http://example.com/test"));

        signer.sign(ltiServiceGetRequest, key, secret);
        LtiVerificationResult result = verifier.verify(new MockHttpGet(ltiServiceGetRequest), secret);

        assertTrue(result.getSuccess());
    }

    @Test
    public void verifierShouldDoStuff() throws Exception {

        String key = "key";
        String secret = "secret";

        Collection<AbstractMap.SimpleEntry<String, String>> myEntries = Arrays.asList(
            new AbstractMap.SimpleEntry<String, String>("hm", "okasy"),
            new AbstractMap.SimpleEntry<String, String>("hm", "asdf"),
            new AbstractMap.SimpleEntry<String, String>("wat", "asdfasdff")
        );

        Collection signedEntries = signer.signParameters(myEntries, key, secret, "http://example.com/test", "GET");
        LtiVerificationResult result = verifier.verifyParameters(signedEntries, "http://example.com/test", "GET", secret);

        assertTrue(result.getSuccess());
    }

}
