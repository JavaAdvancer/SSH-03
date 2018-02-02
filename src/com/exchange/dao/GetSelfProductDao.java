package com.exchange.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.Product;

public class GetSelfProductDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Product> getSelfProductDao(){
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		Integer id = (Integer)httpSession.getAttribute("userId");
		Session session =sessionFactory.openSession();
		List<Product> list = session.createQuery("from Product p where p.user.id = :id").setInteger("id", id).list();
		return list;
	}
}
