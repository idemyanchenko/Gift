package com.epam.sweets.candy;

import com.epam.sweets.Sweets;


public abstract class Candy implements Sweets{
	private String sweetType;
	private String name;
	private String producedBy;
	private double price;
	private long weight;
	private long calories;	
	
	public String getSweetType() {
		return sweetType;
	}

	public void setSweetType(String sweetType) {
		this.sweetType = sweetType;
	}
	
	public Candy (){
		
	}
	public Candy (String sweetType, String name, String producedBy, double price, long weight, long calories) {
		this.name=sweetType;
		this.name=name;
		this.producedBy=producedBy;
		this.price=price;
		this.weight=weight;	
		this.calories=calories;
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
	
	public void setWeight (int weight){
		this.weight=weight;
	}
	
	public long getWeight (){
		return weight;
	}
	
	public void setCalories(int calories){
		this.calories=calories;
	}
	
	public long getCalories(){
		return calories;
	}

	

	
	
}
