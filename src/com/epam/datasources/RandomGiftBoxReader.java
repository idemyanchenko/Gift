package com.epam.datasources;

import com.epam.sweets.GiftBox;
import com.epam.sweets.candy.Caramel;
import com.epam.sweets.candy.Chocolate;
import com.epam.sweets.candy.Gelly;
import com.epam.sweets.cookie.Cookie;

public class RandomGiftBoxReader implements GiftBoxReader{
	
	@Override
	public GiftBox readGiftBox() throws Exception{
		
		GiftBox gb = new GiftBox();		

		int numberOfSweets = (int)(Math.random()*10 + 1);
		for (int i = 0; i < numberOfSweets; i++) {
			int key = (int)(Math.random()*5);
			switch (key) {
			case 1:
				gb.addSweet(new Chocolate ("Chocolate", "Mars", "Nestle", 2.5, 25, 500, "Milk"));
				break;
			case 2:
				gb.addSweet(new Caramel ("Caramel", "Korovka", "Kommunarka", 2.0, 15, 100, "Soft", "Milk"));
				break;
			case 3:
				gb.addSweet(new Gelly ("Gelly", "Mad Bee", "Roshen", 1.0, 10, 50, "Pear"));
				break;
			default:
				gb.addSweet(new Cookie ("Cookie", "Orio", "Nestle", 2.0, 100, 100, true));
				break;
			}
		}
		return gb;
		
	}

}
