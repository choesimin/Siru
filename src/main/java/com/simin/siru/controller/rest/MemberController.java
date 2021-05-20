package com.simin.siru.controller.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simin.siru.model.domain.Member;
import com.simin.siru.model.domain.ResponseData;
import com.simin.siru.model.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/member/regist", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	public String regist(Member member) {
		ResponseData responseData = memberService.regist(member);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(responseData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	public String login(Member member, HttpSession session) {
		ResponseData responseData = memberService.login(member, session);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(responseData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	@RequestMapping(value = "/member/id/find", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	public String findId(String email) {
		ResponseData responseData = memberService.findId(email);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(responseData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	@RequestMapping(value = "/member/password/change", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	public String changePassword(Member member) {
		ResponseData responseData = memberService.changePassword(member);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		
		try {
			jsonString = mapper.writeValueAsString(responseData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
}
