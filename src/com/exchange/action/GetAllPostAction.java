package com.exchange.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.Post;
import com.exchange.services.GetAllPostService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetAllPostAction {

	private GetAllPostService getAllPostService;

	public void setGetAllPostService(GetAllPostService getAllPostService) {
		this.getAllPostService = getAllPostService;
	}

	public void getAllPostAction() throws Exception {
		List<Post> list = getAllPostService.getAllPostService();
		JSONArray jsonArray = new JSONArray();
		for (Post post : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", post.getId());
			jsonObject.put("title", post.getTitle());
			jsonObject.put("content", post.getContent());
			jsonObject.put("uId", post.getUser().getId());
			jsonObject.put("uPic", post.getUser().getPicture());
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
