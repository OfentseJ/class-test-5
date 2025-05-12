/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
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
public class RemoveEmployeeServlet extends HttpServlet {
@EJB EmployeeFacadeLocal efl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Long id = Long.parseLong(request.getParameter("id"));
       
       
       Employee emp =efl.find(id);
       request.setAttribute("id", id);
       efl.removeEmployee(emp);
       
        RequestDispatcher rd = request.getRequestDispatcher("remove_employee_outcome.jsp");
        rd.forward(request, response);
       
    }
}
