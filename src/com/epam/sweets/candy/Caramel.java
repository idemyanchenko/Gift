package com.epam.sweets.candy;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Caramel extends Candy {
	private String caramelType;
	private String flavour;

	public Caramel() {
		super();
	}

	public Caramel(String sweetType, String name, String producedBy, double price, long weight, long calories, String caramelType, String flavour) {
		super(sweetType, name, producedBy, price, weight, calories);
		this.caramelType = caramelType;
		this.flavour = flavour;
	}

	public String getCaramelType() {
		return caramelType;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setCaramelType(String caramelType) {
		this.caramelType = caramelType;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	@Override
	public String toString() {
		StringWriter result = new StringWriter();
		PrintWriter out = new PrintWriter(result, true);

		out.println("{");
		out.println("Name: " + this.getName());
		out.println("Produced By: " + this.getProducedBy());
		out.println("Price: " + this.getPrice());
		out.println("Weght: " + this.getWeight());
		out.println("Calories: " + this.getCalories());
		out.println("Caramel Type: " + this.getCaramelType());
		out.println("Flavour: " + this.getFlavour());
		out.println("}");

		return result.toString();
	}

}
