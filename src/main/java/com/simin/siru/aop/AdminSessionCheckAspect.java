package com.simin.siru.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

import com.simin.siru.exception.AdminRequiredException;
import com.simin.siru.model.domain.Member;

public class AdminSessionCheckAspect {

	public Object adminSessionCheck(ProceedingJoinPoint joinPoint) throws Throwable {

		Object[] args = joinPoint.getArgs();
		
		HttpServletRequest request = null;

		for (Object arg : args) {
			if (arg instanceof HttpServletRequest) {
				request = (HttpServletRequest)arg;
			}
		}
		
		HttpSession session = null;
		session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		Object result = null;
		
		if (!member.getId().equals("administrator")) {
			throw new AdminRequiredException();
		} else {
			result = joinPoint.proceed();
		}
		
		return result;
	}
}
