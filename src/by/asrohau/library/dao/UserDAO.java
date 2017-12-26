package by.asrohau.library.dao;

import by.asrohau.library.bean.UserDTO;

public interface UserDAO {

	UserDTO findUser(String login, String password);
	
	boolean saveUser(String login, String password);
	
	boolean changePassword(String login, String password, String newPassword);
	
	boolean deleteUser(String login, String password);
	
	
}
