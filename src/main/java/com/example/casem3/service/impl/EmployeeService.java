package com.example.casem3.service.impl;

import com.example.casem3.dao.IEmployeeDAO;
import com.example.casem3.dao.iml.EmployeeDAO;
import com.example.casem3.model.Employee;
import com.example.casem3.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
   IEmployeeDAO employeeDAO = new EmployeeDAO();
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeByCccd(String cccd) {
        return employeeDAO.getEmployeeByCccd(cccd);
    }

    @Override
    public boolean addEmployee(Employee employee, String password) {
        return employeeDAO.addEmployee(employee, password);
    }

    @Override
    public boolean editEmployee(Employee employee, String password) {
        return employeeDAO.editEmployee(employee, password);
    }

    @Override
    public boolean deleteEmployee(String cccd) {
        return false;
    }
    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeDAO.getEmployeesByName(name);
    }
}
