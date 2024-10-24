<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 지시자: page,include,taglib(9장에서) -->
	<%
		int[]arr={1,2,3};
		out.print(Arrays.toString(arr));
		
	%>
	<hr>
	<!-- JSP표준액션태그에서의 include : jsp를 실행한 결과 html을 include -->
	<jsp:include page="../main/footer.jsp"/>
	<hr>
	<!-- 지시자의 include : jsp를 include -->
	<%@ include file="../main/footer.jsp" %>
	다시 ex2_지시자로 옴 -끝-
		
</body>
</html>