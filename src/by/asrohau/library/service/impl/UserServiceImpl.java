package by.asrohau.library.service.impl;

import by.asrohau.library.bean.UserDTO;
import by.asrohau.library.dao.DAOFactory;
import by.asrohau.library.dao.UserDAO;
import by.asrohau.library.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

	public UserServiceImpl() {
	}

	@Override
	public boolean validation(String login, String password) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public UserDTO logination(String login, String password) {

		// validation!!! stub

		UserDTO userDTO = userDAO.findUser(login, password);

		return userDTO;
	}

	@Override
	public boolean registration(String login, String password) {

		// validation!!! stub
		
		boolean result = false;
		if (userDAO.findUser(login, password) == null) {
			result = userDAO.saveUser(login, password);
		}
		return result;
	}

	@Override
	public boolean changePassword(String login, String password, String newPassword) {
		
		// validation!!! stub
		
		boolean result = false;
		if (userDAO.findUser(login, password) != null) {
			result = userDAO.changePassword(login, password, newPassword);
		}
		return result;
	}

	@Override
	public boolean deleteUser(String login, String password) {

		// validation!!! stub
		
		boolean result = false;
		if (userDAO.findUser(login, password) != null) {
			result = userDAO.deleteUser(login, password);
		}
		return result;
	}

}
