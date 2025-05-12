<%-- 
    Document   : highest_paid_employee_outcome
    Created on : 11 May 2025, 3:22:50 PM
    Author     : Student
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="za.ac.tut.entities.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Highest Paid Employee Outcome Page</title>
    </head>
    <body>
        <h1>Highest Paid Employee Outcome</h1>
        <%
        Employee employee = (Employee)request.getAttribute("employee");
        Long id = employee.getId();
        double salary = employee.getSalary();
        String department = employee.getDepartment();
        
        DecimalFormat df = new DecimalFormat("R###,###,###.00");
        %>
        <table>
            <tr>
                <td>Id:</td>
                <td><%=id%></td>
            </tr>
            <tr>
                <td>Department:</td>
                <td><%=department%></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td><%=df.format(salary)%></td>
            </tr>
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
