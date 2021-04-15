package com.simin.siru.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simin.siru.model.common.SecureManager;
import com.simin.siru.model.domain.Member;
import com.simin.siru.model.domain.ResponseData;
import com.simin.siru.model.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public ResponseData regist(Member member) {
		Member memberById = memberDAO.selectById(member.getId());
		Member memberByNickname = memberDAO.selectByNickname(member.getNickname());

		ResponseData responseData = new ResponseData();
		SecureManager secureManager = new SecureManager();

		String message = "";
		int code = 0;
		
		if (memberByNickname != null) {
			message = "닉네임(<span class=\"color_yellow\">" + memberByNickname.getNickname() + "</span>)이 중복됩니다.";
			code = 1;
		} else if (memberById != null) {
			message = "아이디(<span class=\"color_yellow\">" + memberById.getId() + "</span>)가 중복됩니다.";
			code = 2;
		} else {
			member.setPassword(secureManager.getSecureData(member.getPassword()));
			memberDAO.insert(member);
			message = "환영합니다 <span class=\"color_yellow\">" + member.getNickname() + "</span> 작가님! <br/> 로그인하여 시작하세요.";
			code = 10;
		}
		
		responseData.setMessage(message);
		responseData.setCode(code);
		
		return responseData;
	}

	@Override
	public ResponseData login(Member member, HttpSession session) {
		ResponseData responseData = new ResponseData();
		SecureManager secureManager = new SecureManager();
		
		member.setPassword(secureManager.getSecureData(member.getPassword()));
		Member memberById = memberDAO.selectById(member.getId());
		Member member_result = memberDAO.selectByIdPassword(member);

		String message = "";
		String url = "";
		int code = 0;
		
		if (memberById == null) {
			message = "<span class=\"color_yellow\">" + member.getId() + "</span>는 존재하지 않는 아이디입니다.";
			code = 1;
		} else if (member_result == null) {
			message = "<span class=\"color_yellow\">" + member.getId() + "</span> 님, 비밀번호를 확인해주세요.";
			code = 2;
		} else if (member_result != null) {
			session.setAttribute("member", member_result);
			url = "/user/home";
			code = 10;
		}
		
		responseData.setMessage(message);
		responseData.setUrl(url);
		responseData.setCode(code);
		responseData.setObject(member_result);
		
		return responseData;
	}

	@Override
	public ResponseData findId(String email) {
		ResponseData responseData = new ResponseData();
		
		List<Member> member_list = memberDAO.selectByEmail(email);
		
		if (member_list.size() > 0) {
			responseData.setObject(member_list);
			responseData.setCode(10);
		} else {
			responseData.setCode(1);
		}
		
		return responseData;
	}

	@Override
	public ResponseData changePassword(Member member) {
		ResponseData responseData = new ResponseData();
		SecureManager secureManager = new SecureManager();
		
		String message = "";
		int code = 0;
		
		Member member_id = memberDAO.selectById(member.getId());
		List<Member> member_email_list = memberDAO.selectByEmail(member.getEmail());

		if (member_email_list.size() < 1) {
			message = "<span class=\"color_yellow\">" + member.getEmail() + "</span>에 해당하는 계정이 없습니다. 이메일을 다시 한 번 확인해주세요.";
		} else if (member_id == null) {
			message = "<span class=\"color_yellow\">" + member.getId() + "</span>에 해당하는 계정이 없습니다. 아이디를 다시 한 번 확인해주세요.";
		} else {
			Member member_update = new Member();
			member_update.setMember_id(member_id.getMember_id());
			member_update.setPassword(secureManager.getSecureData(member.getPassword()));
			
			memberDAO.updatePassword(member_update);

			message = "<span class=\"color_yellow\">" + member_id.getNickname() + "</span> 님의 비밀번호가 변경되었습니다.";
			code = 10;
		}
		
		responseData.setMessage(message);
		responseData.setCode(code);
		
		return responseData;
	}

	@Override
	public Member get(int member_id) {
		return memberDAO.select(member_id);
	}

	@Override
	public void change(Member member) {
		SecureManager secureManager = new SecureManager();

		member.setPassword(secureManager.getSecureData(member.getPassword()));
		memberDAO.update(member);
	}

}
