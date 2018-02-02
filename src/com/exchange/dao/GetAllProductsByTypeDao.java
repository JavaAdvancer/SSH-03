package com.exchange.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.Product;

public class GetAllProductsByTypeDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Product> getAllProductsByTypeDao(String type){
		Session session = sessionFactory.openSession();
		List<Product> lists = session.createQuery("from Product p where p.category = :type").setString("type", type).list();
		return lists;
	}
}
