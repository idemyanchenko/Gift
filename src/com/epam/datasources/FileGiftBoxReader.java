package com.epam.datasources;

import java.io.FileReader;

import com.epam.sweets.GiftBox;
import com.epam.sweets.candy.Caramel;
import com.epam.sweets.candy.Chocolate;
import com.epam.sweets.candy.Gelly;
import com.epam.sweets.cookie.Cookie;
import com.opencsv.CSVReader;

public class FileGiftBoxReader implements GiftBoxReader {

	@Override
	public GiftBox readGiftBox() throws Exception {

		CSVReader fr = new CSVReader(new FileReader("D:/Learning_JAVA/workspace/GiftsApplication/input/GiftBox.txt"));

		GiftBox gb = new GiftBox();

		String[] nextLine;
		while ((nextLine = fr.readNext()) != null) {
			switch (nextLine[0]) {
			case ("Caramel"):
				Caramel caramel = new Caramel(nextLine[0], nextLine[2], nextLine[3], Double.parseDouble(nextLine[4]), Integer.parseInt(nextLine[5]), Integer.parseInt(nextLine[6]), nextLine[0], nextLine[7]);
				for (int i = 0; i < Integer.parseInt(nextLine[1]); i++) {
					gb.addSweet(caramel);
				}
				System.out.println(caramel);
				break;
			case ("Chocolate"):
				Chocolate choco = new Chocolate(nextLine[0], nextLine[2], nextLine[3], Double.parseDouble(nextLine[4]), Integer.parseInt(nextLine[5]), Integer.parseInt(nextLine[6]), nextLine[7]);
				for (int i = 0; i < Integer.parseInt(nextLine[1]); i++) {
					gb.addSweet(choco);
				}
				System.out.println(choco);
				break;
			case ("Gelly"):
				Gelly gelly = new Gelly(nextLine[0], nextLine[2], nextLine[3], Double.parseDouble(nextLine[4]), Integer.parseInt(nextLine[5]), Integer.parseInt(nextLine[6]), nextLine[0]);
				for (int i = 0; i < Integer.parseInt(nextLine[1]); i++) {
					gb.addSweet(gelly);
				}
				System.out.println(gelly);
				break;
			case ("Cookie"):
				Cookie cookie = new Cookie(nextLine[0], nextLine[2], nextLine[3], Double.parseDouble(nextLine[4]), Integer.parseInt(nextLine[5]), Integer.parseInt(nextLine[6]), Boolean.parseBoolean(nextLine[0]));
				for (int i = 0; i < Integer.parseInt(nextLine[1]); i++) {
					gb.addSweet(cookie);
				}
				System.out.println(cookie);
				break;
			}
		}

		fr.close();

		return gb;
	}

}
