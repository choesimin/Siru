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
	public void insert(Like like) {
		sqlSessionTemplate.insert("Like.insert", like);
	}

	@Override
	public int countByStoryId(int story_id) {
		return sqlSessionTemplate.selectOne("Like.countByStoryId", story_id);
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
