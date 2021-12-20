package theaterProjectCode;
import java.util.HashMap;
import java.util.Map;

public class Showtime{
	private String name;
	private Movie movie;
	private Date date;
	private double price;
	private Map<String,Theater> theaters;
	/*
	 * constructors
	 */
	private Showtime(ShowtimeBuilder builder) {
		this.name = builder.name;
		this.movie = builder.movie;
		this.date = builder.date;
		this.theaters = builder.theaters;
		this.price = builder.price;
	}
	//showtime builder class
	public static class ShowtimeBuilder{
		private String name;
		private Movie movie;
		private Date date;
		private double price;
		private Map<String,Theater> theaters;

		public ShowtimeBuilder(String name){
			this.name = name;
		}

		public ShowtimeBuilder movie(Movie movie){
			this.movie = movie;
			return this;
		}

		public ShowtimeBuilder date(Date date){
			this.date = date;
			return this;
		}

		public ShowtimeBuilder price(double price){
			this.price = price;
			return this;
		}

		public ShowtimeBuilder addTheater(Theater theater){
			if(this.theaters == null){
				this.theaters = new HashMap<String,Theater>();
			}
			this.theaters.put(theater.getTheaterID(), theater);
			return this;
		}

		public Showtime build(){
			return new Showtime(this);
		}
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
	public double getTicketPrice(){
		return price;
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