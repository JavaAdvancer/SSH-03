package com.exchange.services;

import java.util.List;

import com.exchange.dao.GetSelfPostDao;
import com.exchange.entities.Post;

public class GetSelfPostService {

	private GetSelfPostDao getSelfPostDao;
	
	public void setGetSelfPostDao(GetSelfPostDao getSelfPostDao) {
		this.getSelfPostDao = getSelfPostDao;
	}
	
	public List<Post> getSelfPostService(){
		return getSelfPostDao.getSelfPostDao();
	}
}
