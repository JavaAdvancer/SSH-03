package com.exchange.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.services.UpdatePasswordService;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatePasswordAction extends ActionSupport {

	private String password;
	
	private UpdatePasswordService updatePasswordService;
	
	public void setUpdatePasswordService(UpdatePasswordService updatePasswordService) {
		this.updatePasswordService = updatePasswordService;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void updatePasswordAction() throws Exception{
		if(updatePasswordService.updatePasswordService(password)=="true"){
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print("success");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print("error");
		}
	}
}
