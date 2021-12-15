package theaterProjectCode;
public class Ticket{
	private String showtimeID;
	private String theaterID;
	private String seatID;
	private double price;
	private Date datePurchased;

	public Ticket(String sID, String tID, String seatID, double price, Date date) {
		this.showtimeID = sID;
		this.theaterID = tID;
		this.seatID = seatID;
		this.price = price;
		this.datePurchased = date;
	}

	@Override
	public String toString() {
		return "Ticket Purchased For: " + showtimeID + ", theater " + theaterID + ", seat " + seatID + ", " + price + "\n"
				+ "Purchase date: " + datePurchased;
	}
}
