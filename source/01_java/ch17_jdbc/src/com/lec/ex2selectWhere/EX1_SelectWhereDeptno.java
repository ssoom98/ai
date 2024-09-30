package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


// 사용자에게 원하는 부서번호를 입력받아 부서 정보 출력
public class EX1_SelectWhereDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // select 결과를 받을 변수객체
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 부서 번호는?");
		int deptno = sc.nextInt();
				sc.close();
		String sql = "SELECT *FROM DEPT WHERE DEPTNO=" +deptno;
		
		try {
			conn = DriverManager.getConnection(url, "scott","tiger");
			stmt =conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				 String dname = rs.getString("dname");
				 String loc = rs.getString("loc");
				 System.out.println(deptno + "번 부서정보는 다음과 같습니다");
				 System.out.println("부서명 : "+ dname);
				 System.out.println("지역 : "+ loc);
			}else {
				System.out.println("해당 부서가 존재하지않습니다");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			
			}
		}
		
	}
}
