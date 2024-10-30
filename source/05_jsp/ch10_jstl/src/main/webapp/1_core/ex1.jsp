<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <% String conPath= request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex.css" rel="stylesheet" >

</head>
<body>
	<h2>core 라이브러리 태그 : if , forEach, set, ...</h2>
	<c:forEach var="i" begin="1" end="3" step="1">
		${i}번째 안녕하세요<br>
	</c:forEach>
	<h2>fmt(formatting) 라이브러리 : 날짜나 숫자 format</h2>
	<fmt:formatDate value="<%=new Date(System.currentTimeMillis()) %>" pattern="YY-MM-dd(E)"/>
	<fmt:formatNumber value="356356.356" pattern="#,###.##"></fmt:formatNumber><!--open마지막에 close하고 싶을때 /넣어서 -->	
	<h2>그외 라이브러리 (functions) : el 표기법과 함께 사용</h2>
	id 파라미터를 대문자로: ${fn:toUpperCase(parma.id)}
	id 파라미터를 대문자로: ${param.id.toUpperCase()}
</body>
</html>