package by.sheshko.shop.service;

import by.sheshko.shop.bean.User;

public interface ClientService {
    User singIn(String login, String password) throws ServiceException;

    void registration(String login, String password, User user) throws ServiceException;

    void editUserInfo(User user, String newPassword) throws ServiceException;
}
