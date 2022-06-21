package by.sheshko.shop.dao.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.exception.DAOException;
import by.sheshko.shop.dao.pool.ConnectionPool;
import by.sheshko.shop.dao.pool.exception.ConnectionPoolException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class SQLUserDAO implements UserDAO {
    private static final String LOGIN = "SELECT * FROM users WHERE login = ? AND password = ?;";
    private static final String REGISTER_NEW_USER = "INSERT INTO users(login, password) VALUES(?, ?);";
    private static final String GET_USER_INFO = "SELECT * FROM users WHERE login = ?";
    Logger logger = LogManager.getLogger(SQLUserDAO.class);


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
        } catch (SQLException e) {
            throw new DAOException("Error while working with database", e);
        }
    }

    @Override
    public void registration(String login, String password) throws DAOException {
        try (Connection connection = connectToDataBase()) {
            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement(REGISTER_NEW_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.execute();

        } catch (SQLException e) {
            if (e.toString().contains("Duplicate")) {
                throw new DAOException("User with same name is already registered", e);
            } else {
                throw new DAOException("Error while registering user", e);
            }
        }
    }

    @Override
    public User getUserInfo(String login) throws DAOException {
        User user;
        try (Connection connection = connectToDataBase()) {
            PreparedStatement preparedStatement;
            ResultSet resultSet;


            preparedStatement = connection.prepareStatement(GET_USER_INFO);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }
            user = new User();

            user.setUserID(resultSet.getInt(1));
            user.setLogin(resultSet.getString(2));
            user.setRole(resultSet.getInt(4));

        } catch (SQLException e) {
            throw new DAOException("Error while getting info about user", e);
        }
        return user;
    }

    private Connection connectToDataBase() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        try{
            connection = connectionPool.takeConnection();
        } catch (ConnectionPoolException e) {
           logger.log(Level.ERROR, "Error getting connection from pool",e);
            throw new DAOException("Error getting connection to database");
        }
        return connection;
        /*} catch (ClassNotFoundException e) {
            throw new DAOException("Driver for database didn't find", e);
        } catch (SQLException e) {
            throw new DAOException("Error while trying authorizing to database", e);
        } catch (FileNotFoundException e) {
            throw new DAOException("Can't create stream for reading configuration file for database", e);
        } catch (IOException e) {
            throw new DAOException("Error while reading from database configuration file", e);
        } catch (NullPointerException e) {
            throw new DAOException("Can't find configuration file for database", e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }*/
    }
}
