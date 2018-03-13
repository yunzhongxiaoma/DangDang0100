package com.dangdang.entity;

import java.util.List;

public class Category {
	private Integer id; 
	private String name;
	private Integer amount;
	private Integer parentid;
	private List<Category> secondCategory ;
	
	public Category() {
		super();
	}
	
	public Category(Integer id, String name, Integer amount, Integer parentid,
			List<Category> secondCategory) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.parentid = parentid;
		this.secondCategory = secondCategory;
	}

	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public List<Category> getSecondCategory() {
		return secondCategory;
	}
	public void setSecondCategory(List<Category> secondCategory) {
		this.secondCategory = secondCategory;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", amount=" + amount
				+ ", parentid=" + parentid + ", secondCategory="
				+ secondCategory + "]\n";
	}

}
