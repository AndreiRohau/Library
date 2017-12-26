package by.asrohau.library.controller;

import java.util.Map;

import by.asrohau.library.controller.command.Command;
import by.asrohau.library.controller.command.impl.AddBookCommand;
import by.asrohau.library.controller.command.impl.ChangePasswordCommand;
import by.asrohau.library.controller.command.impl.DeleteUserCommand;
import by.asrohau.library.controller.command.impl.LoginationCommand;
import by.asrohau.library.controller.command.impl.RegistrationCommand;

import java.util.HashMap;

public class CommandProvider {

	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.REGISTRATION, new RegistrationCommand());
		commands.put(CommandName.LOGINATION, new LoginationCommand());
		commands.put(CommandName.CHANGE_PASSWORD, new ChangePasswordCommand());
		commands.put(CommandName.DELETE_USER, new DeleteUserCommand());
		commands.put(CommandName.ADD_BOOK, new AddBookCommand());
		
	}

	public Command getCommand(CommandName commandName) {
		return commands.get(commandName);
	}

}
