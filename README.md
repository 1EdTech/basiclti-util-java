#IMS Global - BasicLTI Utilities

[![Build Status](https://travis-ci.org/pfgray/basiclti-util-java.svg?branch=master)](https://travis-ci.org/pfgray/basiclti-util-java)

What is it?
-----------

BasicLTI Utilities are a set of utility classes to aid  in the development
of BasicLTI consumers and providers. They deal with much of the heavy lifting
and make the process more opaque to the developer.


How to use:
-----------
Install via Maven:

    git clone https://github.com/pfgray/basiclti-util-java.git
    cd basiclti-util-java/
    mvn clean install

Include in your project's `pom.xml`:

    <dependency>
        <groupId>org.imsglobal</groupId>
        <artifactId>basiclti-util</artifactId>
        <version>1.0.0</version>
    </dependency>

Examples:
---------

LTI Producer:

Spring Controller (LTI Producer):

    @Lti
    @RequestMapping(value = "/lti", method = RequestMethod.POST)
    public String ltiEntry(HttpServletRequest request, LtiVerificationResult result) {
        if(!result.getSuccess()){
            return "error";
        } else {
            return "success";
        }
    }
KeyService Implementation:

    public class MockKeyService implements LtiKeySecretService {
        public String getSecretForKey(String key) {
            return "secret";
        }
    }

Spring Context xml:

    <aop:aspectj-autoproxy/>

    <bean id="myAspect" class="org.imsglobal.aspect.LtiLaunchVerifier">
        <constructor-arg>
            <bean class="com.example.MockKeyService"/>
        </constructor-arg>
    </bean>

How to Contribute:
------------------
1. Fork the repo
2. Add changes
3. Send a pull request with those changes

TODO List:
--------------

- [ ] Write Unit tests for LTI Consumer code
- [ ] Write Unit tests for LTI 2 code
