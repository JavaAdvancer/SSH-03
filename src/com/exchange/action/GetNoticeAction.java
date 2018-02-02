package com.exchange.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.Notice;
import com.exchange.services.GetNoticeService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class GetNoticeAction extends ActionSupport{

	private Integer id;
	private GetNoticeService getNoticeService;
	
	public void setGetNoticeService(GetNoticeService getNoticeService) {
		this.getNoticeService = getNoticeService;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void getNoticeAction() throws Exception{
		Notice notice = getNoticeService.getNoticeService(id);
		JSONObject jsonObject = JSONObject.fromObject(notice);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
		out.close();
	}
}
