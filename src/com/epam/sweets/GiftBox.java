package com.epam.sweets;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.epam.exceptions.EmptyGiftException;



public class GiftBox {
	private List<Sweets> items = new ArrayList<Sweets>();
	
	public double getPrice() throws EmptyGiftException{
		double result = 0;		
			if (items.isEmpty()){
				throw new EmptyGiftException();
			}
			for (Sweets item : items) {
				
				result += item.getPrice();
			} 	
		
		return result;
	}
	
	public double getWeight()throws EmptyGiftException{
		double result = 0;
		if (items.isEmpty()){
			throw new EmptyGiftException();
		}
		
		for (Sweets item : items) {
			result += item.getWeight();
		}
		
		return result;
	}
	
	public List<Sweets> getSweets(){
		return items;
	}
	
	public void setSweets(List<Sweets> items) {
		this.items = items;
	}

	public void addSweet(Sweets item){
		items.add(item);
	}
	
	public void deleteSweet(String name){
		for (Sweets item: items) {
			if (item.getName().equals(name)) {
				items.remove(item);
				break;
			}
		}
	}

	@Override
	public String toString() {
		StringWriter result = new StringWriter();
		PrintWriter out = new PrintWriter(result, true);
		
		out.println("{");
		for (int i = 0; i < items.size(); i++) {
			out.print(items.get(i));
			if (i < items.size() - 1) {
				out.println(",");
			}
		}
		out.println("}");
		
		return result.toString();
	}
}
