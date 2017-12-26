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

public class ChangePasswordCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("We got to changePassword");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		boolean isChanged = false;

		isChanged = userService.changePassword(login, password, newPassword);

		UserDTO userDTO = new UserDTO();
		userDTO.setLogin(login);
		
		String goToPage;
		if (isChanged) {
			request.setAttribute("myuser", userDTO);
			request.setAttribute("isChanged", "new password is: " + newPassword);
			goToPage = "/WEB-INF/jsp/main.jsp";
		} else {
			goToPage = "error.jsp";
			request.setAttribute("errorMessage", "cannot change password");
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
