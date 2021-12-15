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
}