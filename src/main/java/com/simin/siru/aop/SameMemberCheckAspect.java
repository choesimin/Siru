package com.simin.siru.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

import com.simin.siru.exception.LoginRequiredException;

public class SameMemberCheckAspect {

	public Object sameMemberCheck(ProceedingJoinPoint joinPoint) throws Throwable {

		Object[] args = joinPoint.getArgs();
		
		HttpServletRequest request = null;

		for (Object arg : args) {
			if (arg instanceof HttpServletRequest) {
				request = (HttpServletRequest)arg;
			}
		}
		
		/*
		
		여기에 글의 작성자를 알아올 수 있는 과정 추가
		
		*/
		
		HttpSession session = null;
		session = request.getSession();
		Object result = null;
		
		if (session.getAttribute("member") == null) {
			throw new LoginRequiredException();
		} else {
			result = joinPoint.proceed();
		}
		
		/*
		
		여기에서 현재 session의 사람과 글을 등록한 사람이 같은지 판단 
		
		*/
		
		return result;
	}
}
