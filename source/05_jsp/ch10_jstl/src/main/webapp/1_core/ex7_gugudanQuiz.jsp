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
	<form>
		<p>
		<input type="text" name="n1" readonly="readonly" size="1" value="<%=(int)(Math.random()*9+1) %>" >
		*
		<input type="text" name="n2" readonly="readonly" size="1" value="<%=(int)(Math.random()*9+1) %>">
		=
		<input type="number" name="result" placeholder="정답입력">
		</p>
		<P>
			<input type="submit" value="확인">
		</P>
	</form>
		<c:set var="n1" value="${param.n1 }"/>
		<c:set var="n2" value="${param.n2 }"/>
		<c:set var="result" value="${param.result }"/>
		<c:if test="${not empty result }">
			<c:if test="${result eq n1*n2 }">
			<h3>${n1}*${n2}=${ result} 정답입니다</h3>
			</c:if>
			<c:if test="${not(result eq n1*n2) }">
			<h3>${n1}*${n2}=${ result} 오답입니다</h3>
			</c:if>
		</c:if>

</body>
</html>
