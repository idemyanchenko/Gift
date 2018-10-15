package com.epam.main;

import java.util.Collections;
import java.util.List;
import com.epam.sweets.GiftBox;
import com.epam.sweets.Sweets;
import com.epam.main.GiftApplicationEntryPoint;
import com.epam.datasources.DatabaseGiftBoxReader;
import com.epam.datasources.FileGiftBoxReader;
import com.epam.exceptions.EmptyGiftException;
import com.epam.exceptions.NoSweetFoundException;

public class GiftApplicationEntryPoint {
	
	public static void main (String args[]) throws NoSweetFoundException, EmptyGiftException{
		
		GiftBox gift = new GiftBox();
		
		FileGiftBoxReader giftReader = new FileGiftBoxReader();
//		RandomGiftBoxReader giftReader = new RandomGiftBoxReader();
//		DatabaseGiftBoxReader giftReader = new DatabaseGiftBoxReader();
		
		try{
			gift=giftReader.readGiftBox();
		} catch (Exception e){
			System.out.print(e);
		}		
		System.out.println("Gift : " + gift);
		
		List<Sweets> list = gift.getSweets();
		
		try {
			if (list.isEmpty()){
				throw new EmptyGiftException();
			}
			for (Sweets item: list) {
				if (item.getPrice()<2.0 & item.getCalories()<100) {
					System.out.print("Found item is: "+item);
					break;
				} else{
					throw new NoSweetFoundException();
				}
			}
		} catch (EmptyGiftException e){
			System.out.println("The GiftBox is empty");
		} catch (NoSweetFoundException e){
			System.out.println("Sweet with the defined parameters is not in the GiftBox");
		}
		
		Collections.sort(list);
        
		System.out.println("Sorted gift : " + gift);
		
		try {
			System.out.println("Gift weight: " + gift.getWeight());
		} catch (EmptyGiftException e)
		{
			System.out.println("The GiftBox is empty");
		}
		
		try {
			System.out.println("Gift price: " + gift.getPrice());
		} catch (EmptyGiftException e)
		{
			System.out.println("The GiftBox is empty");
		}
		System.out.println("End");
		
		
	}	

}