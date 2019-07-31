<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="comakeit.assessment1.employee._management.Bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Operations</title>
</head>
<body>
<% AdminBean admin = (AdminBean)session.getAttribute("adminBean"); %>
<%="<h2>Welcome Administrator: " + admin.getUsername() + " </h2>" %>
<p><h3>Choose from below operations:</h3></p>
<a href="EmployeeOperations.jsp?action=create">Add Employee</a>
<br>
<a href="EmployeeOperations.jsp?action=delete">Delete Employee</a>
<br>
<a href="Redirect?action=viewEmployees">View Employees</a>
<br>
<a href="Redirect?action=viewDepartments">View Departments</a>
<br>
<a href="EmployeeOperations.jsp?action=viewEmployeesofSpecificManager">View Employees of specific Manager</a>
<br>
<a href="EmployeeOperations.jsp?action=viewEmployeeDetails">View Employee Details and PF</a>
<br>
<a href="Redirect?action=listEmployeesBySalary">View Employees of salary between 10000 and 20000</a>
<br>
<a href="login.jsp">Logout</a>
</body>
</html>


