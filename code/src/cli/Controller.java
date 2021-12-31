package cli;

import java.util.HashMap;
import java.util.Map;

public class Controller {

	private Map<String, Command> commandList;
	private Model model = new Model();

	/*
	 * initialize commandManager with a list of commands
	 */
		
	public Controller() {
		commandList = new HashMap<>();
		//setup all default commands 
		this.commandList.put("newCustomer", new newCustomer());
		this.commandList.put("newEmployee", new newEmployee());
		this.commandList.put("newAdmin", new newAdmin());
		this.commandList.put("newTheater", new newTheater());	
		this.commandList.put("newShowtime", new newShowtime());
		this.commandList.put("deleteAccount", new deleteAccount());
		this.commandList.put("deleteTheater", new deleteTheater());
		this.commandList.put("deleteShowtime", new deleteShowtime());
		this.commandList.put("listAccounts", new listAccounts());
		this.commandList.put("listTheaters", new listTheaters());
		this.commandList.put("listShowtimes", new listShowtimes());
		this.commandList.put("viewAccount", new viewAccount());
		this.commandList.put("viewTheater", new viewTheater());
		this.commandList.put("viewShowtime", new viewShowtime());
		this.commandList.put("purchaseTicket", new purchaseTicket());
		this.commandList.put("addBalance", new addBalance());
		this.commandList.put("clearAccountData", new clearAccountData());
		this.commandList.put("clearTheaterData", new clearTheaterData());
		this.commandList.put("clearShowtimeData", new clearShowtimeData());
		this.commandList.put("updateAccountData", new updateAccountData());
		this.commandList.put("updateShowtimeData", new updateShowtimeData());
		this.commandList.put("updateTheaterData", new updateTheaterData());
		this.commandList.put("login", new login());
		this.commandList.put("logout", new logout());
		this.commandList.put("exit", new exit());
		this.commandList.put("help", new help());
	}

	public void interpret(String command) {
		command = (command).trim();
		if(!commandList.containsKey(command)){
			System.out.println("Invalid command entered! Please type \"help\" for a list of commands.");
		}else{
			//parse arguments out of command
			String[] parsedCommand = command.split(" ", 2);
			if(parsedCommand.length == 1){
				runCommand(command, model, null);
			}else{
				runCommand(command, model, parsedCommand[1].split(" ", 2));
			}
		}
	}

	private void runCommand(String command, Model model, String[] params){
		commandList.get(command).execute(model, params);
	}
}
