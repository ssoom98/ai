<%@page import="org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase"%>
<%@page import="com.lec.dto.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpRepository"%>
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
		window.onload(){
			document.querySelector('input[name="schName"]').onkeyup =function(){
				if(this.value.trim()){
					document.querySelector('form').submit();	
				}
				
			};
		};
	</script>
</head>
		<%
			String schName = request.getParameter("ename");
			if(schName==null){
				schName="";
			}
			
			%>
<body>
	<form action="">
		<p>
			사원명<input type="text" name="ename" value="<%=schName.trim().toUpperCase()%>" >
			<input type="submit" value="검색">
		</p>
		
		
	</form>
	<table>
		<%
		
		EmpRepository empRepository = EmpRepository.getInstance();
		ArrayList<Emp> empList = empRepository.empListBySchName(schName);
		out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
		if (empList.size() != 0) {
			for (Emp emp : empList) {
				out.print("<tr><td>" + emp.getEmpno() + "</td>");
				out.print("<td>" + emp.getEname() + "</td>");
				out.print("<td>" + emp.getJob() + "</td>");
				out.print("<td>" + emp.getMgr() + "</td>");
				out.print("<td>" + emp.getHiredate() + "</td>");
				out.print("<td>" + emp.getSal() + "</td>");
				out.print("<td>" + emp.getComm() + "</td>");
				out.print("<td>" + emp.getDeptno() + "</td>");
			}
		} else {
			out.print("<tr><td colspan ='8'>해당부서번호의 사원은 없습니다</tr></td>");

		}
		%>
	</table>
</body>
</html>