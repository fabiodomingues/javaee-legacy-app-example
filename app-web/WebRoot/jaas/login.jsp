<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<h1>Login</h1>
		
		<form method=post action="j_security_check" >
			E-mail: <input type="text"  name= "j_username" /><br>
			Password: <input type="password"  name= "j_password" /><br>
		    <input type="submit" value="Send" />
		</form> 
	</div>

</body>
</html>