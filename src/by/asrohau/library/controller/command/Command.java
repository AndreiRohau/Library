package by.asrohau.library.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.asrohau.library.controller.exception.ControllerException;

public interface Command {

	void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException;
	
}
