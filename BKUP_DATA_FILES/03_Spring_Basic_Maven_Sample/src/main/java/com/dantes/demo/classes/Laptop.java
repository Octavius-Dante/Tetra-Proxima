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

//	String newline = System.lineSeparator(); 	

	String newline = " ";
	
	@Override
	public String toString() {
		return "Laptop [length=" + length + newline + ", width=" + width + newline + ", weight=" + weight + newline + ", brandName=" + brandName
				+ "] and is running with " + hdd.read();
	}
	
	public Laptop() {
		super();
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
//		this.length = length;
		length = 11 + 13;
		this.length = length;		
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
//		this.width = width;
		this.width = 11 + 24;		
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
//		this.weight = weight;
		this.weight = 43 + 2 ;		
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
//		this.brandName = brandName;
		this.brandName = "TESLAX";		
	}
	
	
}
