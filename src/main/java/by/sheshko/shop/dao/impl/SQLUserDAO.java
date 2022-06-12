package by.sheshko.shop.dao.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.exception.DAOException;
import by.sheshko.shop.dao.exception.DAOUserAuthorizationException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

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
                throw new DAOUserAuthorizationException();
            }
        } catch (DAOUserAuthorizationException e) {
            throw new DAOException("Wrong login or password", e);
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
                throw new DAOException("User with same name is already registered", e);
            } else {
                throw new DAOException(e.getMessage());
            }
        }
    }

    private Connection connectToDataBase() throws DAOException {
        Connection connection;
        Properties properties = new Properties();


        try {
            FileInputStream in = new FileInputStream(
                    Objects.requireNonNull(this.getClass().getResource("/db.properties")).getPath());
            properties.load(in);
            in.close();

            String driverClassname = properties.getProperty("jdbc.driver");
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");

            Class.forName(driverClassname);
            connection = DriverManager.getConnection(url, username, password);
            /*connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/mydb?useSSL=false",
                    "root", "admin");*/
        } catch (ClassNotFoundException e) {
            throw new DAOException("Driver for database didn't find", e);
        } catch (SQLException e) {
            throw new DAOException("Error while trying authorizing to database", e);
        } catch (FileNotFoundException e) {
            throw new DAOException("Can't create stream for reading configuration file for database", e);
        } catch (IOException e) {
            throw new DAOException("Error while reading from database configuration file", e);
        } catch (NullPointerException e) {
            throw new DAOException("Can't find configuration file for database", e);
        }

        return connection;
    }
}
