package com.simin.siru.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simin.siru.model.domain.Member;

@Repository
public class MybatisMemberDAO implements MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(Member member) {
		sqlSessionTemplate.insert("Member.insert", member);
	}

	@Override
	public List<Member> selectAll() {
		return null;
	}

	@Override
	public Member select(int member_id) {
		return null;
	}

	@Override
	public Member selectById(String id) {
		return sqlSessionTemplate.selectOne("Member.selectById", id);
	}

	@Override
	public Member selectByNickname(String nickname) {
		return sqlSessionTemplate.selectOne("Member.selectByNickname", nickname);
	}

	@Override
	public void update(Member member) {
		sqlSessionTemplate.update("Member.update", member);
	}

	@Override
	public void delete(int member_id) {
		sqlSessionTemplate.delete("Member.delete", member_id);
	}

	@Override
	public Member selectByIdPassword(Member member) {
		return sqlSessionTemplate.selectOne("Member.selectByIdPassword", member);
	}

	@Override
	public List<Member> selectByEmail(String email) {
		return sqlSessionTemplate.selectList("Member.selectByEmail", email);
	}

	@Override
	public void updatePassword(Member member) {
		sqlSessionTemplate.update("Member.updatePassword", member);
	}

}
