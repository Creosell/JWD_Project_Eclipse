package by.sheshko.mywebproject.dao.impl;

import by.sheshko.mywebproject.bean.User;
import by.sheshko.mywebproject.dao.UserDAO;
import by.sheshko.mywebproject.dao.exception.DAOException;

import java.sql.*;

public class SQLUserDAO implements UserDAO {
    private static final String LOGIN = "SELECT * FROM users WHERE login = ? AND password = ?;";
    private static final String REGISTER_NEW_USER = "INSERT INTO users(login, password, roles_id) VALUES(?, ?, ?);";

    @Override
    public void signIn(String login, String password) throws DAOException {

        try (Connection connection = connectToDataBase()) {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                throw new DAOException("Wrong login or password");
            }
        } catch (DAOException e) {
            throw new DAOException(e.getMessage());
        } catch (SQLException e) {
            throw new DAOException("Error while working with database", e);
        }
    }

    @Override
    public void registration(User user) throws DAOException {
        try (Connection connection = connectToDataBase()) {
            PreparedStatement preparedStatement = null;
            int userRoleID = 2;

            preparedStatement = connection.prepareStatement(REGISTER_NEW_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, userRoleID);
            preparedStatement.execute();

        } catch (SQLException e) {
            if (e.toString().contains("Duplicate")) {
                throw new DAOException("User with same name is already registered");
            } else {
                throw new DAOException(e.getMessage());
            }
        }
    }

    private Connection connectToDataBase() throws DAOException {
        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/mydb?useSSL=false",
                    "root", "admin");
        } catch (ClassNotFoundException e) {
            throw new DAOException("Driver for database didn't find" + e);
        } catch (SQLException e) {
            throw new DAOException("Error while trying authorizing to database", e);
        }

        return connection;
    }
}
