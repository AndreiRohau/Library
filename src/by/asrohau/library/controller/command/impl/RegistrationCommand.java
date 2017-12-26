package by.asrohau.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.asrohau.library.controller.command.Command;
import by.asrohau.library.service.ServiceFactory;
import by.asrohau.library.service.UserService;

public class RegistrationCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("We got to REGISTRATION");
		boolean isRegistered = false;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();
		isRegistered = userService.registration(login, password);
		
		String goToPage;
		if(isRegistered) {
			request.setAttribute("isRegistered", "You registered successfully");
			goToPage= "index.jsp";
		}else {
			goToPage= "error.jsp";
			request.setAttribute("errorMessage", "cant register");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}