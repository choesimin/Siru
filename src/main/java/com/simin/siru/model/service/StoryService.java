package com.simin.siru.model.service;

import java.util.List;

import com.simin.siru.model.domain.Like;
import com.simin.siru.model.domain.Story;

public interface StoryService {

	public void regist(Story story);
	public List<Story> getList();
	public Story get(int story_id);
	public List<Story> getByMember(int member_id);
	public Story[] getBestFive();
	public void modify(Story story);
	public void delete(int story_id);
	public void like(Like like);
	public void cancelLike(Like like);
	public int countLike(int story_id);
	public boolean checkMemberLike(Like like);
	
}
