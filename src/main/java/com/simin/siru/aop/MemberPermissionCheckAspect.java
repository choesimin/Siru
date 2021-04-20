package com.simin.siru.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

import com.simin.siru.exception.MemberPermissionRequiredException;
import com.simin.siru.model.domain.Member;

public class MemberPermissionCheckAspect {

	public Object memberPermissionCheck(ProceedingJoinPoint joinPoint) throws Throwable {

		Object[] args = joinPoint.getArgs();
		
		HttpServletRequest request = null;

		for (Object arg : args) {
			if (arg instanceof HttpServletRequest) {
				request = (HttpServletRequest)arg;
			}
		}
		
		Member member_post = null;
		
		for (Object arg : args) {
			if (arg instanceof Member) {
				member_post = (Member)arg;
			}
		}
		
		
		HttpSession session = null;
		session = request.getSession();
		Member member_current = (Member)session.getAttribute("member");
		Object result = null;
		
		if (member_current.getMember_id() != member_post.getMember_id()) {
			throw new MemberPermissionRequiredException();
		} else {
			result = joinPoint.proceed();
		}
		
		
		return result;
	}
}
