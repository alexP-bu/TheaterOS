package theaterProjectCode;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Showtime implements Serializable{
	private Movie movie;
	private Date date;
	private HashMap<String,Theater> theaters;
	private double price;
	/*
	 * constructors
	 */
	public Showtime(Movie movie, Date date, Map<String,Theater> theaters, double price) {
		this.movie = movie;
		this.date = date;
		this.theaters = new HashMap<String,Theater>(theaters);
		this.price = price;
	}
	/*
	 * getters and setters
	 */
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Map<String,Theater> getTheaters() {
		return theaters;
	}
	public void setTheaters(Map<String,Theater> theaters) {
		this.theaters = new ArrayList<Theater>(theaters);
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	/*
	 * check if theater is listed in theater list
	 */
	public boolean isListed(String id) {
		return theaters.containsKey(id);
	}
	/*
	 * return string containing theater list for this showtime
	 */
	public String getTheaterList() {
		StringBuilder sout = new StringBuilder();
		for(String key : theaters.keySet()){
			sout.append(key);
		}
		return sout.toString();
	}
	/*
	 * add a theater to show time
	 */
	public void addTheater(Theater theater) {
		theaters.put(theater.getTheaterID(), theater);
	}
	/*
	 * get theater by ID, returns a null theater if it doesnt exist
	 */
	@Override
	public String toString() {
		StringBuilder sout = new StringBuilder(movie.getName() + "; Premiering in theaters ");
		if(!theaters.isEmpty()) {
			for(String theaterID : theaters.keySet()) {
				sout.append(theaterID);
			}
			//remove trailing comma
			sout.substring(0, sout.length() - 1);
		}
		sout.append(" at " + this.date.toString() + "\n");
		return sout.toString();
	}
	/*
	 *test harness code 
	 */
	public static void main(String[] args) {
		Showtime show1 = new Showtime();
		show1.setDate(new Date());
		//test printing
		System.out.println(show1.toString());
		//create some default theaters to store
		Theater theater1 = new Theater();
		Theater theater2 = new Theater();
		//add two theaters
		show1.addTheater(theater1);
		show1.addTheater(theater2);
		System.out.println("Showtime info:");
		System.out.println(show1.toString());
	}
}