package com.example.casem3.controller;

import com.example.casem3.model.User;
import com.example.casem3.service.IUserService;
import com.example.casem3.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", value = "/users")
public class UserController extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/user/add.jsp");
                rd.forward(req, resp);
                break;
            default:
                listUsers(req, resp);
        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String roleName = req.getParameter("roleName");

        try {
            userService.addUser(userName, password, roleName);
            resp.sendRedirect("users?action=list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listUsers(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users = userService.getAllUsers();
        try {
            req.setAttribute("listUsers", users);
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/user/list.jsp");
            rd.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                addUser(req, resp);
                break;
        }
    }
}
