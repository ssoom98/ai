package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 수정할 부서번호, 부서명, 부서위치를 받아 update
public class UpdateDept {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn =null;
		Statement stmt = null;
		System.out.print("수정할 부서 번호는 >");
		// 부서번호 존재 여부 confirm
		int deptno = sc.nextInt();
		System.out.print("수정할 부서 이름은 >");
		String dname =sc.next();
		System.out.print("수정할 부서 위치는 >");
		String loc =sc.next();
		String sql=
				String.format("update dept set dname=upper('%s'),\r\n"
				+ "    loc=upper('%s')\r\n"
				+ "    where deptno = %d",dname, loc,deptno);
		try {
			conn =DriverManager.getConnection(url,"scott","tiger");
			stmt =conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0?"수정성공":"해당부서가 없어서 수정 못함");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
