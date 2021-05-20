package com.simin.siru.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simin.siru.model.domain.Like;

@Repository
public class MybatisLikeDAO implements LikeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insertByPoemId(Like like) {
		sqlSessionTemplate.insert("Like.insertByPoemId", like);
	}
	@Override
	public void insertByStoryId(Like like) {
		sqlSessionTemplate.insert("Like.insertByStoryId", like);
	}


	@Override
	public int countByPoemId(int poem_id) {
		return sqlSessionTemplate.selectOne("Like.countByPoemId", poem_id);
	}
	@Override
	public int countByStoryId(int story_id) {
		return sqlSessionTemplate.selectOne("Like.countByStoryId", story_id);
	}
	
	
	@Override
	public List<Like> selectPoemOrderByCount() {
		return sqlSessionTemplate.selectList("Like.selectPoemOrderByCount");
	}
	@Override
	public List<Like> selectStoryOrderByCount() {
		return sqlSessionTemplate.selectList("Like.selectStoryOrderByCount");
	}


	@Override
	public List<Like> selectByMemberIdAndPoemId(Like like) {
		return sqlSessionTemplate.selectList("Like.selectByMemberIdAndPoemId", like);
	}
	@Override
	public List<Like> selectByMemberIdAndStoryId(Like like) {
		return sqlSessionTemplate.selectList("Like.selectByMemberIdAndStoryId", like);
	}


	@Override
	public void delete(Like like) {
		sqlSessionTemplate.delete("Like.delete", like);
	}


}
