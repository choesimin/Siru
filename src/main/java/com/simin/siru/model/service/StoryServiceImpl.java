package com.simin.siru.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simin.siru.model.domain.Story;
import com.simin.siru.model.repository.StoryDAO;

@Service
public class StoryServiceImpl implements StoryService {
	
	@Autowired
	private StoryDAO storyDAO;

	@Override
	public void regist(Story story) {
		storyDAO.insert(story);
	}

	@Override
	public List<Story> selectAll() {
		return storyDAO.selectAll();
	}

	@Override
	public Story select(int story_id) {
		return storyDAO.select(story_id);
	}

}
