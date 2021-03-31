package com.simin.siru.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simin.siru.model.domain.Comment;

@Repository
public class MybatisCommentDAO implements CommentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(Comment comment) {
		sqlSessionTemplate.insert("Comment.insert", comment);
	}

	@Override
	public List<Comment> selectByStoryId(int story_id) {
		return sqlSessionTemplate.selectList("Comment.selectByStoryId", story_id);
	}

	@Override
	public void delete(int comment_id) {
		sqlSessionTemplate.delete("Comment.delete", comment_id);
	}

}
