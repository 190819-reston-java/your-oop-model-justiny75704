package com.revature.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;
import org.apache.log4j.Logger;

public class ArtDriver {
	
	public static Logger logger = Logger.getLogger(ArtDriver.class);
	
	public static void main(String[] args) {
		Novel book1 = new Novel();
		Novel book2 = new Novel("Haruki Murakami", "Norwegian Wood", 1987);
		Novel book3 = new Novel("Emily Brontë", "Wuthering Heights", 1847);
		Novel book4 = new Novel("William Faulkner", "The Sound and the Fury", 1929);
		Novel book5 = new Novel("Joseph Conrad", "The Heart of Darkness", 1902);
		
		Film film1 = new Film();
		Film film2 = new Film("Spike Jonze", "Her", 2013);
		Film film3 = new Film("Sofia Coppola","Lost in Translation", 2003);
		
		System.out.println(book1.read());
		System.out.println(book2.consumed());
		System.out.println(book3.consumed(true));
		System.out.println(film1.consumed());
		System.out.println(film2.consumed(false) + "\n");
		
		TreeSet<Novel> sortedLibrary = new TreeSet<Novel>();
		sortedLibrary.add(book1);
		sortedLibrary.add(book2);
		sortedLibrary.add(book3);
		sortedLibrary.add(book4);
		sortedLibrary.add(book5);
		
		System.out.println("Printing sorted library by title...");
		for(Novel ele : sortedLibrary) {
			System.out.println(ele);
		}
		
		System.out.println();
		createLibrary();
		
	}
	
	public static void createLibrary() {
		System.out.println("Time to create your own film library.");
		
		Path p = null;
		try {
			p = Files.createFile(Paths.get("YourFilmLibrary.txt"));
		} catch (IOException e) {
			logger.error("Library creation failed.", e);
		}
		logger.info("Library successfully created: " + p);
		
		Scanner sc = new Scanner(System.in);
		TreeSet<Film> userLibrary = new TreeSet<Film>(new ArtYear());
		String con = "YES";
		
		while(con.equals("YES")) {
			System.out.print("Enter in the title of your favorite film: ");
			String title = sc.nextLine();
			
			System.out.print("Next, enter the director of " + title + ": ");
			String director = sc.nextLine();
			
			System.out.print("Finally, enter the year " + title + " was released: ");
			int date = sc.nextInt();
			sc.nextLine();
			
			Film userFilm = new Film(director, title, date);
			logger.trace("Object successfully created.");
			userLibrary.add(userFilm);
			logger.trace("Object successfully added to TreeSet.");
			
			System.out.print("Would you like to enter another film? (Type in 'YES' to continue or 'NO' to stop): ");
			con = sc.nextLine();
		}
		
		if (con.equals("NO")) {
			sc.close();
			for (Film ele : userLibrary) {
				String content = ele.toString();
				try {
					Files.write(p, Collections.singleton(content), StandardOpenOption.APPEND);
				} catch (IOException e) {
					logger.fatal("Writing to library file failed. Exiting", e);
				}
			}
			logger.info("All lines written to library file successfully, exiting.");
			System.out.println("Your library of favorite films has been created! Films have been sorted by their release years.");
		}
	}
}
