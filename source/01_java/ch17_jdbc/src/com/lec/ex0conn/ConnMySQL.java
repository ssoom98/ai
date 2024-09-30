package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 오라클 연동 여부: (1) 드라이버 로드 (jdk17에서부터 생략가능) (2) DB연결
public class ConnMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dev_user?serverTimezone=UTC";
		Connection conn = null;
		try {
			Class.forName(driver); //(1) 드라이버 로드
			System.out.println("드라이버 로드 성공");
			conn =DriverManager.getConnection(url,"root","mysql"); // 2.DB연결
			System.out.println("MYSQL 연결 성공");
			//3단계 ~ 6단계
		} catch (Exception e) {
			System.out.println(e.getMessage()+"드라이버오류");
		}finally{
			try{
				if(conn!=null) conn.close(); //7단계 연결해제
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
	}
}
