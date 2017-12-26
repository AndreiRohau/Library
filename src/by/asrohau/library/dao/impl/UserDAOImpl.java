package by.asrohau.library.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.asrohau.library.bean.User;
import by.asrohau.library.bean.UserDTO;
import by.asrohau.library.dao.AbstractDAO;
import by.asrohau.library.dao.UserDAO;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO{
	
	private String FIND_USER_BY_LOGIN_PASSWORD_QUERY = "SELECT * FROM library.users WHERE login = ? AND password = ?";
    private String SAVE_USER_QUERY = "INSERT INTO library.users (login, password) VALUES (?,?)";
    private String CHANGE_PASSWORD_QUERY = "UPDATE library.users SET password = ? WHERE login = ? AND password = ?";
    private String DELETE_USER_QUERY = "DELETE FROM library.users WHERE login = ? AND password = ?";

	@Override
	public UserDTO findUser(String login, String password) {
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_USER_BY_LOGIN_PASSWORD_QUERY)) {
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            UserDTO userDTO = new UserDTO();

            while (resultSet.next()) {
                userDTO.setLogin(resultSet.getString(2));
            }
            preparedStatement.close();
            connection.close();
            
            if(userDTO.getLogin() != null) {
            	return userDTO;
            }
            System.out.println("Did not find User with login = " + login);
            return null;
        } catch (SQLException e) {
            System.out.println("SQL Exception");
            return null;
        }

	}

	@Override
	public boolean saveUser(String login, String password) {
		try (PreparedStatement statement = getConnection().prepareStatement(SAVE_USER_QUERY)) {
            statement.setString(1, login);
            statement.setString(2, password);

            statement.executeUpdate();
            statement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
        	System.out.println("Can't create user with login: " + login);
            return false;
        }
	}

	@Override
	public boolean changePassword(String login, String password, String newPassword) {
		try (PreparedStatement statement = getConnection().prepareStatement(CHANGE_PASSWORD_QUERY)) {
			statement.setString(1, newPassword);
            statement.setString(2, login);
            statement.setString(3, password);

            statement.executeUpdate();
            statement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
        	System.out.println("Can't change password ");
            return false;
        }
	}

	@Override
	public boolean deleteUser(String login, String password) {
		try (PreparedStatement statement = getConnection().prepareStatement(DELETE_USER_QUERY)) {
            statement.setString(1, login);
            statement.setString(2, password);

            statement.executeUpdate();
            statement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
        	System.out.println("Can't delete user ");
            return false;
        }
	}

}
