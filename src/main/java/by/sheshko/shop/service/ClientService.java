package by.sheshko.shop.service;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.bean.UserSessionInfo;

public interface ClientService {
    void singIn(String login, String password) throws ServiceException;

    void signOut(UserSessionInfo userSessionInfo) throws ServiceException;

    void registration(String login, String password) throws ServiceException;

    User getUserInfo(String login) throws ServiceException;
}
