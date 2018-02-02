package com.exchange.services;

import com.exchange.dao.GetNoticeDao;
import com.exchange.entities.Notice;

public class GetNoticeService {

	private GetNoticeDao getNoticeDao;
	
	public void setGetNoticeDao(GetNoticeDao getNoticeDao) {
		this.getNoticeDao = getNoticeDao;
	}
	
	public Notice getNoticeService(Integer id){
		return getNoticeDao.getNoticeDao(id);
	}
}
