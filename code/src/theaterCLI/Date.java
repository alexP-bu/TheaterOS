package theaterCLI;
public class Date {
	private int year;
	private int month;
	private int day;
	private int hours;
	private int minutes;
	
	/*
	 * constructors
	 */
	
	public Date(int month, int day, int year, int hours, int minutes) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.hours = hours;
		this.minutes = minutes;
	}
	
	@Override
	public String toString() {
		return this.hours + ":" + this.minutes + " on " + this.month + "/" + this.day + "/" + this.year;
	}
}
