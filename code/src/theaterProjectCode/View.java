package theaterProjectCode;

import java.util.Scanner;

public class View {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * initialize system objects
		 */
		String[] commandList = { "login", "logout", "newAccount", "newEmployee", "newAdmin", "newTheater",
				"newShowtime", "deleteAccount", "deleteTheater", "deleteShowtime", "listAccounts", "listTheaters",
				"listShowtimes", "viewAccount", "viewTheater", "viewShowtime", "purchaseTicket", "clearAccountsData",
				"clearTheatersData", "clearShowtimesData", "updateAccountData", "updateTheatersData",
				"updateShowtimesData", "exit", "main","addBalance" };
		//init command manager
		Controller commandManager = new Controller(commandList);
		String command = "";
		printWelcomeMessage();
		/*
		 * program loop
		 */
		do {
			command = reader.nextLine();
			System.out.printf("The command you entered is: %s %n", command);
			// check for valid user input command
			if (commandManager.validateCommand(command)) {
				System.out.println("Valid Command! Running...");
				commandManager.runCommand(command);
			} else {
				System.out.println("Invalid command entered. Please try again.");
			}
		} while (!command.equals("exit"));

		System.out.println("Goodbye.");
		reader.close();
	}
	/*
	 * method for initial print
	 */
	public static void printWelcomeMessage() {
		for (int i = 0; i < 40; i++) {
			System.out.print("*");
		}
		System.out.println("\n\t\tHello \n\tWelome to TheaterOS!");
		for (int i = 0; i < 40; i++) {
			System.out.print("*");
		}
		System.out.println("If you want to login to an existing account\n Please enter \"login\" as a command");
		System.out.println("If you want to continue as a Guest\n Please enter \"guest\" as a command");
		System.out.println("For a list of all commands\n Please enter \"main\" as a command");
		System.out.println("Waiting for command input...");
	}
	/*
	 * instructions print
	 */
	public static void printInstructions() {
		System.out.println();
		System.out.println("Commands currently available:");
		String str = """
                         ________________________________________________________________
                        / newAccount     / listAccounts   / clearAccountsData  / login  /
                       / newAdmin       / listTheaters   / clearTheatersData  / logout /
                      / newEmployee    / listShowtimes  / clearShowtimesData / exit   /
                     / newTheater     / viewAccount    / updateAccountsData /        /
                    / newShowtime    / viewTheater    / updateTheatersData /        /
                   / deleteAccount  / viewShowtime   /updateShowtimesData /        /
                  / deleteTheater  / purchaseTicket /                    /        /
                 / deleteShowtime / addBalance     /                    /        /
                /________________/________________/____________________/________/          """;
		System.out.println(str);
	}
}
