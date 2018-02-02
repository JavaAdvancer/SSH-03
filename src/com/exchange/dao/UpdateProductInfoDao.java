package com.exchange.dao;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.Product;
import com.exchange.entities.User;

public class UpdateProductInfoDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public String updateProductInfoDao(Product product){
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		Integer userId = (Integer) httpSession.getAttribute("userId");
		Session session = sessionFactory.openSession();
		User user = (User)session.get(User.class,userId);
		product.setUser(user);
		session.save(product);
		session.close();
		return "success";
	}
}
