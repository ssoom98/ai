<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/ex.css" rel="stylesheet" >

</head>
<body>
<!-- 프론트컨트롤러 -->
	<h1><a href="${conPath }/insert.do">INSERT(C)</a></h1>
	<h1><a href="../select.do">SELECT(R)</a></h1>
	<h1><a href="/ch11/update.do">UPDATE(U)</a></h1>
	<h1><a href="${conPath }/delete.do">DELETE(D)</a></h1>
</body>
</html>
