<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String conPath= request.getContextPath(); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" >

</head>
<body>
	<c:set var="visitNum" value="${param.visitNum }"/>
	<c:choose>
		<c:when test="${visitNum eq 1 }">
			<h3>첫 방문 감사합니다</h3>
			</c:when>
			<c:when test="${visitNum>1 && visitNum<=5 }">
				<h3>많이 많이 방문해 주세요</h3>
			</c:when>
			<c:when test="${visitNum>5 }">
				<h3>많이 방문해주셔서 감사합니다</h3>
			</c:when>
			<c:when test="${empty visitNum }">
				<h3> visitNum은 비었습니다</h3>
			</c:when>
	
	
	</c:choose>
	
</body>
</html>
