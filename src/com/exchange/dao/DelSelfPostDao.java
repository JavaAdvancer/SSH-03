package com.exchange.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DelSelfPostDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void delSelfPostDao(int id){
		Session session = sessionFactory.openSession();
		session.createQuery("delete Post p where p.id = :id").setInteger("id", id).executeUpdate();
	}
}
