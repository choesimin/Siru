package com.simin.siru.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

import com.simin.siru.exception.LoginRequiredException;

public class MemberSessionCheckAspect {

	public Object memberSessionCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		Object target = joinPoint.getTarget();
		String methodName = joinPoint.getSignature().getName();
		*/

		Object[] args = joinPoint.getArgs();
		
		HttpServletRequest request = null;

		for (Object arg : args) {
			if (arg instanceof HttpServletRequest) {
				request = (HttpServletRequest)arg;
			}
		}
		
		HttpSession session = null;
		session = request.getSession();
		Object result = null;
		
		if (session.getAttribute("member") == null) {
			throw new LoginRequiredException();
		} else {
			result = joinPoint.proceed();
		}
		
		return result;
	}
}
