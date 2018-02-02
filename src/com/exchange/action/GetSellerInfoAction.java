package com.exchange.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.User;
import com.exchange.services.GetSellerInfoService;

import net.sf.json.JSONObject;

public class GetSellerInfoAction {

	private Integer id;
	private GetSellerInfoService getSellerInfoService;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setGetSellerInfoService(GetSellerInfoService getSellerInfoService) {
		this.getSellerInfoService = getSellerInfoService;
	}
	
	public void getSellerInfoAction() throws Exception{
		User user = getSellerInfoService.getSellerInfoService(id);
		JSONObject jsonObject = JSONObject.fromObject(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
		out.close();
	}
}
