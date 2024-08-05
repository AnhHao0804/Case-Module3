package com.example.casem3.service;

import com.example.casem3.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeByCccd(String cccd);
    List<Employee> getEmployeesByName(String name); // Thêm phương thức này
    boolean addEmployee(Employee employee, String password);
    boolean editEmployee(Employee employee, String password); // Thêm tham số password
    boolean deleteEmployee(String cccd);
}
