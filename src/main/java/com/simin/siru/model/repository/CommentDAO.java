package com.simin.siru.model.repository;

import java.util.List;

import com.simin.siru.model.domain.Comment;

public interface CommentDAO {
	public void insert(Comment comment);
	public List<Comment> selectByStoryId(int story_id);
}
