package com.simin.siru.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.simin.siru.exception.AdminRequiredException;
import com.simin.siru.exception.LoginRequiredException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(LoginRequiredException.class)
	public String handlerException(LoginRequiredException e) {
		return "redirect:/user/home#start";
	}

	@ExceptionHandler(AdminRequiredException.class)
	public String handlerException(AdminRequiredException e) {
		return "redirect:/user/member/logout";
	}

}
