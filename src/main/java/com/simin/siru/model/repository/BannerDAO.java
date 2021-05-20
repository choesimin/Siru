package com.simin.siru.model.repository;

import java.util.List;

import com.simin.siru.model.domain.Banner;

public interface BannerDAO {
	public void insert(Banner banner);
	public List<Banner> selectAll();
}
