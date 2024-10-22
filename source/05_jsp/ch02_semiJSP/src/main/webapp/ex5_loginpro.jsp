<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
	%>
	<h2>이름은<%=name %></h2>
	<h2>아이디는<%=id %></h2>
	<h2>비밀번호는<%=pw %></h2>
</body>
</html>