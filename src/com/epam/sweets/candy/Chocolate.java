package com.epam.sweets.candy;

import java.io.PrintWriter;
import java.io.StringWriter;



public class Chocolate extends Candy{
	private String chocolateType; //white, milk, dark
	
	public Chocolate (String sweetType, String name, String producedBy, double price, long weight, long calories, String chocolateType){
		super(sweetType, name, producedBy, price, weight, calories);
		this.chocolateType=chocolateType;
	}
	
	public Chocolate(){
		super();
	}
	
	@Override
	public String toString() {
		StringWriter result = new StringWriter();
		PrintWriter out = new PrintWriter(result, true);
		
			
		out.println("{");	
		out.println("Name: "+this.getName());
		out.println("Produced By: "+this.getProducedBy());
		out.println("Price: "+this.getPrice());
		out.println("Weght: "+this.getWeight());
		out.println("Calories: "+this.getCalories());
		out.println("Chocolate Type: "+this.getChocolateType());
		out.println("}");
		
		return result.toString();
	}
	
	public void setChololateType(String chocolateType){
		this.chocolateType=chocolateType;
	}
	
	public String getChocolateType(){
		return chocolateType;
	}

}
