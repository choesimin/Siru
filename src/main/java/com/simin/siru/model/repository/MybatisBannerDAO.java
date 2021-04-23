package com.simin.siru.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simin.siru.model.domain.Banner;

@Repository
public class MybatisBannerDAO implements BannerDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(Banner banner) {
		sqlSessionTemplate.insert("Banner.insert", banner);
	}

	@Override
	public List<Banner> selectAll() {
		return sqlSessionTemplate.selectList("Banner.selectAll");
	}
	
}
