package com.simin.siru.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simin.siru.model.domain.Banner;
import com.simin.siru.model.repository.BannerDAO;

@Service
public class BannerServiceImpl implements BannerService {
	
	@Autowired
	private BannerDAO bannerDAO;

	@Override
	public Banner getRecent() {
		List<Banner> banner_list = bannerDAO.selectAll();
		
		Banner banner = null;
		
		if (banner_list.size() > 0) {
			banner = banner_list.get(0);
		} else {
			banner = new Banner();
			banner.setTitle("");
			banner.setContent("");
			banner.setWriter("");
		}
		
		return banner;
	}

	@Override
	public void regist(Banner banner) {
		bannerDAO.insert(banner);
	}

}
