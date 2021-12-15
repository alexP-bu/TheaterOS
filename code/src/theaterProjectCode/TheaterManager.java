package theaterProjectCode;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheaterManager{
	private Map<String, Theater> theaters;
	private Scanner reader = new Scanner(System.in);
	private File theatersData = new File("theaters.ser");

	/*
	 * constructors
	 */
	public TheaterManager() {
		this.setTheaters(new HashMap<String, Theater>());
		try{
			if(theatersData.createNewFile()){
				System.out.println("Created new file");
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		// import database file
		try {
			this.importTheaters(theatersData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * getters/setters
	 */
	public Map<String, Theater> getTheaters() {
		return theaters;
	}

	public void setTheaters(Map<String, Theater> theaters) {
		this.theaters = theaters;
	}

	/*
	 * misc methods
	 */
	/*
	 * list theaters in local system
	 */
	public void listTheaters() {
		if ((theaters == null) || (theaters.isEmpty())) {
			System.out.println("There are no theaters registered in the system.");
		} else {
			System.out.println("Listing theaters by ID: ");
			for (String ID : theaters.keySet()) {
				System.out.println(ID);
			}
		}
	}

	/*
	 * add theater to local system
	 */
	public void addTheater(Theater theater) {
		String ID = theater.getTheaterID();
		this.theaters.put(ID, theater);
		System.out.println("Theater successfully added to local system!");
	}

	/*
	 * delete theater from local system
	 */
	public boolean deleteTheater(Theater theater) {
		if (theaters.containsKey(theater.getTheaterID())) {
			this.theaters.remove(theater.getTheaterID());
			System.out.println("Successfully deleted theater from system.");
			// update database
			exportTheaters(theatersData);
			return true;
		} else {
			System.out.println("Error deleting theater, theater not found!");
			return false;
		}
	}

	/*
	 * delete theater by ID if successful, returns true. false otherwise
	 */
	public boolean deleteTheater() {
		if (theaters.isEmpty()) {
			return false;
		}
		System.out.println("Enter ID of theater to delete:");
		String ID = reader.nextLine();
		ID = getValidTheater(ID);
		this.theaters.remove(ID);
		System.out.println("Successfully deleted theater from system.");
		// update database
		exportTheaters(theatersData);
		return true;
	}

	/*
	 * create custom theater and add it to the show time manager
	 */
	public void createTheater() {
		Theater theater = new Theater();
		System.out.println("Enter theater ID:");
		String ID = reader.nextLine();
		while (theaters.containsKey(theater.getTheaterID()) || (ID == null) || (ID.isBlank())) {
			System.out.println("Please enter a different number or ID.");
			ID = reader.nextLine();
		}
		theater.setTheaterID(ID);
		System.out.printf("Use the default seating chart for theater %s? %n", theater.getTheaterID());
		System.out.println("yes/no");
		if (reader.nextLine().equals("yes")) {
			theater.setSeatingChart(new SeatingChart());
		} else {
			System.out.println("Enter number of seating chart rows: ");
			int rows = getNumInput();
			System.out.println("Enter number of seating chart columns: ");
			int cols = getNumInput();
			theater.setSeatingChart(new SeatingChart(rows, cols));
			System.out.println("Successfully added seating chart configuration.");
		}
		this.addTheater(theater);
		// update database
		exportTheaters(theatersData);
		System.out.println("Successfully added theater configuration to system.");
	}

	/*
	 * view theater information
	 */
	public void viewTheater() {
		if (this.theaters.isEmpty()) {
			System.out.println("No theaters in local system, please add a theater");
		} else {
			System.out.println("Please enter theater ID:");
			String ID = reader.nextLine();
			ID = this.getValidTheater(ID);
			System.out.println(this.theaters.get(ID).toString());
		}
	}

	/*
	 * view theater using ID
	 */
	public void viewTheater(String id) {
		if (this.theaters.isEmpty()) {
			System.out.println("No theaters in local system, please add a theater");
		} else {
			System.out.println("Please enter theater ID:");
			id = reader.nextLine();
			id = this.getValidTheater(id);
			System.out.println(this.theaters.get(id).toString());
		}
	}/*
		 * test if theater ID is valid. Keep going until user returns valid ID.
		 */

	public String getValidTheater(String id) {
		while (!theaters.containsKey(id)) {
			System.out.println("Please enter a valid theater ID. Available Theaters:");
			this.listTheaters();
			id = reader.next();
		}
		System.out.println("valid theater ID entered...");
		return id;
	}

	/*
	 * reserve seat in theater given valid theater ID, column, and row - returns
	 * true on success false on failure.
	 */
	public boolean reserveSeat(String id, char row, int column) {
		if (this.theaters.get(id).getSeatingChart().reserveSeat(row, column)) {
			return true;
		}
		return false;
	}

	/*
	 * reserve seat with all inputs with account
	 */
	public boolean reserveSeat(char row, int col, String id, Account account) {
		if (theaters.get(id).getSeatingChart().reserveSeat(row, col, account)) {
			return true;
		}
		return false;
	}

	/*
	 * reserve seat as guest
	 */
	public boolean reserveSeat(char row, int col, String ID) {
		if (theaters.get(ID).getSeatingChart().reserveSeat(row, col)) {
			return true;
		}
		return false;
	}

	/*
	 * get valid number input from user
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
		} while (true);

		return input;
	}

	/*
	 * export theater database file
	 */
	public void importTheaters(File file) {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				try {
					Theater retreived = (Theater) objIn.readObject();
					theaters.put(retreived.getTheaterID(), retreived);
				} catch (EOFException e) {
					objIn.close();
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("Finished reading file.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Imported theaters database file.");
	}

	/*
	 * export accounts from account list in current session to file
	 */
	public void exportTheaters(File file) {
		clearTheatersDatabaseFile();
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
			try {
				for (Map.Entry<String, Theater> entry : theaters.entrySet()) {
					if(entry == null) {
						System.out.println("No theaters!");
					}else {
						objOut.writeObject(entry.getValue());
					}
				}
			} catch (Exception e) {
				objOut.close();
				System.out.println("Error exporting theaters.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Database file updated.");
	}

	/*
	 * clear local theaters
	 */
	public void clearLocalTheaters() {
		theaters.clear();
		System.out.println("Finished clearing local theater data.");
	}

	/*
	 * clear database file
	 */
	public void clearTheatersDatabaseFile() {
		try {
			FileOutputStream clear = new FileOutputStream(theatersData);
			clear.close();
			System.out.println("Theaters database file cleared!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public File getFile() {
		return theatersData;
	}
	/*
	 * test harness
	 */
	public static void main(String[] args) {
		TheaterManager theaterManager = new TheaterManager();
		Theater theater = new Theater();
		theater.setTheaterID("3");
		theater.setSeatingChart(new SeatingChart(3, 4));
		System.out.println(theater.toString());
		theaterManager.theaters.put(theater.getTheaterID(), theater);
		System.out.println(theaterManager.getTheaters().toString());
		System.out.println(theaterManager.theaters.get(theater.getTheaterID()));
		theaterManager.viewTheater();
	}
}
