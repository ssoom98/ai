package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 입력받아 부서번호, 부서명, 부서위치를 입력받아 insert
public class InsertDept {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn= null;
		Statement stmt = null;
		System.out.print("입력할 부서번호는 >");
		int deptno = sc.nextInt();
		System.out.print("입력할 부서명은 >");
		String dname =sc.next();
		System.out.print("입력할 부서위치는 >");
		String loc =sc.next();
		String sql = String.format("INSERT INTO DEPT VALUES (%d,UPPER('%s'),UPPER('%s'))",deptno, dname, loc);
		
		try {
			conn= DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0 ? "입력성공":"입력실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"sql문오류,중복된 부서번호");
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			
			}
	
		}
		
	}
}
