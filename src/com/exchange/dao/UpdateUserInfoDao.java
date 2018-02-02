package com.exchange.dao;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exchange.entities.User;

public class UpdateUserInfoDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean updateUserInfoDao(User user){
		String gender = null;
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		Integer userId = (Integer)httpSession.getAttribute("userId");
		Session session = sessionFactory.openSession();
		User localUser = (User)session.get(User.class, userId);
		if(user.getGender()=="female"){
			gender = "女";
		}else {
			gender = "男";
		}
		localUser.setUsername(user.getUsername());
		localUser.setSchool(user.getSchool());
		localUser.setGender(gender);
		localUser.setEmail(user.getEmail());
		localUser.setAge(user.getAge());
		localUser.setAddress(user.getAddress());
		session.saveOrUpdate(localUser);
		session.flush();
		return true;
	}
}
