package com.revature.demo;

import java.util.Comparator;

public class ArtYear implements Comparator<WorkOfArt> {

	@Override
	public int compare(WorkOfArt o1, WorkOfArt o2) {
		int out;
		out = o1.getYear() - o2.getYear();
		if(out == 0) {
			out = o1.compareTo(o2);
		}
		return out;
	}

}
