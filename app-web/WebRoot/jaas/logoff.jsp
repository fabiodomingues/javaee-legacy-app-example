<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	org.jboss.logging.Logger.getLogger(this.getClass()).warn("Logout: Usuário " + request.getUserPrincipal().getName().toString() + " acessou página logoff.jsp");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expiresponse", 0);
	request.getSession().invalidate();
	String context = request.getContextPath();
	%>
	<script>
		top.document.location="<%=context%>/index.jsp";
	</script>
</body>
</html>