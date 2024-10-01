package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Ex3_selectWheredname {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("출력을 원하는 부서는? : ");
		String dname = sc.next();
		String sql ="SELECT* FROM DEPT WHERE DNAME =UPPER('"+dname+"')";
		sql = String.format("SELECT* FROM DEPT WHERE DNAME =UPPER('%s')", dname);
		try {
			conn= DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("부서번호는 : "+ rs.getInt("deptno"));
				System.out.println("부서이름은 : "+ dname);
				System.out.println("부서지역은 : "+ rs.getString("loc"));
			}else {
				System.out.println("해당부서이름이 존재하지 않스비다");
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
