package com.simin.siru.model.repository;

import java.util.List;

import com.simin.siru.model.domain.Like;

public interface LikeDAO {

	public void like(Like like);
	public int countByStoryId(int story_id);
	public List<Like> selectByMemberIdAndStoryId(Like like);

}
