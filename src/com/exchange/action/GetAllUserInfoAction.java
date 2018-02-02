package com.exchange.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.User;
import com.exchange.services.GetAllUserInfoService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class GetAllUserInfoAction extends ActionSupport {
	
	private GetAllUserInfoService getAllUserInfoService;
	
	

	public void setGetAllUserInfoService(GetAllUserInfoService getAllUserInfoService) {
		this.getAllUserInfoService = getAllUserInfoService;
	}



	public void getAllUserInfoAction() throws Exception {
		// TODO Auto-generated constructor stub
		User user = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		user = getAllUserInfoService.getAllUserInfoService(userId);
		JSONObject jsonObject = JSONObject.fromObject(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
	}
}
