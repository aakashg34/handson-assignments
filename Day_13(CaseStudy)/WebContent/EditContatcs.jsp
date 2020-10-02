<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "EditContacts" method = "post">
	<label>
	UserId<input type = "text" name = "id">
	</label>
	<br/>
	<label>Name<input type = "text" name ="name"> </label>
	<br/>
	<input type = "submit" value = "Edit">
	</form>
	<hr/>

<h2>FOR EDITING THE PHONE OF THE CONTACT</h2>
<form action = "EditContacts" method = "post">
	<label>
	UserId<input type = "text" name = "id">
	</label>
	<br/>
	<label>Phone<input type = "text" name ="Phone"> </label>
	<br/>
	<input type = "submit" value = "Edit">
	</form>
</body>
</html>