package by.asrohau.library.service;

import by.asrohau.library.bean.UserDTO;

public interface UserService {
	
	boolean validation(String login, String password);
	UserDTO logination(String login, String password);
	boolean registration(String login, String password);
	boolean changePassword(String login, String password, String newPassword);
	boolean deleteUser(String login, String password);

}
