package com.revature.demo;

import java.io.Serializable;

public class Novel extends WorkOfArt implements Serializable, Written {
	
	public static int numOfInstantiations = 0;

	public Novel() {
		this("Tony Morrison", "The Bluest Eye", 1970);
	}

	public Novel(String creator, String title, int year) {
		super(creator, title, year);
		numOfInstantiations++;
	}

	public String read() {
		String confirmation = this.getTitle() + " is a written work of art.";
		return confirmation;

	}

	@Override
	public String consumed() {
		String consumed = this.read() + " Everyone should read it.";
		return consumed;
	}
	
	public String consumed(boolean answer) {
		String consumed = "";
		if (answer) {
			consumed = this.read() + " It was a page-turner!";
			
		} else {
			consumed = this.read() + " But, I haven't had a chance to read it yet.";
		}
		return consumed;	
	}

}
