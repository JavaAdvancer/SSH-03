package com.exchange.services;

import com.exchange.dao.PostDao;
import com.exchange.entities.Post;

public class PostService {

	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	public String postService(Post post){
		if(postDao.postDao(post)=="success"){
			return "success";
		}else{
			return "error";
		}
	}
}
