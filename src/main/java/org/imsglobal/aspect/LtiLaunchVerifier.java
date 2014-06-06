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
import org.imsglobal.basiclti.BasicLTIUtil;
import org.imsglobal.basiclti.LtiVerificationResult;

/**
 *
 * @author pgray
 */
@Aspect
public class LtiLaunchVerifier {

    public LtiKeySecretService keyService;

    public LtiLaunchVerifier(LtiKeySecretService ltiKeySecretService) {
        this.keyService = ltiKeySecretService;
    }

    @Around("@annotation(launch) && execution(* *(javax.servlet.http.HttpServletRequest+, org.imsglobal.basiclti.LtiVerificationResult)) && args(request,result)")
    public Object verifyLtiLaunch(ProceedingJoinPoint pjp, Lti launch, HttpServletRequest request, LtiVerificationResult result) throws Throwable {

        String oauthSecret = keyService.getSecretForKey(request.getParameter("oauth_consumer_key"));
        result = BasicLTIUtil.validateMessage(request, request.getRequestURL().toString(), oauthSecret);

        return pjp.proceed(new Object[] {request, result});
    }

}
