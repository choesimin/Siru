package com.simin.siru.model.service;

import java.util.List;

import com.simin.siru.model.domain.Story;

public interface StoryService {

	public void regist(Story story);
	public List<Story> selectAll();
	public Story select(int story_id);
	public void modify(Story story);
	public void delete(int story_id);
	
}
