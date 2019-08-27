package com.revature.demo;

import java.io.Serializable;

public class Film extends WorkOfArt implements Serializable {
	public static int numOfInstantiations = 0;

	public Film() {
		this("Eternal Sunshine of the Spotless Mind", "Michael Gondry", 2004);
	}

	public Film(String creator, String title, int year) {
		super(creator, title, year);
		numOfInstantiations++;
	}

	@Override
	public String consumed() {
		String consumed = "Everyone should watch " + this.getTitle() + " at least once.";
		return consumed;
	}
	
	public String consumed(boolean answer) {
		String consumed = "";
		if (answer) {
			consumed = this.getTitle() + " was an amazing film!";
		} else {
			consumed = "I heard " + this.getTitle() + " is a great film, but I haven't watched it yet.";
		}
		return consumed;
	}
}
