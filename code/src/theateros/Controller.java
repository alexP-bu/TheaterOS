package theateros;

import java.util.Arrays;
import java.util.HashSet;

public class Controller {

	private HashSet<String> commandList;

	/*
	 * initialize commandManager with a list of commands
	 */
	public Controller(String[] commands) {
		this.commandList = new HashSet<String>(Arrays.asList(commands));
	}
	public boolean validateCommand(String command) {
		return commandList.contains(command);
	}
	//run command
	public void run(Model model, String command) {
		switch(command){
			case ""

		}
	}
}
