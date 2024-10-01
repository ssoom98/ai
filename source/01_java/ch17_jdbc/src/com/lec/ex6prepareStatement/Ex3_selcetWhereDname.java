package com.lec.ex6prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// com.lec.ex2selectWhere
// 부서명을 입력받아 해당 부서의 정보를 출력하고 해당 부서 사원(사번, 이름, 급여, 급여순)을 출력
public class Ex3_selcetWhereDname {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String deptSql ="SELECT* FROM DEPT WHERE DNAME =UPPER(?)";
		String empSql ="select EMPNO, ENAME, SAL \r\n"
				+ "FROM EMP e, dept d\r\n"
				+ "where e.deptno= d.deptno \r\n"
				+ "and dname=upper(?)\r\n"
				+ "ORDER BY SAL";
		try { //deptSql
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(deptSql);
			System.out.print("검색할 부서이름 : ");
			String dname=sc.next();
			pstmt.setString(1, dname);
			rs= pstmt.executeQuery();
			if(rs.next()) {// 부서번호가 존재하는 경우
				System.out.println("원하는 부서 번호는 : "+rs.getInt("deptno"));
				System.out.println("원하는 부서 이름 : " + rs.getString("dname"));
				System.out.println("원하는 부서 위치 : " + rs.getString("loc"));
					rs.close();// empSql시작
					pstmt.close();
					pstmt= conn.prepareStatement(empSql);
					pstmt.setString(1, dname);
					rs= pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("사번\t이름\t급여");
						do {
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							int sal =rs.getInt("sal");
							System.out.println(empno+"\t"+ename+"\t"+sal);
						}while(rs.next());
					}else {
						System.out.println(dname+"사원이 없습니다.");				
					}
			}else { // 없는 부서
				System.out.println(dname+"없는 부서입니다");
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
			System.out.println(e.getMessage());
		
		
			}
		}
	}
}