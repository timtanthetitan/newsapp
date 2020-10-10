// Author: Tim Li
//
// This file contains the class of a database
// Synchronized with Spiderbots and retrieves information from them
// can store information in excel spread sheet
// can read information from excel spread sheet
//
// Last Modified: 7/9/20

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {
	//these are parallel arraylists
	private static ArrayList<String> links = new ArrayList<String>();
	private static ArrayList<String> titles = new ArrayList<String>();
	private static ArrayList<String> sources = new ArrayList<String>();
	
	//constructor
	public DataBase() {		}
	
	//****************** Synchronized Method ******************
	public static synchronized void feed_info(String link, String title, String source) {
		links.add(link);
		titles.add(title);
		sources.add(source);
//		System.out.println("Link: " + link);
//		System.out.println("Title: " + title);
//		System.out.println("Source: " + source);
	}
	
	//******************   Public   Method   ******************
	public static void store_info() {
		clear();
		try {
			FileWriter writer = new FileWriter("data", true);
			BufferedWriter b_writer = new BufferedWriter(writer);
			
			for(int i = 2; i < links.size(); i++) {
				b_writer.write(links.get(i));
				b_writer.newLine();
				b_writer.write(titles.get(i));
				b_writer.newLine();
				b_writer.write(sources.get(i));
				b_writer.newLine();
			}
			b_writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void extract_info() {
		try {
			File file = new File("data");
			Scanner scanner = new Scanner(file);
			
			links.clear();
			titles.clear();
			sources.clear();
			
			while (scanner.hasNextLine()) {
				links.add(scanner.nextLine());
				titles.add(scanner.nextLine());
				sources.add(scanner.nextLine());
			}
			
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//******************   Private  Method   ******************
	private static void clear(){
		FileWriter a;
		PrintWriter b;
		try {
			a = new FileWriter("data", false);
			b = new PrintWriter(a, false);
			b.flush();
			b.close();
			a.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//******************** Accessors ***********************
	public static ArrayList<String> getLinks() {
		return links;
	}

	public static ArrayList<String> getTitles() {
		return titles;
	}

	public static ArrayList<String> getSources() {
		return sources;
	}
}
