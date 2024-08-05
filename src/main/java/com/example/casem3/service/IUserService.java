package com.example.casem3.service;

public interface IUserService {
    boolean authenticate(String username, String password);
    String getRole(String username);
}
