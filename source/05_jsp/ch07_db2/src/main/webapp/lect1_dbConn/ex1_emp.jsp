<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
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
	
	<table>
<%
	Connection conn =null;
	Statement stmt=null;
	ResultSet rs=null;
	String sql = "SELECT * FROM EMP";
	try{
		Class.forName(driver); // 1단계 : 드라이버 로드
		conn =DriverManager.getConnection(url,uid,upw); // 2단계:DB연결
		out.println("<h2>DB연결성공<h2>");
		stmt = conn.createStatement();// 3단계: SQL전송단계
		rs = stmt.executeQuery(sql);
		if(rs.next()){// sql문 전송 결과가 1행이상 있을 때
			out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
			do{
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");//db에 null데이터는 0으로 받음
				Date hiredate=rs.getDate("hiredate");// 날짜만 받음
				Timestamp hire2=rs.getTimestamp("hiredate");// 날짜와 시간을 다 받음
				String hire3=rs.getString("hiredate");// DB출력된 정보를 문자열로(비추)
				int sal= rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno=rs.getInt("deptno");
				out.print("<tr><td>" + empno +"</td>");
				out.print("<td>" + ename +"</td>");
				out.print("<td>" + job +"</td>");
				out.print("<td>" + mgr +"</td>");
				out.print("<td>" + hiredate +" "+hire2+"</td>");
				out.print("<td>" + sal +"</td>");
				out.print("<td>" + comm +"</td>");
				out.print("<td>" + deptno +"</td></tr>");
			}while(rs.next());
		}else{
			out.print("<tr><td>입력된 사원정보가 없습니다</td></tr>");	
		}
	}catch(Exception e){
		System.out.print(e.getMessage());
	}finally{
		try{
			if(rs!=null)rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		
	}
%>		
</table>
</body>
</html>