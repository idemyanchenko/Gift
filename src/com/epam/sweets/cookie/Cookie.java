package com.epam.sweets.cookie;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.epam.sweets.Sweets;

public class Cookie implements Sweets{
	private String sweetType;
	private String name;
	private String producedBy;
	private double price; 
	private int weight;
	private int calories;	
	private boolean isPacked;

	public Cookie(){
		
	}
	
	public Cookie(String sweetType, String name, String producedBy, double price, int weight, int calories, boolean isPacked){
		this.sweetType=sweetType;
		this.name=name;
		this.producedBy=producedBy;
		this.price=price;
		this.weight=weight;
		this.calories=calories;

		this.isPacked=isPacked;		
	}
	
	public String getSweetType() {
		return sweetType;
	}

	public void setSweetType(String sweetType) {
		this.sweetType = sweetType;
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
		out.println("Calories: "+ this.getCalories());
		out.println("isPacked: "+ this.getIsPacked());
		out.println("}");
		
		return result.toString();
	}
	
	public void setName (String name){		
		this.name=name;		
	}
	
	@Override
	public String getName (){
		return name;
	}
	
	public void setProducedBy (String producedBy){
		this.producedBy=producedBy;
	}
	
	@Override
	public String getProducedBy (){
		return producedBy;
	}
	
	public void setPrice (double price){
		this.price=price;
	}
	
	@Override
	public double getPrice (){
		return price;
	}
	
	public void setIsPacked(boolean isPacked){
		this.isPacked=isPacked;
	}
	
	public boolean getIsPacked(){
		return isPacked;
	}
	
	public void setWeight (int weight){
		this.weight=weight;
	}
	
	@Override
	public int getWeight (){
		return weight;
	}
	
	public void setCalories(int calories){
		this.calories=calories;
	}
	
	public int getCalories(){
		return calories;
	}

	@Override
	public int compareTo(Sweets sweet) {
		if (this.calories==sweet.getCalories()){
			return 0;
		} else if (this.calories<sweet.getCalories()){
			return -1;
		} else {
			return 1;
		}
	}
	



}

