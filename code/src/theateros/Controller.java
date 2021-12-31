package theateros;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {

	private Map<String, Command> commandList;

	/*
	 * initialize commandManager with a list of commands
	 */
		
	public Controller() {
		commandList = new HashMap<>();
		//setup all commands 
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
	}

	public boolean validateCommand(String command) {
		return commandList.containsKey(command);
	}

	public void runCommand(String command, Model model, String[] params){
		commandList.get(command).execute(model, params);
	}
}
