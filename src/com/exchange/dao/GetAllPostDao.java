package com.exchange.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.Post;

public class GetAllPostDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Post> getAllPostDao(){
		Session session = sessionFactory.openSession();
		List<Post> list = session.createQuery("from Post").list();
		return list;
	}
}
