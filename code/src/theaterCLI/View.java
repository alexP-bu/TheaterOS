package theaterCLI;

import java.util.Scanner;

public class View {
	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * initialize system objects
		 */
		Controller controller = new Controller();
		String command = "";
		/*
		* program loop
		*/
		printWelcomeMessage();
		do {
			command = reader.nextLine();
			System.out.printf("The command you entered is: %s %n", command);
			controller.interpret(command);
			System.out.println("Command interpreted. Waiting for next command.");
		} while (!command.equals("exit"));
		//exit command was entered, exit the system
		System.out.println("Goodbye.");
		reader.close();
		System.exit(0);
	}


	/*
	 * method for initial print
	 */
	public static void printWelcomeMessage() {
		for (int i = 0; i < 40; i++) {
			System.out.print("*");
		}
		System.out.println("\n\t\tHello \n\tWelome to TheaterCLI!");
		for (int i = 0; i < 40; i++) {
			System.out.print("*");
		}
		System.out.println("\n");
		System.out.println("Logged in as Guest.");
		System.out.println("To login to an existing account,please enter \"login\".");
		System.out.println("For a list of all commands, please enter \"help\".");
		System.out.println("Waiting for command input...\n");
	}
	/*
	 * instructions print
	 */
	public static void printInstructions() {
		System.out.println();
		System.out.println("Commands currently available:");
		String str = """
                         ________________________________________________________________
                        / newCustomer    / listAccounts   / clearAccountsData  / login  /
                       / newAdmin       / listTheaters   / clearTheatersData  / logout /
                      / newEmployee    / listShowtimes  / clearShowtimesData / exit   /
                     / newTheater     / viewAccount    / updateAccountsData / help   /
                    / newShowtime    / viewTheater    / updateTheatersData /        /
                   / deleteAccount  / viewShowtime   /updateShowtimesData /        /
                  / deleteTheater  / purchaseTicket /                    /        /
                 / deleteShowtime / addBalance     /                    /        /
                /________________/________________/____________________/________/          """;
		System.out.println(str);
	}
}
