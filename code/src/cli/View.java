package cli;

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
			System.out.println("Waiting for next command.");
		} while (!command.equals("exit"));
		//exit command was entered, exit the system
		System.out.println("Goodbye.");
		reader.close();
		System.exit(0);
	}


	/*
	 * method for printing welcome message
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
}
