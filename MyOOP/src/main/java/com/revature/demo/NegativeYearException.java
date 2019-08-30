package com.revature.demo;

public class NegativeYearException extends RuntimeException{
	
	public NegativeYearException() {
		this("A work of art cannot have been created in a negative year.");
	}
	
	public NegativeYearException(String m) {
		super(m);
	}
}
