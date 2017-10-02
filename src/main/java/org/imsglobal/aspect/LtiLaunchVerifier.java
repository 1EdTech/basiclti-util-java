/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.imsglobal.aspect;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.imsglobal.lti.launch.LtiVerificationResult;
import org.imsglobal.lti.launch.LtiVerifier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgray
 */
@Aspect
public class LtiLaunchVerifier {

    public LtiKeySecretService keyService;

    public LtiVerifier ltiVerifier;

    public LtiLaunchVerifier(LtiKeySecretService keyService, LtiVerifier ltiVerifier) {
        this.keyService = keyService;
        this.ltiVerifier = ltiVerifier;
    }

    @Around("@annotation(launch)")
    public Object verifyLtiLaunch(ProceedingJoinPoint pjp, Lti launch) throws Throwable {
        HttpServletRequest request = null;
        for (Object arg : pjp.getArgs()) {
            if (HttpServletRequest.class.isInstance(arg)) {
                request = (HttpServletRequest) arg;
            }
        }
        if(request == null){
            throw new IllegalStateException(getErrorMessageForArgumentClass("HttpServletRequest", pjp.getSignature().toLongString()));
        }

        String oauthSecret = keyService.getSecretForKey(request.getParameter("oauth_consumer_key"));
        LtiVerificationResult ltiResult = ltiVerifier.verify(request, oauthSecret);//BasicLTIUtil.validateMessage(request, request.getRequestURL().toString(), oauthSecret);

        Boolean ltiVerificationResultExists = false;
        //This array will hold the arguments to the join point, so we can pass them along to the advised function.
        List<Object> args = new ArrayList<>(pjp.getArgs().length);
        for (Object arg : pjp.getArgs()) {
            if (arg != null && arg.getClass().equals(LtiVerificationResult.class)) {
                args.add(ltiResult);
                ltiVerificationResultExists = true;
            } else {
                args.add(arg);
            }
        }
        if(!ltiVerificationResultExists){
            throw new IllegalStateException(getErrorMessageForArgumentClass("LtiVerificationResult", pjp.getSignature().toLongString()));
        }

        return pjp.proceed(args.toArray());
    }

    public String getErrorMessageForArgumentClass(String argumentClass, String signature){
        return "The LtiLaunchVerifier instance cannot find the " + argumentClass + " argument on method: " + signature + ", are you sure it was declared?";
    }

}
