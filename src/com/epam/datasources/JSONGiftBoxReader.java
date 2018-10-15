package com.epam.datasources;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.epam.sweets.GiftBox;
import com.epam.sweets.candy.Caramel;
import com.epam.sweets.candy.Chocolate;
import com.epam.sweets.candy.Gelly;
import com.epam.sweets.cookie.Cookie;

public class JSONGiftBoxReader implements GiftBoxReader{
	
	public GiftBox readGiftBox () throws Exception{
		
		GiftBox gb = new GiftBox();
		
		JSONParser parser = new JSONParser();
		
        try {
        	JSONObject obj = (JSONObject)parser.parse(new FileReader("C:/Users/Irina_Demyanchenko/git/Gift/input/GiftBox.json"));
            JSONArray arr = (JSONArray) obj.get("giftbox");
    
            for(int i = 0 ; i< arr.size() ;i++){
                JSONObject object = (JSONObject) arr.get(i);
                String sweetType=object.get("sweetType").toString();
                
                switch (sweetType) {
        		case ("Caramel"):
        			Caramel caramel = new Caramel(object.get("sweetType").toString(), object.get("name").toString(), object.get("producedBy").toString(),  (double) object.get("price"), (long) object.get("weight"), (long) object.get("calories"), object.get("caramelType").toString(), object.get("flavour").toString());
        			for (int j = 0; j < (long) object.get("quantity"); j++) {
        				gb.addSweet(caramel);
        			}
        			System.out.println(caramel);
        			break;
        		case ("Chocolate"):
        			Chocolate choco = new Chocolate(object.get("sweetType").toString(), object.get("name").toString(), object.get("producedBy").toString(),  (double) object.get("price"), (long) object.get("weight"), (long) object.get("calories"), object.get("chocolateType").toString());
        			for (int j = 0; j < (long) object.get("quantity"); j++) {
        				gb.addSweet(choco);
        			}
        			System.out.println(choco);
        			break;
        		case ("Gelly"):
        			Gelly gelly = new Gelly(object.get("sweetType").toString(), object.get("name").toString(), object.get("producedBy").toString(),  (double) object.get("price"), (long) object.get("weight"), (long) object.get("calories"), object.get("flavour").toString());
        			for (int j = 0; j < (long) object.get("quantity"); j++) {
        				gb.addSweet(gelly);
        			}
        			System.out.println(gelly);
        			break;
        		case ("Cookie"):
        			Cookie cookie = new Cookie(object.get("sweetType").toString(), object.get("name").toString(), object.get("producedBy").toString(),  (double) object.get("price"), (long) object.get("weight"), (long) object.get("calories"), (boolean)object.get("ispacked"));
        			for (int j = 0; j < (long) object.get("quantity"); j++) {
        				gb.addSweet(cookie);
        			}
        			System.out.println(cookie);
        			break;
        		}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return gb;
	}
}
