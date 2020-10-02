<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "UpdatePassword" method = "post">
	<h1>FOR UPDATING PASSWORD</h1>
	<br/>
	<label>Password<input type = "password" name ="pass"> </label>
	<br/>
	<input type = "submit" value = "Update">
	</form>
	<hr/>
	<h1>FOR UPDATING PHONE</h1>
	<form action = "UpdatePhone" method = "post">
	<br/>
	<label>Phone<input type = "text" name ="phone"> </label>
	<br/>
	<input type = "submit" value = "Update">
	</form>	
</body>
</html>