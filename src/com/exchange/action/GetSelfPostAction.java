package com.exchange.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.Post;
import com.exchange.services.GetSelfPostService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetSelfPostAction {

	private GetSelfPostService getSelfPostService;
	
	public void setGetSelfPostService(GetSelfPostService getSelfPostService) {
		this.getSelfPostService = getSelfPostService;
	}
	
	public void getSelfPostAction() throws Exception{
		List<Post> list = getSelfPostService.getSelfPostService();
		JSONArray jsonArray = new JSONArray();
		for(Post p:list){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", p.getId());
			jsonObject.put("title", p.getTitle());
			jsonObject.put("content", p.getContent());
			jsonArray.add(jsonObject);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonArray);
		out.flush();
		out.close();
	}
}
