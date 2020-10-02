<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
	<h3>ALL THE USERS</h3>
	${listKey}
	<h3>WE ARE USING JSTL</h3>
	<hr/>
	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "core" %>
		<ol>
			<core:forEach items="${listKey}" var ="u">
				<li> ID: ${u.userId}, Name: ${u.name} ,with Phone: ${u.phone}
			</core:forEach>
		</ol>
		
<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">USER_ID</th>
      <th scope="col">NAME</th>
      <th scope="col">PHONE</th>
    </tr>
  </thead>
  <tbody>
 <core:forEach items = "${listKey}" var = "u">
 	<tr> 
     <th scope="row"> ${u.userId}</th>
      <td>${u.name}</td>
      <td>${u.phone}</td>
    </tr>
</core:forEach>
    </tbody>
</table>
</body>
</html>