package com.skr.hbr.stock;

import java.util.HashSet;
import java.util.Set;

import java.util.HashSet;
import java.util.Set;

import java.util.HashSet;
import java.util.Set;

public class Category implements java.io.Serializable {

	public Category(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	public Category(Integer categoryId, String name, String desc, Set<Stock> stocks) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.desc = desc;
		this.stocks = stocks;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Set<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}
	private Integer categoryId;
	private String name;
	private String desc;
	private Set<Stock> stocks = new HashSet<Stock>(0);

	//getter, setter and constructor
}