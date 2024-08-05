package com.example.casem3.controller;

import com.example.casem3.model.Employee;
import com.example.casem3.service.IEmployeeService;
import com.example.casem3.service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name="EmployeeController", value = "/employees")
public class EmployeeController extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");

        if (role == null || (!"ROLE_ADMIN".equals(role))) {
            resp.sendRedirect("access-denied.jsp");
            return;
        }

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteEmployee(req, resp);
                break;
            case "search":
                searchEmployee(req, resp);
                break;
            default:
                listEmployee(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");

        if (role == null || (!"ROLE_ADMIN".equals(role))) {
            resp.sendRedirect("access-denied.jsp");
            return;
        }

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createEmployee(req, resp);
                break;
            case "edit":
                editEmployee(req, resp);
                break;
            case "delete":
                deleteEmployee(req, resp);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/employees/create.jsp");
        dispatcher.forward(req, resp);
    }

    private void createEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cccd = req.getParameter("cccd");
        String phoneNumber = req.getParameter("phoneNumber");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String userName = req.getParameter("userName");
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        String password = req.getParameter("password");

        Employee newEmployee = new Employee(cccd, phoneNumber, name, email, userName, roleId);
        boolean isAdded = employeeService.addEmployee(newEmployee, password);
        if (isAdded) {
            resp.sendRedirect("/employees");
        } else {
            req.setAttribute("errorMessage", "Error adding new employee");
            showCreateForm(req, resp);
        }
    }
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cccd = req.getParameter("cccd");
        Employee employee = employeeService.getEmployeeByCccd(cccd);
        req.setAttribute("employee", employee);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/employees/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void editEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cccd = req.getParameter("cccd");
        String phoneNumber = req.getParameter("phoneNumber");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        int roleId = Integer.parseInt(req.getParameter("roleId"));

        Employee updatedEmployee = new Employee(cccd, phoneNumber, name, email, userName, roleId);
        boolean isUpdated = employeeService.editEmployee(updatedEmployee, password);
        if (isUpdated) {
            resp.sendRedirect("/employees");
        } else {
            req.setAttribute("errorMessage", "Error updating employee");
            showEditForm(req, resp);
        }
    }
    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void searchEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Employee> employees = employeeService.getEmployeesByName(name);
        req.setAttribute("employeeList", employees);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/employees/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void listEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        req.setAttribute("employeeList", employees);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/employees/list.jsp");
        dispatcher.forward(req, resp);
    }
}
