package com.simin.siru.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simin.siru.model.domain.Like;
import com.simin.siru.model.domain.Story;
import com.simin.siru.model.repository.LikeDAO;
import com.simin.siru.model.repository.StoryDAO;

@Service
public class StoryServiceImpl implements StoryService {
	
	@Autowired
	private StoryDAO storyDAO;
	
	@Autowired
	private LikeDAO likeDAO;

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

	@Override
	public void modify(Story story) {
		storyDAO.update(story);
	}

	@Override
	public void delete(int story_id) {
		storyDAO.delete(story_id);
	}

	@Override
	public void like(Like like) {
		likeDAO.insert(like);
	}

	@Override
	public void cancelLike(Like like) {
		likeDAO.delete(like);
	}

	@Override
	public int countLike(int story_id) {
		return likeDAO.countByStoryId(story_id);
	}

	@Override
	public boolean checkMemberLike(Like like) {
		boolean flag = false;
		List<Like> like_list = likeDAO.selectByMemberIdAndStoryId(like);
		
		if (like_list.size() > 0) {
			flag = true;
		}

		return flag;
	}

}
