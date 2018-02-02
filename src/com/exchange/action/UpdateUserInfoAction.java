package com.exchange.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.User;
import com.exchange.services.UpdateUserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserInfoAction extends ActionSupport {

	private String username;
	private Integer age;
	private String gender;
	private String address;
	private String school;
	private String email;
	
	private UpdateUserInfoService updateUserInfoService;
	

	public void setUpdateUserInfoService(UpdateUserInfoService updateUserInfoService) {
		this.updateUserInfoService = updateUserInfoService;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void updateUserInfoAction() throws IOException{
		User user = new User(username, gender, age, school, email, address);
		if(updateUserInfoService.updateUserInfoService(user)==true){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print("success");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/json;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print("error");
		}
	}
}
