<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String conPath= request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex.css" rel="stylesheet" >

</head>
<body>
	<form action="ex2_requestScope.jsp">
		<p>ID<input type="text" name="id"></p>
		<p>PW<input type="password" name="pw"></p>
		<p><input type="submit"></p> 
	</form>
	<%
	 request.setAttribute("requestAtt", "requestValue"); // ★  새로운 요청이 들어오기 전까지
	 //session.setAttribute("sessionAtt","sessionValue" );// ★ 브라우저를 닫기 전까지 유효
	 // 자바에서 request객체에 setAtrribute한 내용을 jsp로 전달	
	 // request객체를 유지한 상태에서 페이지 변경(forword)
	 RequestDispatcher dispatcher = request.getRequestDispatcher("ex2_requestScope.jsp?id=aaa&pw=111");
	 dispatcher.forward(request,response); //페이지 넘어감
	 %>
	 
	 
	<h2><%=request.getAttribute("requestAtt") %></h2>
	<h2>${requestScope.requestAtt}</h2>
	<h2>${requestAtt}</h2>
</body>
</html>