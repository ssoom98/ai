package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDeptConfirm {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("수정할 부서 번호는 >");
		int deptno = sc.nextInt();
		// 부서번호 존재 여부 confirm
		String confirmSql= "select*from dept where deptno="+deptno;
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(confirmSql);
			if (rs.next()) {//수정진행
				System.out.println("수정할 부서명은 >");
				String dname = sc.next();
				System.out.println("수정할 부서위치는 >");
				String loc = sc.next();
				String updateSql = String.format("update dept set dname=upper('%s'), loc=upper('%s')where deptno =%d", dname,loc, deptno);
			int result = stmt.executeUpdate(updateSql);
			System.out.println("수정성공");
			}else {
				System.out.println(deptno+ "번 부서는 유효하지 않은 부서 번호 입니다");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}