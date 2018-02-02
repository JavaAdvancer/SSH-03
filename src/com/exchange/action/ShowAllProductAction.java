package com.exchange.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.exchange.entities.Product;
import com.exchange.services.ShowAllProductService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class ShowAllProductAction extends ActionSupport{

	private ShowAllProductService showAllProductService;
	
	public void setShowAllProductService(ShowAllProductService showAllProductService) {
		this.showAllProductService = showAllProductService;
	}
	
	public void showAllProductAction() throws Exception{
		List<Product> list = showAllProductService.showAllProductService();
		JSONArray jsonArray = new JSONArray();
		for(Product p:list){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", p.getId());
			jsonObject.put("name",p.getName());
			jsonObject.put("title", p.getTitle());
			jsonObject.put("detail", p.getDetail());
			jsonObject.put("budgetTime", p.getBudgetTime());
			jsonObject.put("budgetPrice", p.getBudgetPrice());
			jsonObject.put("category", p.getCategory());
			jsonObject.put("uId", p.getUser().getId());
			jsonObject.put("picture", p.getPicture());
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
