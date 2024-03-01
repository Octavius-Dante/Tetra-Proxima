package com.dantes.demo.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Laptop {

	private int length;
	private int width;
	private int weight;
	private String brandName;
	
	// This is a dependency 
	@Autowired
	private IHardDisk hdd;
	
	@Override
	public String toString() {
		return "Laptop [length=" + length + ", width=" + width + ", weight=" + weight + ", brandName=" + brandName
				+ "] and is running with " + hdd.read();
	}
	
	public Laptop() {
		super();
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
	
}
