package com.simin.siru.model.repository;

import java.util.List;

import com.simin.siru.model.domain.Like;

public interface LikeDAO {

	public void insertByPoemId(Like like);
	public void insertByStoryId(Like like);
	public int countByStoryId(int story_id);
	public int countByPoemId(int poem_id);
	public List<Like> selectPoemOrderByCount();
	public List<Like> selectStoryOrderByCount();
	public List<Like> selectByMemberIdAndStoryId(Like like);
	public List<Like> selectByMemberIdAndPoemId(Like like);
	public void delete(Like like);

}
