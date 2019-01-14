<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>You are secure!</h1>
		<h2>Hello, <%=request.getUserPrincipal().getName()%>!</h2>
		<p/>
	    <a href="../jaas/logoff.jsp">Sair</a>   
		<p/>
	    <a href="../index.jsp">Voltar</a>   
	</div>
</body>
</html>