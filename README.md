#IMS Global - LTI™ Utilities

[![Build Status](https://travis-ci.org/pfgray/basiclti-util-java.svg?branch=master)](https://travis-ci.org/pfgray/basiclti-util-java)

What is it?
-----------

LTI™ Utilities are a set of utility classes to aid  in the development
of LTI v1.0 consumers and providers. They deal with much of the heavy lifting
and make the process more opaque to the developer.


How to use:
-----------

With Maven:  
Include in your project's `pom.xml`:

```xml
<dependency>
  <groupId>org.imsglobal</groupId>
  <artifactId>basiclti-util</artifactId>
  <version>1.1.2</version>
</dependency>
```

This library provides support for:

**Tool Providers**:

  1. Verifying an LTI launch request
  2. Sending LTI 1.1 Outcomes request (xml-based)
  3. AspectJ launch verifiers for easy integration with Spring-web.

**Tool Consumers**s:

  1. Creating a valid LTI launch request

Some exploratory support for LTIv2:

  1. Parsing Tool Profiles
  2. Validating Tool Capabilities & Services


LTI Providers:
----

**Verifying an LTI launch request.**

```java
HttpServletRequest request; // java servlet request
LtiVerifier ltiVerifier = new LtiOauthVerifier();
String key = request.getParameter("oauth_consumer_key");
String secret = // retrieve corresponding secret for key from db
LtiVerificationResult ltiResult = ltiVerifier.verify(request, secret);
```

**Sending LTI 1.1 Outcomes request (xml-based).**

```java
//send Request directly
IMSPOXRequest.sendReplaceResult(url, key, secret, sourcedid, score);

//or build the request to send later:
HttpPost request = IMSPOXRequest.buildReplaceResult(url, key, secret, sourcedid, score, true);
```

**AspectJ launch verifiers for easy integration with Spring-web.**

Spring Controller (LTI Producer):
```java
@Lti
@RequestMapping(value = "/lti", method = RequestMethod.POST)
public String ltiEntry(HttpServletRequest request, LtiVerificationResult result) {
    if(!result.getSuccess()){
        return "error";
    } else {
        return "success";
    }
}
```

KeyService Implementation:
```java
public class MockKeyService implements LtiKeySecretService {
    public String getSecretForKey(String key) {
        return "secret";
    }
}
```

Spring Context xml:
```xml
<aop:aspectj-autoproxy/>

<bean id="myAspect" class="org.imsglobal.aspect.LtiLaunchVerifier">
    <constructor-arg>
        <bean class="com.example.MockKeyService"/>
    </constructor-arg>
</bean>
```

LTI Consumers:
----

**Building an LTI launch request.**

```java
LtiSigner ltiSigner = new LtiOauthSigner();
Map<String, String> signedParameters = signParameters(parameters, key, secret, url, "POST");
```

Contributing:
-------------

You are welcome to contribute code to this work, but before we accept your PR, must sign a Contributors Agreement. To request a Contributors Agreement, please contact info@imsglobal.org


© 2014 IMS Global Learning Consortium, Inc. All Rights Reserved.   
