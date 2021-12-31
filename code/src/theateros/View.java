package theateros;

import java.util.Scanner;

public class View {
	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * initialize system objects
		 */
		Controller controller = new Controller();
		Model model = new Model();
		String command = "";
		printWelcomeMessage();
		/*
		 * program loop
		 */
		do {
			command = reader.nextLine();
			System.out.printf("The command you entered is: %s %n", command);
			// check for valid user input command
			if (controller.validateCommand(command)) {
				System.out.println("Valid Command! Running...");
				//run command
				controller.runCommand(command, model, params);
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
		System.out.println("\n");
		System.out.println("If you want to login to an existing account\n Please enter \"login\" as a command\n");
		System.out.println("If you want to continue as a Guest\n Please enter \"guest\" as a command\n");
		System.out.println("For a list of all commands\n Please enter \"main\" as a command\n");
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

	//method to get valid username and password from user
	private String[] getUserAccountInput(){
		String [] input = {"",""};
		while(input[0].equals("") || input[1].equals("")){
			System.out.println("Please enter a username: ");
			input[0] = reader.nextLine();
			System.out.println("Please enter a password: ");
			input[1] = reader.nextLine();
		}	
			return input;
	}
}
