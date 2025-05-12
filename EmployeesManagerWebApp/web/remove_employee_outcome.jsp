<%-- 
    Document   : remove_employee_outcome
    Created on : 11 May 2025, 3:03:40 PM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Employee Outcome Page</title>
    </head>
    <body>
        <h1>Remove Employee Outcome</h1>
        <%
        Long id = (Long)request.getAttribute("id");
        %>
        <p>
            Employee with the id: <%=id%> has been removed. <br>
            Click <a href="LogOutServlet.do">here</a> to logout. <br>
            <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="menu.html">Menu</a></li>
        </ul>
        </p>
    </body>
</html>
