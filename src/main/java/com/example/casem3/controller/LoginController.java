package com.example.casem3.controller;

import com.example.casem3.service.IUserService;
import com.example.casem3.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean isAuthenticated = userService.authenticate(username, password);
        if (isAuthenticated) {
            String role = userService.getRole(username);
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);

            if ("ROLE_ADMIN".equals(role)) {
                resp.sendRedirect("admin");
            } else {
                resp.sendRedirect("access-denied.jsp");
            }
        } else {
            req.setAttribute("errorMessage", "Invalid username or password");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
