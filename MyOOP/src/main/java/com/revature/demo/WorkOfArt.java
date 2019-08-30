package com.revature.demo;

public abstract class WorkOfArt implements Comparable<WorkOfArt> {
	private String creator;
	private String title;
	private int year;
	
	public WorkOfArt(String creator, String title, int year) {
		this.creator = creator;
		this.title = title;
		this.setYear(year);
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
		if (year < 0) {
			throw new NegativeYearException();
		} else {
			this.year = year;
		}
		
	}
	
	public abstract String consumed();
	
	public int compareTo(WorkOfArt o) {
		if(o.getTitle().substring(0, 3).equals("The")) {
			return this.title.compareTo(o.getTitle().substring(4));
		}
		else if(this.title.substring(0, 3).equals("The")) {
			return (this.title.substring(4).compareTo(o.getTitle()));
		}
		else if(o.getTitle().substring(0, 3).equals("The") && this.title.substring(0, 3).equals("The")) {
			return (this.title.substring(4).compareTo(o.getTitle().substring(4)));
		}
		else {
			return this.title.compareTo(o.getTitle());
		}
	}
	
}
