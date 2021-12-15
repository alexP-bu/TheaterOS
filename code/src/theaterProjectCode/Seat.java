package theaterProjectCode;
public class Seat{
	private boolean isReserved;
	/*
	 * constructors
	 */

	public Seat() {
		this.isReserved = false;
	}
	// check if seat is reserved
	public boolean isReserved() {
		return isReserved;
	}
	//setter for reserved
	public void reserve(boolean reserved){
		isReserved = reserved;
	}
	
	@Override
	public String toString() {
		if(isReserved){
			return "[X]";
		}else {
			return "[O]";
		}
	}
}
