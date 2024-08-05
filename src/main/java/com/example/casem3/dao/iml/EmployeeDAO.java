package com.example.casem3.dao.iml;

import com.example.casem3.dao.IEmployeeDAO;
import com.example.casem3.model.Employee;
import com.example.casem3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    private final String SELECT_ALL_EMPLOYEE ="SELECT * FROM employees";
    private final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (cccd, phone_number, name, email, username) VALUES (?, ?, ?, ?, ?)";
    private final String INSERT_USER_SQL = "INSERT INTO users (username, password) VALUES (?, ?)";
    private final String INSERT_USER_ROLE_SQL = "INSERT INTO userroles (username, role_id) VALUES (?, ?)";
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String cccd = resultSet.getString("cccd");
                String phoneNumber = resultSet.getString("phone_number");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String userName = resultSet.getString("username");
                // int roleId = resultSet.getInt("role_id");
                employees.add(new Employee(cccd, phoneNumber, name, email, userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error querying the employees", e);
        }
        return employees;
    }
    @Override
    public List<Employee> getEmployeesByName(String name) {
        List<Employee> employees = new ArrayList<>();
        String searchSQL = "SELECT * FROM employees WHERE name LIKE ?";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(searchSQL)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String cccd = resultSet.getString("cccd");
                String phoneNumber = resultSet.getString("phone_number");
                String employeeName = resultSet.getString("name");
                String email = resultSet.getString("email");
                String userName = resultSet.getString("username");
                // int roleId = resultSet.getInt("role_id");
                employees.add(new Employee(cccd, phoneNumber, employeeName, email, userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error searching employees by name", e);
        }
        return employees;
    }


    @Override
    public Employee getEmployeeByCccd(String cccd) {
        String searchSQL = "SELECT * FROM employees WHERE cccd = ?";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(searchSQL)) {
            preparedStatement.setString(1, cccd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String phoneNumber = resultSet.getString("phone_number");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String userName = resultSet.getString("username");
                // int roleId = resultSet.getInt("role_id");
                return new Employee(cccd, phoneNumber, name, email, userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting employee by CCCD", e);
        }
        return null;
    }


    @Override
    public boolean addEmployee(Employee employee, String password) {
        try (Connection connection = JDBCConnection.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement insertUserStmt = connection.prepareStatement(INSERT_USER_SQL);
                 PreparedStatement insertUserRoleStmt = connection.prepareStatement(INSERT_USER_ROLE_SQL);
                 PreparedStatement insertEmployeeStmt = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {

                insertUserStmt.setString(1, employee.getUserName());
                insertUserStmt.setString(2, password);
                insertUserStmt.executeUpdate();

                insertUserRoleStmt.setString(1, employee.getUserName());
                insertUserRoleStmt.setInt(2, employee.getRoleId());
                insertUserRoleStmt.executeUpdate();

                insertEmployeeStmt.setString(1, employee.getCccd());
                insertEmployeeStmt.setString(2, employee.getPhoneNumber());
                insertEmployeeStmt.setString(3, employee.getName());
                insertEmployeeStmt.setString(4, employee.getEmail());
                insertEmployeeStmt.setString(5, employee.getUserName());
                insertEmployeeStmt.executeUpdate();

                connection.commit();
                return true;
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
                throw new RuntimeException("Error inserting employee", e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection error", e);
        }
    }



    @Override
    public boolean editEmployee(Employee employee, String password) {
        String updateEmployeeSQL = "UPDATE employees SET phone_number = ?, name = ?, email = ?, username = ? WHERE cccd = ?";
        String updateUserSQL = "UPDATE users SET password = ? WHERE username = ?";
        String updateUserRoleSQL = "UPDATE userroles SET role_id = ? WHERE username = ?";

        try (Connection connection = JDBCConnection.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement updateEmployeeStmt = connection.prepareStatement(updateEmployeeSQL);
                 PreparedStatement updateUserStmt = connection.prepareStatement(updateUserSQL);
                 PreparedStatement updateUserRoleStmt = connection.prepareStatement(updateUserRoleSQL)) {

                updateEmployeeStmt.setString(1, employee.getPhoneNumber());
                updateEmployeeStmt.setString(2, employee.getName());
                updateEmployeeStmt.setString(3, employee.getEmail());
                updateEmployeeStmt.setString(4, employee.getUserName());
                updateEmployeeStmt.setString(5, employee.getCccd());
                updateEmployeeStmt.executeUpdate();

                updateUserStmt.setString(1, password);
                updateUserStmt.setString(2, employee.getUserName());
                updateUserStmt.executeUpdate();

                updateUserRoleStmt.setInt(1, employee.getRoleId());
                updateUserRoleStmt.setString(2, employee.getUserName());
                updateUserRoleStmt.executeUpdate();

                connection.commit();
                return true;
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
                throw new RuntimeException("Error updating employee", e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection error", e);
        }
    }

    @Override
    public boolean deleteEmployee(String cccd) {
        return false;
    }
}
