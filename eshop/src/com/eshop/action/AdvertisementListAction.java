package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.base.framwork.action.EntityListAction;
import com.eshop.filter.AdvertisementFilter;
import com.eshop.model.AdvertisementModel;
import com.eshop.service.IAdvertisementService;

@Component
public class  AdvertisementListAction extends EntityListAction<AdvertisementModel> {
	@Resource
	private IAdvertisementService advertisementService;
	
	private  AdvertisementFilter  advertisementFilter;

	public IAdvertisementService getAdvertisementService() {
		return advertisementService;
	}

	public void setAdvertisementService(IAdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}

	public AdvertisementFilter getAdvertisementFilter() {
		return advertisementFilter;
	}

	public void setAdvertisementFilter(AdvertisementFilter advertisementFilter) {
		this.advertisementFilter = advertisementFilter;
	}
	
}
