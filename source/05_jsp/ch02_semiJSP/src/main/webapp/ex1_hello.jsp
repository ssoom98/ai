<%@ %> page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이파일은 ex_hello.jsp파일 입니다</h1>
	<h4>JSP파일은 html java가 들어있는 파일</h4>
	<h5>cf. 서블릿파일은 java파일 안에 html에 들어있는 파일</h5>
	<%
	//스크립트릿내에서는 자바코드 
	int total = 0;
	for(int cnt= 1; cnt<=100; cnt++){
		total += cnt;
	}
	
	%>
	<h2>1부터 100까지의 누적합은? <%=total %>입니다</h2> <!-- 자바표현식안에는 식이 들어간다 -->
</body>
</html>