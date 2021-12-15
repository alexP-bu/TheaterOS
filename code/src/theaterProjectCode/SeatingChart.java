package theaterProjectCode;

import java.io.Serializable;

public class SeatingChart implements Serializable {
	private Seat[][] seats;

	/*
	 * constructors
	 */
	public SeatingChart(Seat[][] seats) {
		this.seats = seats;
	}

	/*
	 * constructor for seating chart given rows and columns
	 */
	public SeatingChart(int rows, int cols) {
		this.seats = new Seat[rows][cols];
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < this.seats[0].length; j++) {
				this.seats[i][j] = new Seat(((char) (i + 41)), j);
			}
		}
	}

	/*
	 * default seating chart constructor, populate 10x10 chart with empty seats
	 */
	public SeatingChart() {
		this.seats = new Seat[10][10];
		for (int i = 0; i < this.seats.length; i++) {
			for (int j = 0; j < this.seats[0].length; j++) {
				this.seats[i][j] = new Seat(((char) (i + 41)), j);
			}
		}
	}


	/*
	 * reserve seat in Seating Chart with no account
	 */
	public boolean reserveSeat(char row, int column) {
		if(seats[row][column].)
	}

	/*
	 * reserve seat in Seating Chart with account
	 */
	public boolean reserveSeat(char row, int column, Account account) {
		if (seats[((int) Character.toUpperCase(row)) - 65][column].reserveSeat(account)) {
			return true;
		}
		return false;
	}

	/*
	 * check if seating chart is full
	 */
	public boolean hasEmptySeats() {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (!(seats[i][j].isReserved())) {
					return true;
				}
			}
		}
		return false;
	}

	public String toString() {
		String str = "   ";
		for (int i = 0; i < seats[0].length; i++) {
			str += Integer.toString(i) + "  ";
		}
		str += "\n";
		for (int i = 0; i < seats.length; i++) {
			str += Character.toString((char) i + 65) + " ";
			for (int j = 0; j < seats[0].length; j++) {
				str += seats[i][j].toString();
			}
			str += "\n";
		}
		return str;
	}
}
