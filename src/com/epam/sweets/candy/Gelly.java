package com.epam.sweets.candy;

import java.io.PrintWriter;
import java.io.StringWriter;



public class Gelly extends Candy{
	private String flavour;
	
	public Gelly (String sweetType, String name, String producedBy, double price, int weight, int calories, String flavour){
		super(sweetType, name, producedBy, price, weight, calories);
		this.flavour=flavour;
	}
	
	public Gelly(){
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
		out.println("Caramel Type: "+this.getFlavour());
		out.println("}");
		
		return result.toString();
	}
	
	public void setFlavour(String flavour){
		this.flavour=flavour;
	}
	
	public String getFlavour(){
		return flavour;
	}


}
