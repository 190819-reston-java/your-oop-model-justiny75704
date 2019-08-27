package com.revature.demo;

public abstract class WorkOfArt {
	private String creator;
	private String title;
	private int year;
	
	public WorkOfArt(String creator, String title, int year) {
		this.creator = creator;
		this.title = title;
		this.year = year;
	}

	@Override
	public String toString() {
		return "WorkOfArt [creator=" + creator + ", title=" + title + ", year=" + year + "]";
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public abstract String consumed();
	
}
