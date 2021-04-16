package com.simin.siru.model.service;

import javax.servlet.http.HttpSession;

import com.simin.siru.model.domain.Member;
import com.simin.siru.model.domain.ResponseData;

public interface MemberService {
	
	public ResponseData regist(Member member);
	public ResponseData login(Member member, HttpSession session);
	public Member get(int member_id);
	public ResponseData findId(String email);
	public ResponseData changeInformation(Member member);
	public ResponseData changePassword(Member member);
	
}
