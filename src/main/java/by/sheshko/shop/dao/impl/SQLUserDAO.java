package by.sheshko.shop.dao.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.DAOException;
import by.sheshko.shop.dao.pool.ConnectionPool;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;

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
            logger.log(Level.ERROR, "Error working with statements while sign in", e);
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
                logger.log(Level.ERROR, "Error working with statements while registering new user",e);
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
            logger.log(Level.ERROR, "Error working with statements while getting user info",e);
            throw new DAOException("Error while getting info about user", e);
        }
        return user;
    }

    private Connection connectToDataBase() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        try{
            connection = connectionPool.takeConnection();
        }
        catch (InterruptedException e) {
            logger.log(Level.ERROR,"Error while getting connection from connection pool queue",e);
            throw new DAOException("Error taking connection to database", e);
        }
        return connection;
    }
}
