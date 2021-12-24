package com.assignment.productaggregator.model;

import org.springframework.stereotype.Component;

@Component
public class ProductAggregator {

	
	private String id;
	
	private String name;
	
	private CurrentPrice currentPrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	
}
