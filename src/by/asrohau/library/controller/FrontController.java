package by.asrohau.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.asrohau.library.controller.command.Command;
import by.asrohau.library.controller.exception.ControllerException;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final CommandProvider commandProvider = new CommandProvider();

	public FrontController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in servlet : command : " + request.getParameter("command").toUpperCase());

		CommandName commandName = CommandName.valueOf(request.getParameter("command").toUpperCase());
		Command command = commandProvider.getCommand(commandName);
		try {
			HttpSession session = request.getSession(true);
			session.getId();
			command.execute(request, response);
		} catch (ControllerException e) {

			request.setAttribute("errorMessage", e.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}

	}

}
