package controller;

import model.entity.Employee;
import model.service.employee.EmployeeServiceImpl;
import model.service.employee.IEmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeController", value = "/EmployeeController")
public class EmployeeController extends HttpServlet {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showTable(request, response);
    }

    private void showTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        List<Employee> employees = employeeService.findAll(page);
        int totalPage = employeeService.totalPage;
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("views/table.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}