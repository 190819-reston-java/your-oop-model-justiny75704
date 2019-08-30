package com.revature.demo;

public class NegativeYearException extends RuntimeException { //unchecked exception
	
	public NegativeYearException() {
		this("A work of art cannot have been created in a negative year.");
	}
	
	public NegativeYearException(String m) {
		super(m);
	}
}
