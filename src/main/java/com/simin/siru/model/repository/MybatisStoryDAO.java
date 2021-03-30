package com.simin.siru.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simin.siru.model.domain.Story;

@Repository
public class MybatisStoryDAO implements StoryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(Story story) {
		sqlSessionTemplate.insert("Story.insert", story);
	}

	@Override
	public List<Story> selectAll() {
		return sqlSessionTemplate.selectList("Story.selectAll");
	}

	@Override
	public Story select(int story_id) {
		return sqlSessionTemplate.selectOne("Story.select", story_id);
	}

	@Override
	public void update(Story story) {
		sqlSessionTemplate.update("Story.update", story);
	}

	@Override
	public void delete(int story_id) {
		sqlSessionTemplate.delete("Story.delete", story_id);
	}

}
