package by.asrohau.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.asrohau.library.bean.UserDTO;
import by.asrohau.library.controller.command.Command;
import by.asrohau.library.service.ServiceFactory;
import by.asrohau.library.service.UserService;

public class LoginationCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("We got to logination");
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();
		
		UserDTO userDTO = null;
		
		userDTO = userService.logination(login, password);
		
		String goToPage;
		if(userDTO != null) {
			request.setAttribute("myuser", userDTO);
			goToPage= "/WEB-INF/jsp/main.jsp";
		}else {
			goToPage= "error.jsp";
			request.setAttribute("errorMessage", "no such user");
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
