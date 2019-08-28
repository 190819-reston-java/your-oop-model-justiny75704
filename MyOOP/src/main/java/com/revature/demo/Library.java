package com.revature.demo;

import java.util.ArrayList;
import java.util.Collection;

public class Library extends ArrayList<WorkOfArt> {

	public Library() {
		this(10);
	}

	public Library(int initialCapacity) {
		super(initialCapacity);
		
	}

	public Library(Collection<? extends WorkOfArt> c) {
		super(c);
	}

}
