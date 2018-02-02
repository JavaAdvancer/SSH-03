package com.exchange.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.Product;
import com.exchange.services.GetSelfProductService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetSelfProductAction {

	private GetSelfProductService getSelfProductService;
	
	public void setGetSelfProductService(GetSelfProductService getSelfProductService) {
		this.getSelfProductService = getSelfProductService;
	}
	
	public void getSelfProductAction() throws Exception{
		List<Product> list = getSelfProductService.getSelfProductService();
		JSONArray jsonArray = new JSONArray();
		for(Product p:list){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", p.getId());
			jsonObject.put("name", p.getName());
			jsonObject.put("detail", p.getDetail());
			jsonObject.put("budgetPrice", p.getBudgetPrice());
			jsonObject.put("budgetTime", p.getBudgetTime());
			jsonObject.put("category", p.getCategory());
			jsonObject.put("title", p.getTitle());
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
