package theaterProjectCode;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Date implements Serializable{
	/**
	 * id
	 */
	private static final long serialVersionUID = -496635546555161762L;
	private transient Scanner reader = new Scanner(System.in);
	private int month;
	private int day;
	private int year;
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
	/*
	 * default constructor sets date to current date 
	 */
	public Date() {
		LocalDateTime date = LocalDateTime.now();
		this.month = date.getMonthValue();
		this.day = date.getDayOfMonth();
		this.year = date.getYear();
		this.hours = date.getHour();
		this.minutes = date.getMinute();
	}
	
	/*
	 * getters and setters
	 */
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	/*
	 * methods
	 */
	public Date createDate() {
		System.out.println("Enter year number when showtime is on: ");
		int years = getNumInput();
		System.out.println("Enter month number when showtime is on: ");
		int months = getNumInput();
		System.out.println("Enter date number when showtime is on: ");
		int days = getNumInput();
		System.out.println("Enter hour number when showtime is on (24 hour clock): ");
		int hour = getNumInput();
		System.out.println("Enter minutes when showtimes is on: ");
		int minute = getNumInput();
		return new Date(months, days, years, hour, minute);
	}
	/*
	 * get number from user
	 */
	private int getNumInput() {
		int input = 0;
		do {
			try {
				input = Integer.parseInt(reader.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println(e);
			}
			System.out.println("invalid input entered! try again");
		}while(true);
		
		return input;
	}
	
	@Override
	public String toString() {
		return this.hours + ":" + this.minutes + " on " + this.month + "/" + this.day + "/" + this.year;
	}
}
