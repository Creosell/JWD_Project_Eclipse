package by.sheshko.shop.dao.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.bean.builder.UserBuilder;
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
    private static final String USER_ID = "id_user";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String PHONENUMBER = "phonenumber";
    private static final String REGISTRATION_TIME = "registered";
    private static final String STATUS = "user_status_id";
    private static final String ROLE = "roles_id";
    private static final Integer BLOCKED = 2;
//todo потокобезопасные транзацкии ThreadLocal


    private static final String LOGIN = "SELECT * FROM users WHERE login = ? AND password = ?;";
    private static final String ADD_NEW_USER = "INSERT INTO users (login,password) VALUES(?,?);";
    private static final String ADD_NEW_USER_INFO =
            "INSERT INTO user_details(id, users_id_user, name, surname, email, address, phonenumber)"
                    + " VALUES(LAST_INSERT_ID(), LAST_INSERT_ID(), ?, ?, ?, ?, ?);";
    private static final String GET_USER_INFO = "SELECT * FROM users WHERE login = ?";
    private static final String GET_USER_ADDITIONAL_INFO = "SELECT * FROM user_details WHERE id = ?";
    private static final String UPDATE_USER_INFO = "UPDATE users SET password = ? WHERE id_user=?;";
    private static final String UPDATE_USER_ADDITIONAL_INFO = "UPDATE user_details " +
            "SET name = ?, surname = ?, email = ?, address = ?, phonenumber = ? WHERE id=?;";
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private Connection connection;


    @Override
    public User signIn(final String login, final String password) throws DAOException {
        User user = null;
        try {
            connection = connectToDataBase();
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                log.info("Attempt to log in with incorrect data. Login :{}", login);
                throw new DAOException("Wrong login or password");
            }

            if (resultSet.getInt(STATUS) == BLOCKED) {
                log.info("Attempt to log in from blocked user. Login :{}", login);
                throw new DAOException("Sorry, you are blocked on this website.");
            }
            user = loadUserInfo(login, connection);

            resultSet.close();
            preparedStatement.close();
            connection.close();
            //todo connection.closeConnection is not used
        } catch (SQLException e) {
            log.error("Error working with statements while sign in", e);
            throw new DAOException("Error while working with database", e);
        }
        return user;
    }

    @Override
    public void registration(final String login, final String password, final User user) throws DAOException {

        try {
            connection = connectToDataBase();
            PreparedStatement preparedStatement;
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(ADD_NEW_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement(ADD_NEW_USER_INFO);
            if (user.getName() != null) {
                preparedStatement.setString(1, user.getName());
            } else {
                preparedStatement.setString(1, login);
            }
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPhonenumber());
            preparedStatement.execute();

            connection.commit();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                log.error("Fail to rollback", e);
                throw new DAOException("Rollback error while registering user", ex);
            }
            if (e.toString().contains("Duplicate") && e.toString().contains("login")) {
                log.info("Attempt to register with already existing login : {}", login);
                throw new DAOException("User with same login is already registered", e);
            }
            if (e.toString().contains("Duplicate") && e.toString().contains("email")) {
                log.info("Attempt to register with already existing email : {}", user.getEmail());
                throw new DAOException("User with same email is already registered", e);
            } else {
                log.error("Error working with statements while registering new user", e);
                throw new DAOException("Error while registering user", e);
            }
        }
    }

    @Override
    public void editUserInfo(User user, String newPassword) throws DAOException {
        try {
            connection = connectToDataBase();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement;

            if (!String.valueOf(newPassword).equals("")) {
                preparedStatement = connection.prepareStatement(UPDATE_USER_INFO);
                preparedStatement.setString(1, newPassword);
                preparedStatement.setInt(2, user.getUserID());
                preparedStatement.executeUpdate();
            }

            preparedStatement = connection.prepareStatement(UPDATE_USER_ADDITIONAL_INFO);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPhonenumber());
            preparedStatement.setInt(6, user.getUserID());
            preparedStatement.executeUpdate();

            connection.commit();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                log.error("Fail to rollback", e);
                throw new DAOException("Rollback error while edit user info", ex);
            }
            if (e.toString().contains("Duplicate") && e.toString().contains("email")) {
                log.info("Attempt to change email to already existing value: {}", user.getEmail());
                throw new DAOException("User with same email is already existing", e);
            }
            if (e.toString().contains("Duplicate") && e.toString().contains("phonenumber")) {
                log.info("Attempt to change phonenumber to already existing value: {}", user.getPhonenumber());
                throw new DAOException("User with same phonenumber is already existing", e);
            }
            log.error("Error working with statements while edit user information", e);
            throw new DAOException("Error while working with database", e);
        }
    }

    private User loadUserInfo(final String login, final Connection connection) throws DAOException {
        User user;

        try {
            PreparedStatement preparedStatement;
            ResultSet resultSet;
            ResultSet additionalResultSet;

            preparedStatement = connection.prepareStatement(GET_USER_INFO);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }

            preparedStatement = connection.prepareStatement(GET_USER_ADDITIONAL_INFO);
            preparedStatement.setString(1, String.valueOf(resultSet.getInt(USER_ID)));
            additionalResultSet = preparedStatement.executeQuery();
            additionalResultSet.next();

            user = new UserBuilder()
                    .userID(resultSet.getInt(USER_ID))
                    .status(resultSet.getString(STATUS))
                    .role(resultSet.getString(ROLE))
                    .name(additionalResultSet.getString(NAME))
                    .surname(additionalResultSet.getString(SURNAME))
                    .email(additionalResultSet.getString(EMAIL))
                    .address(additionalResultSet.getString(ADDRESS))
                    .phonenumber(additionalResultSet.getString(PHONENUMBER))
                    .registrationTime(additionalResultSet.getTimestamp(REGISTRATION_TIME))
                    .build();

            resultSet.close();
            additionalResultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            log.error("Error working with statements while getting user info", e);
            throw new DAOException("Error while getting info about user", e);
        }
        return user;
    }

    private Connection connectToDataBase() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connection = connectionPool.takeConnection();
        } catch (InterruptedException e) {
            log.error("Error while getting connection from connection pool queue", e);
            throw new DAOException("Error taking connection to database", e);
        }
        return connection;
    }
}
