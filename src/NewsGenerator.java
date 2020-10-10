import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import test.test1;

// Author: Tim Li
//
// -- Purpose -- 
// It is a software app that gathers latest news about coronavirus.
// -- Features --
// 	* Multi-Threaded Spiderbots
//  * Excel Database
//  * Graphical UserInterface
//
// This is the main class file.
// 
// Last Modified: 7/13/20

public class NewsGenerator {

	public static void main(String[] args){
		loading_screen loading = new loading_screen();
		loading.setVisible(true);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		loading.setVisible(false);
		loading.dispose();
		
		search_screen searching = new search_screen();
		searching.setVisible(true);
		
		while(true) {
			if(searching.isclicked())
				break;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		String search = searching.getKeyWord();
		System.out.println("Gathering Articles on " + search);
		
		searching.setVisible(false);
		searching.dispose();
		
		updating_screen update = new updating_screen();
		update.setVisible(true);
		
		ArrayList<SpiderBot> bots = new ArrayList<>();
		bots.add(new SpiderBot("CNN", "https://www.cnn.com", search));
		bots.add(new SpiderBot("FOX", "https://www.foxnews.com", search));
		bots.add(new SpiderBot("ABC", "https://abcnews.go.com", search));
		bots.add(new SpiderBot("NPR", "https://www.npr.org", search));
		bots.add(new SpiderBot("The New York Times", "https://www.nytimes.com", search));
		bots.add(new SpiderBot("MSNBC", "https://www.msnbc.com", search));
		bots.add(new SpiderBot("NBC", "https://www.nbcnews.com", search));
		
		for(SpiderBot b : bots) {
			try {
				b.getThread().join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		DataBase.store_info();
		DataBase.extract_info();
		
		update.setVisible(false);
		update.dispose();
		
		front_page.run(DataBase.getLinks(), DataBase.getSources(), DataBase.getTitles());
		
//		SpiderBot bot001 = new SpiderBot("Google News", "https://news.google.com/topstories?hl=en-US&gl=US&ceid=US:en");
//		SpiderBot bot002 = new SpiderBot("Fox News", "https://www.foxnews.com");
//		SpiderBot bot003 = new SpiderBot("CNN News", "https://www.cnn.com");
//		
//		try {
//			bot001.getThread().join();
//			bot002.getThread().join();
//			bot003.getThread().join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("Program Finished Crawling");
//		DataBase.store_info();
	}

}
