package com.example.casem3.dao;

import com.example.casem3.model.User;

import java.util.List;

public interface IUserDAO {
    boolean authenticate(String username, String password);
    String getRole(String username);
    List<User> getAllUsers();
    void addUser(String userName, String password, String roleName);
}
