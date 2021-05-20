package com.simin.siru.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simin.siru.model.domain.Like;
import com.simin.siru.model.domain.Poem;
import com.simin.siru.model.repository.LikeDAO;
import com.simin.siru.model.repository.PoemDAO;

@Service
public class PoemServiceImpl implements PoemService {
	
	@Autowired
	private PoemDAO poemDAO;
	
	@Autowired
	private LikeDAO likeDAO;

	@Override
	public void regist(Poem poem) {
		poemDAO.insert(poem);
	}

	@Override
	public List<Poem> getList() {
		return poemDAO.selectAll();
	}

	@Override
	public Poem get(int poem_id) {
		return poemDAO.select(poem_id);
	}

	@Override
	public List<Poem> getByMember(int member_id) {
		return poemDAO.selectByMemberIdOrderByDate(member_id);
	}

	@Override
	public Poem[] getBestFive() {
		List<Like> like_list = likeDAO.selectPoemOrderByCount();

		if (like_list.size() >= 5) {
			like_list = like_list.subList(0, 5);
		} else {
			like_list = like_list.subList(0, like_list.size());
		}

		Poem[] poem_array = new Poem[like_list.size()];

		for (int i = 0; i < poem_array.length; i++) {
			poem_array[i] = poemDAO.select(like_list.get(i).getPoem_id());
		}
		
		return poem_array;
	}

	@Override
	public void modify(Poem poem) {
		poemDAO.update(poem);
	}

	@Override
	public void delete(int poem_id) {
		poemDAO.delete(poem_id);
	}

	@Override
	public void like(Like like) {
		likeDAO.insertByPoemId(like);
	}

	@Override
	public void cancelLike(Like like) {
		likeDAO.delete(like);
	}

	@Override
	public int countLike(int poem_id) {
		return likeDAO.countByPoemId(poem_id);
	}

	@Override
	public boolean checkMemberLike(Like like) {
		boolean flag = false;
		List<Like> like_list = likeDAO.selectByMemberIdAndPoemId(like);
		
		if (like_list.size() > 0) {
			flag = true;
		}

		return flag;
	}

}
