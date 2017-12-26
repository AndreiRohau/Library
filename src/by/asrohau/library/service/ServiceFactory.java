package by.asrohau.library.service;

import by.asrohau.library.service.impl.BookServiceImpl;
import by.asrohau.library.service.impl.UserServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory INSTANCE = new ServiceFactory();

	private final UserService userService = new UserServiceImpl();
	private final BookService bookService = new BookServiceImpl();
	
	private ServiceFactory() {}

	public static ServiceFactory getInstance() {
		return INSTANCE;
	}

	public UserService getUserService() {
		return userService;
	}

	public BookService getBookService() {
		return bookService;
	}
	
}
