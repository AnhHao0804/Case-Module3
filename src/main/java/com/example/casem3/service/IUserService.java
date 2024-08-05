package com.example.casem3.service;

import com.example.casem3.model.User;

import java.util.List;

public interface IUserService {
    boolean authenticate(String username, String password);
    String getRole(String username);
    List<User> getAllUsers();
    void addUser(String userName, String password, String roleName);
}
