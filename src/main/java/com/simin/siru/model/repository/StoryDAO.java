package com.simin.siru.model.repository;

import java.util.List;

import com.simin.siru.model.domain.Story;

public interface StoryDAO {
	
	public void insert(Story story);
	public List<Story> selectAll();
	public Story select(int story_id);

}
