package theaterProjectCode;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowtimeManager {
	private ArrayList<Showtime> showtimes;
	private TheaterManager theaterManager;
	private File showtimes_data = new File("showtimes.ser");
	/*
	 * constructors
	 */
	public ShowtimeManager(TheaterManager theaterManager) {
		this.showtimes = new ArrayList<Showtime>();
		this.theaterManager = theaterManager;
		try {
			if (!showtimes_data.exists()) {
				showtimes_data.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// import database file
		this.importShowtimes(showtimes_data);
	}
	/*
	 * list show times
	 */
	public void listShowtimes() {
		if((showtimes == null) || (showtimes.isEmpty())) {
			System.out.println("There are no showtimes available!");
		}else {
			System.out.println("Listing showtimes:");
			int i = 1;
			for(Showtime showtime : showtimes) {
				System.out.printf("%d: %s \n",i,showtime.toString());
				i++;
			}
			System.out.println("Finished listing showtimes.");
		}
	}
	/*
	 * add show time to local system
	 * returns true on successful add, false otherwise
	 */
	public boolean addShowtime(Showtime show) {
		if(show != null) {
			showtimes.add(show);
		}
		return false;
	}
	/*
	 * get showtime
	 */
	public Showtime getShowtime(int ID) {
		return showtimes.get(ID);
	}
	/*
	 * create new showtime. returns true on success, false on failure
	 */
	public void createShowtime() {
		ArrayList<Theater> showtimeTheaters = new ArrayList<Theater>();
		System.out.println("Enter showtime data:");
		System.out.println("Name: ");
		String name = reader.nextLine();
		System.out.println("Enter rating of showtime, 1 to 5");
		int rating = getNumInput();
		System.out.println("Enter popularity of show, from 1 to 100");
		int popularity = getNumInput();
		System.out.println("Enter category of show, in one word (use dashes for Sci-Fi etc)");
		String category = reader.nextLine();
		System.out.println("Enter price per ticket");
		double price = getPrice();
		System.out.println("Would you like to add which theaters the showtime will be in?");
		String yesno = getYesNo();
		if(yesno.equals("yes")) {
			if(theaterManager.getTheaters() == null || theaterManager.getTheaters().isEmpty()) {
				System.out.println("There are no registered theaters in the system. Please create a theater to add it.");
			}else {
				do {
				System.out.println("Add from these theaters:");
				theaterManager.listTheaters();
				System.out.println("Enter theater ID, or type \"exit\" to stop adding.");
				String ID = reader.nextLine();
				if(ID.equals("exit")) {
					break;
				}else {
					ID = theaterManager.getValidTheater(ID);
					showtimeTheaters.add(theaterManager.getTheaters().get(ID));
				}
				} while(true);
			}
		}
		showtimes.add(new Showtime(new Date().createDate(),name, showtimeTheaters, popularity, category, price, rating));
		exportShowtimes(showtimes_data);
		System.out.println("Showtime successfully added!");
	}
	/*
	 * delete showtime
	 */
	public boolean deleteShowtime() {
		if(showtimes.isEmpty() || showtimes == null) {
			System.out.println("There are no showtimes to delete!");
			return false;
		}
		System.out.println("Select showtime from following list to delete: ");
		listShowtimes();
		int showtimeSelected = this.getValidShowtimeID();
		showtimes.remove(showtimeSelected);
		System.out.println("Showtime deleted successfully.");
		exportShowtimes(showtimes_data);
		return true;
	}
	/*
	 * view show time data
	 */
	public void viewShowtime() {
		if(showtimes.isEmpty() || showtimes == null) {
			System.out.println("There are no showtimes available!");
		}else {
			int selected = this.getValidShowtimeID(); 
			System.out.println(showtimes.get(selected).toString());
		}
	}

	/*
	 * database methods for showtimes
	 */
	public void importShowtimes(File file) {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				try {
					Showtime retreived = (Showtime) objIn.readObject();
					if(retreived != null) {
						showtimes.add(retreived);
					}else {
						break;
					}
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
		System.out.println("Imported showtimes database file.");
	}

	/*
	 * export accounts from account list in current session to file
	 */
	public void exportShowtimes(File file) {
		clearShowtimesDatabaseFile();
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
			try {
				for (Showtime showtime : showtimes) {
					objOut.writeObject(showtime);
				}
			} catch (Exception e) {
				objOut.close();
				System.out.println("Error exporting showtimes.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Database file updated.");
	}

	/*
	 * clear local theaters
	 */
	public void clearLocalShowtimes() {
		showtimes.clear();
		System.out.println("Finished clearing local showtimes data.");
	}

	/*
	 * clear database file
	 */
	public void clearShowtimesDatabaseFile() {
		try {
			FileOutputStream clear = new FileOutputStream(showtimes_data);
			clear.close();
			System.out.println("Showtimes database file cleared!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
