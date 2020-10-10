// Author: Tim Li
// 
// This file contains the class file of a Spiderbot
// Implements Runnable, works with multi-thread, capable of running multiple web crawlers
// at ths same time
//
// Notice: Spiderbots are synchronzied with the database to feed information to the data-
// base
//
// Last Modified: 7/8/20

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderBot implements Runnable{
	private static final int MAX_DEPTH = 4;
	private static final int MAX_ARTICLES = 5;
	private static final String KEY = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 "
			+ "(KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	private Thread thread;
	private String source;
	private String first_link;
	private String keyWord;
	private int count;
	private ArrayList<String> visitedLinks = new ArrayList<>();
	
	//constructor
	public SpiderBot(String source, String link, String keyWord) {
		System.out.println("Spider Bot created: Crawling " + source);
		this.source = source;
		first_link = link;
		this.keyWord = keyWord.toLowerCase();
		count = 0;
		
		//create a thread for this spider bot and run it
		thread = new Thread(this);
		thread.start();
	}
	
	//**************** public  methods ****************
	@Override
	public void run() {
		crawl(1, first_link);
	}
	
	//**************** private methods ****************
	//a recursive method that crawls through all the links on a given page to a depth
	private void crawl(int level, String url) {
		if(count <= MAX_ARTICLES && level <= MAX_DEPTH) {
			level++;
			
			if(visitedLinks.contains(url) == false) {
				Document document = sendRequest(url);
				
				if(document != null) {
					
					if(document.title().length() > 25 && document.title().toLowerCase().contains(keyWord)) {
						DataBase.feed_info(url, document.title(), source);
						count += 1;
					}
					
					//call the recursion on selective links found
					for(String page : retrieveLinks(document)) {
						
//						//synchonize with database to feed database with information
//						String lowercase = page.toLowerCase();
//						if(page.length() > 25 && (lowercase.contains(keyWord))) {
//							crawl(level, page);
//						}
						crawl(level, page);
					}
				}
			}
		}
	}
	
	//this method requests connection to the url
	//returns:
	//	the document of the page
	//  null if the connection fails
	private Document sendRequest(String url) {
		try {
			//establish connection and get document
			Connection connection = Jsoup.connect(url).userAgent(KEY);
			Document htmlDocument = connection.get();
			
			//200 is the HTTP ok status code
			if(connection.response().statusCode() == 200) {
				System.out.println("\n**Visiting** Received webpage at " + url);
//				
				String title = htmlDocument.title();
				System.out.println(title);
//				
//				//add links
				visitedLinks.add(url);
				
				return htmlDocument;
			}
			return null;
			
//			if(!connection.response().contentType().contains("text/html")) {
//				System.out.println("Failed: Retrieved something other than html");
//				return false;
//			}
		}
		catch(IOException ioe) {
			//not successful in HTTP request
//			System.out.println("Unable to connect to url");
			return null;
		}
	}
	
	//this method retrieves links on the web page
	private ArrayList<String> retrieveLinks(Document doc){
		ArrayList<String> l = new ArrayList<>();
		
		Elements linksOnPage = doc.select("a[href]");
//		System.out.println("Found (" + linksOnPage.size() + ") links");
		
		for(Element link : linksOnPage) {
			l.add(link.absUrl("href"));
		}
		
		return l;
	}
	
	//**************** accessors and modifiers *****************
	public Thread getThread() {
		return thread;
	}
}
