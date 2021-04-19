package com.simin.siru.model.service;

import java.util.List;

import com.simin.siru.model.domain.Like;
import com.simin.siru.model.domain.Poem;

public interface PoemService {

	public void regist(Poem poem);
	public List<Poem> getList();
	public Poem get(int poem_id);
	public List<Poem> getByMember(int member_id);
	public Poem[] getBestFive();
	public void modify(Poem poem);
	public void delete(int poem_id);
	public void like(Like like);
	public void cancelLike(Like like);
	public int countLike(int poem_id);
	public boolean checkMemberLike(Like like);
	
}
