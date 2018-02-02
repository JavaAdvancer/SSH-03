package com.exchange.entities;

public class Product {

	private Integer id;
	private String name;
	private String title;
	private String detail;
	private String budgetTime;
	private Double budgetPrice;
	private String category;
	private String picture;
	private User user;

	
	public Product() {
		super();
	}

	public Product(String name, String title, String detail, String budgetTime, Double budgetPrice, String category,
			String picture) {
		super();
		this.name = name;
		this.title = title;
		this.detail = detail;
		this.budgetTime = budgetTime;
		this.budgetPrice = budgetPrice;
		this.category = category;
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getBudgetTime() {
		return budgetTime;
	}

	public void setBudgetTime(String budgetTime) {
		this.budgetTime = budgetTime;
	}

	public Double getBudgetPrice() {
		return budgetPrice;
	}

	public void setBudgetPrice(Double budgetPrice) {
		this.budgetPrice = budgetPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
