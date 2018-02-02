package com.exchange.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.Post;

public class SaveSelfPostDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveSelfPostDao(Post post){
		Session session = sessionFactory.openSession();
		Post p = (Post)session.get(Post.class, post.getId());
		p.setTitle(post.getTitle());
		p.setContent(post.getContent());
		session.saveOrUpdate(p);
		session.flush();
	}
}
