package com.example.casem3.service.impl;

import com.example.casem3.dao.IUserDAO;
import com.example.casem3.dao.iml.UserDAO;
import com.example.casem3.service.IUserService;

public class UserService implements IUserService {
    private IUserDAO userDAO = new UserDAO();

    @Override
    public boolean authenticate(String username, String password) {
        return userDAO.authenticate(username, password);
    }

    @Override
    public String getRole(String username) {
        return userDAO.getRole(username);
    }
}
