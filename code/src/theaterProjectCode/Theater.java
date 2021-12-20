package theaterProjectCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Theater{
	private String id;
	private Seat[][] seatingChart;
	private static final File settings = new File("theater_settings.txt");
	private int defaultRows = 10;
	private int defaultCols = 10;

	/*
	 *constructors 
	 */
	public Theater(String id, Seat[][] seatingChart) {
		this.id = id;
		this.seatingChart = seatingChart;
	}
	//create theater with default seating chart
	public Theater(String id) {
		this.id = id;
		readTheaterSettings();
		this.seatingChart = new Seat[defaultRows][defaultCols];
	}
	//return theater ID
	public String getTheaterID(){
		return id;
	}
	/*
	 * check if theater has empty seatsl
	 */
	public boolean hasEmptySeats() {
		for(Seat[] seatRows : seatingChart){
			for(Seat seat : seatRows){
				if (!seat.isReserved()){
					return true;
				}
			}
		}
		return false;
	}
	//read settings file
	public void readTheaterSettings(){
		if((settings.exists()) && (settings.length() > 0)){
			try (BufferedReader reader = new BufferedReader(new FileReader(settings))){
				defaultRows  = Integer.parseInt(reader.readLine());
				defaultCols = Integer.parseInt(reader.readLine());
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	@Override
	public String toString() {
		StringBuilder sout = new StringBuilder();
		sout.append("***********************************"  + "\n");
		sout.append("       THEATER " + id 		   + "\n"); 
		sout.append("***********************************"  + "\n");
		for(Seat[] row : seatingChart){
			sout.append(row + "\n");
		}
		return sout.toString();
	}
	public static void main(String[] args) {
		Theater theater = new Theater("1");
		System.out.println(theater.toString());
	}
}
