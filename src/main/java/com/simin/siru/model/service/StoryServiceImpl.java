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
	public List<Story> getList() {
		return storyDAO.selectAll();
	}

	@Override
	public Story get(int story_id) {
		return storyDAO.select(story_id);
	}

	@Override
	public List<Story> getByMember(int member_id) {
		return storyDAO.selectByMemberIdOrderByDate(member_id);
	}

	@Override
	public Story[] getBestFive() {
		List<Like> like_list = likeDAO.selectStoryOrderByCount();

		if (like_list.size() >= 5) {
			like_list = like_list.subList(0, 5);
		} else {
			like_list = like_list.subList(0, like_list.size());
		}

		Story[] story_array = new Story[like_list.size()];

		for (int i = 0; i < story_array.length; i++) {
			story_array[i] = storyDAO.select(like_list.get(i).getStory_id());
		}
		
		return story_array;
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
		likeDAO.insertByStoryId(like);
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
