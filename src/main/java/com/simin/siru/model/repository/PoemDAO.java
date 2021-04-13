package com.simin.siru.model.repository;

import java.util.List;

import com.simin.siru.model.domain.Poem;

public interface PoemDAO {
	
	public void insert(Poem poem);
	public List<Poem> selectAll();
	public Poem select(int poem_id);
	public List<Poem> selectByMemberIdOrderByDate(int member_id);
	public void update(Poem poem);
	public void delete(int poem_id);

}
