package com.simin.siru.model.service;

import com.simin.siru.model.domain.Banner;

public interface BannerService {
	public Banner getRecent();
	public void regist(Banner banner);
}
