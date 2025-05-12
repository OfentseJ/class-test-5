/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.ejb.bl.EmployeeFacadeLocal;
import za.ac.tut.entities.Employee;

/**
 *
 * @author Student
 */
public class AddEmployeeServlet extends HttpServlet {
    
    @EJB EmployeeFacadeLocal efl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String department = request.getParameter("department").toUpperCase();
        Double salary = Double.parseDouble(request.getParameter("salary"));

        Employee emp = new Employee();
        emp.setId(id);
        emp.setDepartment(department);
        emp.setSalary(salary);
        efl.createEmployee(emp);
       
        RequestDispatcher rd = request.getRequestDispatcher("add_employee_outcome.jsp");
        rd.forward(request, response);
       
    }


}
