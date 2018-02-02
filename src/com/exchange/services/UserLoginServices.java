package com.exchange.services;

import com.exchange.dao.UserLoginAction;
import com.exchange.entities.User;

public class UserLoginServices {

	private UserLoginAction userLoginAction;

	public void setUserLoginAction(UserLoginAction userLoginAction) {
		this.userLoginAction = userLoginAction;
	}
	
	public User userLoginServices(User user){
		return userLoginAction.loginAction(user);
	}
}
