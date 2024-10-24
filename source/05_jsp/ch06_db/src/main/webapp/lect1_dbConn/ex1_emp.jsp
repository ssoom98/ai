<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid    = "scott";
	String upw    = "tiger";	

	%>
<%
	Connection conn =null;
	Statement stmt=null;
	ResultSet rs=null;
	String sql = "SELECT * FROM EMP";
	try{
		Class.forName(driver); // 1단계 : 드라이버 로드
		conn =DriverManager.getConnection(url,uid,upw); // 2단계:DB연결
		out.println("<h2>DB연결성공<h2>");
	}catch(Exception e){
		System.out.print(e.getMessage());
	}finally{
		try{
			if(conn!=null) conn.close();
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		
	}
%>		
</body>
</html>