package com.epam.datasources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.epam.sweets.GiftBox;
import com.epam.sweets.candy.Caramel;
import com.epam.sweets.candy.Chocolate;
import com.epam.sweets.candy.Gelly;
import com.epam.sweets.cookie.Cookie;

public class DatabaseGiftBoxReader implements GiftBoxReader{
	
	@Override
	public GiftBox readGiftBox() throws Exception{
		
		GiftBox gb = new GiftBox();	
		
		try{  
			
			Connection con=DriverManager.getConnection("jdbc:mysql://10.6.113.94:3306/shop","Administrator","Test1234!");  
			
			Statement stmt=con.createStatement();  			
			
			ResultSet giftRS=stmt.executeQuery("select * from giftbox");				
			
			while(giftRS.next()) { 
				
				Statement stmtSweet=con.createStatement(); 
				ResultSet sweetRS = stmtSweet.executeQuery("select * from "+giftRS.getString(3).toLowerCase()+" where sweetid="+giftRS.getString(4));
				sweetRS.next();
				
				switch (giftRS.getString(3)){
					case ("Caramel"):
						Caramel caramel = new Caramel(sweetRS.getString(2),sweetRS.getString(3), sweetRS.getString(4),sweetRS.getDouble(5),sweetRS.getInt(6), sweetRS.getInt(7),sweetRS.getString(8),sweetRS.getString(9));
						for (int i=0; i<giftRS.getInt(5);i++){
							gb.addSweet(caramel);
						}				
						break;
					case ("Chocolate"):
						Chocolate chocolate = new Chocolate(sweetRS.getString(2),sweetRS.getString(3), sweetRS.getString(4),sweetRS.getDouble(5),sweetRS.getInt(6),sweetRS.getInt(7),sweetRS.getString(8));
						for (int i=0; i<giftRS.getInt(5);i++){
							gb.addSweet(chocolate);
						}			
						break;
					case ("Gelly"):
						Gelly gelly = new Gelly(sweetRS.getString(2), sweetRS.getString(3), sweetRS.getString(4),sweetRS.getDouble(5),sweetRS.getInt(6),sweetRS.getInt(7),sweetRS.getString(8));					
						for (int i=0; i<giftRS.getInt(5);i++){
							gb.addSweet(gelly);
		    			}	
						break;
					case ("Cookie"):
						Cookie cookie = new Cookie(sweetRS.getString(2),sweetRS.getString(3), sweetRS.getString(4),sweetRS.getDouble(5),sweetRS.getInt(6),sweetRS.getInt(7),sweetRS.getBoolean(8));
						for (int i=0; i<giftRS.getInt(5);i++){
							gb.addSweet(cookie);
						}	
						break;
				}					
			}
			con.close();  
			}catch(Exception e){ 
				System.out.println(e); 
			}  
		return gb;		
	}

}
