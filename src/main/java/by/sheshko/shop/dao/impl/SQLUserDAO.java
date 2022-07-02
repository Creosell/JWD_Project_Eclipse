package by.sheshko.shop.dao.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.dao.DAOException;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.pool.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public final class SQLUserDAO implements UserDAO {
    private static final String LOGIN = "SELECT * FROM users WHERE login = ? AND password = ?;";
    private static final String REGISTER_NEW_USER = "INSERT INTO users(login, password) VALUES(?, ?);";
    private static final String GET_USER_INFO = "SELECT * FROM users WHERE login = ?";
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public void signIn(final String login, final String password) throws DAOException {
        try (Connection connection = connectToDataBase()) {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                log.info("Attempt to log in with incorrect data. Login :{}", login);
                throw new DAOException("Wrong login or password");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            log.error("Error working with statements while sign in", e);
            throw new DAOException("Error while working with database", e);
        }
    }

    @Override
    public void registration(final String login, final String password) throws DAOException {
        try (Connection connection = connectToDataBase()) {
            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement(REGISTER_NEW_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            if (e.toString().contains("Duplicate")) {
                log.info("Attempt to register with already existing login : {}", login);
                throw new DAOException("User with same login is already registered", e);
            } else {
                log.error("Error working with statements while registering new user", e);
                throw new DAOException("Error while registering user", e);
            }
        }

    }

    @Override
    public User getUserInfo(final String login) throws DAOException {
        User user;
        try (Connection connection = connectToDataBase()) {
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            //TODO Сделать корректную выгрузку с базы
            preparedStatement = connection.prepareStatement(GET_USER_INFO);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }
            user = new User();

            user.setUserID(resultSet.getInt(1));
            user.setRole(resultSet.getInt(4));

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            log.error("Error working with statements while getting user info", e);
            throw new DAOException("Error while getting info about user", e);
        }
        return user;
    }

    private Connection connectToDataBase() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
        } catch (InterruptedException e) {
            log.error("Error while getting connection from connection pool queue", e);
            throw new DAOException("Error taking connection to database", e);
        }
        return connection;
    }
}
