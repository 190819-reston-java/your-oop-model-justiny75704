package com.revature.demo;

import java.util.HashMap;

public class ArtDriver {
	public static void main(String[] args) {
		Novel book1 = new Novel();
		Novel book2 = new Novel("Haruki Murakami", "Norwegian Wood", 1987);
		Novel book3 = new Novel("Emily Brontë", "Wuthering Heights", 1847);
		
		Film film1 = new Film();
		Film film2 = new Film("Spike Jonze", "Her", 2013);
		Film film3 = new Film("Sofia Coppola","Lost in Translation", 2003);
		
		HashMap<String, Novel> library = new HashMap<String, Novel>();
		library.put(book1.getTitle(), book1);
		library.put(book2.getTitle(), book2);
		library.put(book3.getTitle(), book3);
		
		for (HashMap.Entry<String, Novel> entry : library.entrySet()) {
			System.out.println("Title = " + entry.getKey() + ", Details = " + entry.getValue());
		}
	}
}
