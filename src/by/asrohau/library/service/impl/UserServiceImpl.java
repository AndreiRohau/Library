package by.asrohau.library.service.impl;

import by.asrohau.library.bean.UserDTO;
import by.asrohau.library.dao.DAOFactory;
import by.asrohau.library.dao.UserDAO;
import by.asrohau.library.dao.exception.DAOException;
import by.asrohau.library.service.UserService;
import by.asrohau.library.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	private final UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

	public UserServiceImpl() {

	}

	@Override
	public boolean validation(String login, String password) {
		String toCompare = "";
		if (!toCompare.equals(login) && !toCompare.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserDTO logination(String login, String password) throws ServiceException {

		// validation!!! stub
		if (validation(login, password)) {

			try {
				return userDAO.findUserWithLoginAndPassword(login, password);
			} catch (DAOException e) {
				throw new ServiceException(e);
			}

		}

		return null;
	}

	@Override
	public boolean registration(String login, String password) throws ServiceException {

		// validation!!! stub
		if (validation(login, password)) {

			try {
				if (userDAO.findUserWithLogin(login) == null) {
					return userDAO.saveUser(login, password);
				}

			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		}

		return false;
	}

	@Override
	public boolean changePassword(String login, String password, String newPassword) throws ServiceException {

		// validation!!! stub
		if (validation(login, newPassword)) {

			try {
				if (userDAO.findUserWithLoginAndPassword(login, password) != null) {
					return userDAO.changePassword(login, password, newPassword);
				}
				
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		}

		return false;
	}

	@Override
	public boolean deleteUser(String login, String password) throws ServiceException {

		// validation!!! stub
		if (validation(login, password)) {

			try {
				if (userDAO.findUserWithLoginAndPassword(login, password) != null) {
					return userDAO.deleteUser(login, password);
				}
				
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		}

		return false;
	}

}
