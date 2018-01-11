package by.asrohau.library.dao;

import by.asrohau.library.bean.UserDTO;
import by.asrohau.library.dao.exception.DAOException;

public interface UserDAO {
	
	UserDTO findUserWithLoginAndPassword(String login, String password) throws DAOException;
	
	UserDTO findUserWithLogin(String login) throws DAOException;
	
	boolean saveUser(String login, String password) throws DAOException;
	
	boolean changePassword(String login, String password, String newPassword) throws DAOException;
	
	boolean deleteUser(String login, String password) throws DAOException;
	
	
}
