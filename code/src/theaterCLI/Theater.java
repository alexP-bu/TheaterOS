package theaterCLI;
public class Theater{
	private String id;
	private Seat[][] seatingChart;

	/*
	 *constructors 
	 */
	public Theater(String id, Seat[][] seatingChart) {
		this.id = id;
		this.seatingChart = seatingChart;
	}
	//create theater with default seating chart
	public Theater(String id, int rows, int cols) {
		this.id = id;
		this.seatingChart = new Seat[rows][cols];
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
	//reserve seat in seating chart
	public boolean reserve(int row, int col) {
		if(seatingChart[row][col].isReserved()){
			return false;
		} else {
			seatingChart[row][col].reserve();
			return true;
		}
    }
	public boolean unreserve(int row, int col){
		if(seatingChart[row][col].isReserved()){
			seatingChart[row][col].unreserve();
			return true;
		}
		return false;
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
}
