<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<style>
body{
background-color : #e1f7d5;
}
input[type=text]:focus,input[type==password]:focus {
  background-color: white;
   border: 3px solid #555;
}
</style>
</head>
<body >
<center>
<form action="Validate" method="post">
<h1><marquee>Welcome to Employee Management System!!</marquee></h1>
<br/>
<h3>Enter UserName or loginID:</h3>
<input type="text" name="username"/>
<h3>Enter Password:</h3>
<input type="password" name="password" required />
<br/><br><br>
<input type="submit" value="login"/>
</form>
</center>
</body>
</html>