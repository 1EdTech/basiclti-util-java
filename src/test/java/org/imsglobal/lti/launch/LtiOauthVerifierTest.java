package org.imsglobal.lti.launch;

import org.apache.http.client.methods.HttpPost;
import org.codehaus.jackson.map.ser.std.IterableSerializer;
import org.junit.Test;

import java.net.URI;
import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by paul on 9/27/17.
 */
public class LtiOauthVerifierTest {


    LtiVerifier verifier = new LtiOauthVerifier();
    LtiSigner signer = new LtiOauthSigner();


    @Test
    public void verifierShouldAllowUrlParametersInUrlParam() throws Exception {

        String baseUrl = "http://example.com/test";
        String urlParams = "?bestLanguage=java";

        String key = "key";
        String secret = "secret";

        Collection<AbstractMap.SimpleEntry<String, String>> myEntries = Arrays.asList(
                new AbstractMap.SimpleEntry<String, String>("hm", "okasy"),
                new AbstractMap.SimpleEntry<String, String>("hm", "asdf"),
                new AbstractMap.SimpleEntry<String, String>("wat", "asdfasdff")
        );

        Collection signedParameters = signer.signParameters(myEntries, key, secret, baseUrl + urlParams, "GET");


        // including the parameters in the url should yield success
        LtiVerificationResult successResult = verifier.verifyParameters(signedParameters, baseUrl + urlParams, "GET", secret);
        assertTrue(successResult.getSuccess());

        // omitting the parameters in the url should yield failure
        LtiVerificationResult failResult = verifier.verifyParameters(signedParameters, baseUrl, "GET", secret);
        assertFalse(failResult.getSuccess());
    }

    @Test
    public void verifierShouldAllowUrlParametersInEntryMap() throws Exception {

        String baseUrl = "http://example.com/test";
        String urlParams = "?bestLanguage=java";

        String key = "key";
        String secret = "secret";

        List<AbstractMap.SimpleEntry<String, String>> myEntries = Arrays.asList(
                new AbstractMap.SimpleEntry<String, String>("hm", "okasy"),
                new AbstractMap.SimpleEntry<String, String>("hm", "asdf"),
                new AbstractMap.SimpleEntry<String, String>("wat", "asdfasdff")
        );

        Collection signedParameters = signer.signParameters(myEntries, key, secret, baseUrl + urlParams, "GET");

        List signedParamsWithUrlParams = new ArrayList<>(signedParameters);
        signedParamsWithUrlParams.add(new AbstractMap.SimpleEntry<String, String>("bestLanguage", "java"));
        // including the url parameters in the entries map should yield success
        LtiVerificationResult successResult = verifier.verifyParameters(signedParamsWithUrlParams, baseUrl, "GET", secret);
        assertTrue(successResult.getSuccess());

        // omitting the url parameters in the entries map and omitting them in the url should yield failure
        LtiVerificationResult failResult = verifier.verifyParameters(signedParameters, baseUrl, "GET", secret);
        assertFalse(failResult.getSuccess());
    }
}
