package com.simin.siru.model.repository;

import java.util.List;

import com.simin.siru.model.domain.Comment;

public interface CommentDAO {
	public void insert(Comment comment);
	public Comment select(int comment_id);
	public List<Comment> selectByStoryId(int story_id);
	public void update(Comment comment);
	public void delete(int comment_id);
}
