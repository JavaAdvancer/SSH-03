package com.exchange.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.Product;

public class GetProductInfoDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Product getProductInfoDao(Integer id){
		Session session = sessionFactory.openSession();
		Product product = (Product)session.get(Product.class, id);
		return product;
	}
}
