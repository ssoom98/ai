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
	<%response.sendRedirect("list.do"); %>
</body>
</html>
<!-- 마지막페이지가 삭제되지 않거나 사라지지않으면 dao에서 클로즈하거나 db에서 commit이 되었는지 확인 -->