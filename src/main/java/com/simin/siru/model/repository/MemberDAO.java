package com.simin.siru.model.repository;

import java.util.List;

import com.simin.siru.model.domain.Member;

public interface MemberDAO {
	public void insert(Member member);
	public List<Member> selectAll();
	public Member select(int member_id);
	public Member selectById(String id);
	public Member selectByNickname(String nickname);
	public Member selectByIdPassword(Member member);
	public List<Member> selectByEmail(String email);
	public void update(Member member);
	public void updatePassword(Member member);
	public void delete(int member_id);
}
