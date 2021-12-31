package cli;
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
	//setter for reserving
	public void reserve(){
		isReserved = true;
	}
	//setter for unreserving
	public void unreserve(){
		isReserved = false;
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
