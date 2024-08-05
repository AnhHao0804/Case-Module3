package com.example.casem3.dao.iml;

import com.example.casem3.dao.IUserDAO;
import com.example.casem3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO {
    private static final String AUTHENTICATE_SQL = "SELECT * FROM users WHERE username = ? AND password = ?";
    private static final String GET_ROLE_SQL = "SELECT r.role_name FROM userroles ur JOIN roles r ON ur.role_id = r.role_id WHERE ur.username = ?";
    @Override
    public boolean authenticate(String username, String password) {
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(AUTHENTICATE_SQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getRole(String username) {
        String roleName = null;
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_SQL)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                roleName = resultSet.getString("role_name");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roleName;
    }
}
