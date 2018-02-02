package com.exchange.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.services.CheckPasswordService;
import com.opensymphony.xwork2.ActionSupport;

public class CheckPasswordAction extends ActionSupport {

	private String password;

	private CheckPasswordService checkPasswordService;
	
	public void setCheckPasswordService(CheckPasswordService checkPasswordService) {
		this.checkPasswordService = checkPasswordService;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void checkPasswordAction() throws IOException{
		if(checkPasswordService.checkPasswordDao(password)=="true"){
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print("success");
		}else {
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print("error");
		}
	}
}
