<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
	<script>
		
	</script>
</head>
<body>
	<%
		String name=request.getParameter("name");
		String numStr=request.getParameter("num");
	%>
	
		<fieldset>
			<legend>입력</legend>
			<form>
			<p>이름<input type="text" name="name" value="<%=name==null?"" : name.trim()%>"></p>
			<p>숫자<input type="number" name="num" min="1" value=<%=numStr %>></p>
			<p><input type="submit"  value="누적"></p>
			</form>
		</fieldset>
	<%
		if(numStr!=null && !numStr.equals("")){
			int num = Integer.parseInt(numStr);
			int sum=0;
			for(int i=0; i<=num; i++){
				sum += i;
			}
			out.println("<h2>1부터"+num+"까지 누적합은" +sum+ "입니다</h2>");
		}
	
	%>
	
	
</body>
</html>