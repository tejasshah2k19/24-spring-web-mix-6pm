<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<h2>Ecom Login</h2>
<form action="elogin" method="post">
	Email : <input type="text" name="email"/><br><br> 
	Password : <input type="password" name="password"/><br><br> 
		<input type="submit" value="Signup"/>
	
</form>
<br>
${error}
</body>
</html>