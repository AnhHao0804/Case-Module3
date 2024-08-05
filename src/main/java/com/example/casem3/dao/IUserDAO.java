package com.example.casem3.dao;

public interface IUserDAO {
    boolean authenticate(String username, String password);
    String getRole(String username);
}
