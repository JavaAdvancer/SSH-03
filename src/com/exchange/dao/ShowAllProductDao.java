package com.exchange.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.Product;

public class ShowAllProductDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Product> showAllProductDao(){
		Session session = sessionFactory.openSession();
		List<Product> lists = session.createQuery("from Product").list();
		return lists;
	}
}
