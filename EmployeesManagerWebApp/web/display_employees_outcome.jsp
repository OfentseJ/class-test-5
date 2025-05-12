<%-- 
    Document   : display_employees_outcome
    Created on : 11 May 2025, 3:15:28 PM
    Author     : Student
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Employees Outcome Page</title>
    </head>
    <body>
        <h1>Display Employees Outcome</h1>
        <%
        List<Employee> employees = (List<Employee>)request.getAttribute("employees");
        String department = (String)request.getAttribute("department");
        DecimalFormat df = new DecimalFormat("R###,###,###.00");
        %>
        <p>
            Below are the employees in department <%=department%>.
        </p>
        <table border = "1">
            <tr>
                <th>Id</th>
                <th>Salary</th>
            </tr>
            <%
            for(Employee employee : employees)
            {
            Long id = employee.getId();
            double salary = employee.getSalary();
            %>
            <tr>
                <td><%=id%></td>
                <td><%=df.format(salary)%></td>
            </tr>
            <%
            }
            %>
        </table>
        <p>
            Click <a href="LogOutServlet.do">here</a> to logout. <br>
            <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="menu.html">Menu</a></li>
        </ul>
        </p>
    </body>
</html>
