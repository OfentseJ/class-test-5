/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class DisplayEmployeesServlet extends HttpServlet {
@EJB EmployeeFacadeLocal efl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       String department = request.getParameter("department").toUpperCase();
       String location = "no_employees_outcome.jsp";
       
       List<Employee> emps = efl.findAll();
       for(Employee emp : emps)
       {
       String depart = emp.getDepartment();
        if(depart.equals(department))
        {
            location = "display_employees_outcome.jsp";
            break;
        }
       }
       
       
       List<Employee> employees = efl.findAllEmployees(department);
        request.setAttribute("employees", employees);
        request.setAttribute("department", department);
        
        RequestDispatcher rd = request.getRequestDispatcher(location);
        rd.forward(request, response);
       
        
       
    }
}
