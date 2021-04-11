package com.simin.siru.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simin.siru.model.domain.Poem;

@Repository
public class MybatisPoemDAO implements PoemDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(Poem poem) {
		sqlSessionTemplate.insert("Poem.insert", poem);
	}

	@Override
	public List<Poem> selectAll() {
		return sqlSessionTemplate.selectList("Poem.selectAll");
	}

	@Override
	public Poem select(int poem_id) {
		return sqlSessionTemplate.selectOne("Poem.select", poem_id);
	}

	@Override
	public void update(Poem poem) {
		sqlSessionTemplate.update("Poem.update", poem);
	}

	@Override
	public void delete(int poem_id) {
		sqlSessionTemplate.delete("Poem.delete", poem_id);
	}

}
