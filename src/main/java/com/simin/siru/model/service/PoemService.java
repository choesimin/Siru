package com.simin.siru.model.service;

import java.util.List;

import com.simin.siru.model.domain.Like;
import com.simin.siru.model.domain.Poem;

public interface PoemService {

	public void regist(Poem poem);
	public List<Poem> selectAll();
	public Poem select(int poem_id);
	public List<Poem> selectByMember(int member_id);
	public Poem[] selectBestFive();
	public void modify(Poem poem);
	public void delete(int poem_id);
	public void like(Like like);
	public void cancelLike(Like like);
	public int countLike(int poem_id);
	public boolean checkMemberLike(Like like);
	
}
