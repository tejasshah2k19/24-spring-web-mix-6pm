<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Signup</h2>

	<form action="saveUser" method="post">
			FirstName : <input type="text"  name="firstName"/>
			<br><br> 
			Email : <input type="text" name="email"/><br><Br>
			
			Password: 	<input type="password" name="password"/><br><Br> 
			
			<input type="submit" value="Signup"/>
	
	
	</form>
</body>
</html>