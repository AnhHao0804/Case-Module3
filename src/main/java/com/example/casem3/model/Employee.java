package com.example.casem3.model;

public class Employee {
    private String cccd;
    private String phoneNumber;
    private String name;
    private String email;
    private String userName;
    private int roleId;
    private String password;

    public Employee() {
    }

    public Employee(String cccd, String phoneNumber, String name, String email, String userName, int roleId) {
        this.cccd = cccd;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.roleId = roleId;
    }

    public Employee(String cccd, String phoneNumber, String name, String email, String userName) {
        this.cccd = cccd;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.userName = userName;
    }
    public Employee(String cccd, String phoneNumber, String name, String email, String username, int roleId, String password) {
        this.cccd = cccd;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.userName = username;
        this.roleId = roleId;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
