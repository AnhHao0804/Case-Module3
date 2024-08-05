package com.example.casem3.dao;

import com.example.casem3.model.Employee;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployeeByCccd(String cccd);

    boolean addEmployee(Employee employee, String password);

    boolean deleteEmployee(String cccd);


    List<Employee> getEmployeesByName(String name);

    boolean editEmployee(Employee employee, String password);
}
