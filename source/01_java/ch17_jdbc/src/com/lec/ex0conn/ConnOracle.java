package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 오라클 연동 여부: (1) 드라이버 로드 (jdk17에서부터 생략가능) (2) DB연결
public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		try {
			Class.forName(driver); //(1) 드라이버 로드
			System.out.println("드라이버 로드 성공");
			conn =DriverManager.getConnection(url,"scott","tiger");
			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"드라이버오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
