package com.exchange.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.Notice;

public class GetNoticeDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Notice getNoticeDao(Integer id){
		Session session = sessionFactory.openSession();
		Notice notice = (Notice)session.get(Notice.class, id);
		session.close();
		return notice;
	}
}

