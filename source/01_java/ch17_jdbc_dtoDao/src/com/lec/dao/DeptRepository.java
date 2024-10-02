package com.lec.dao;
// crtl+shift+ o+ import 추가나삭제
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.Dept;

public class DeptRepository {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public final static int SUCESS = 1;
	public final static int FAIL = 0;
	private static DeptRepository INSTANCE = new DeptRepository();

	public static DeptRepository getInstance() {
		return INSTANCE;
	}

	private DeptRepository() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

// (1) 부서 정보들 가져오는 함수 : getDeptList
	public ArrayList<Dept> getDeptList() {
		ArrayList<Dept> dtos = new ArrayList<Dept>();
		// SQL수행한 결과를 dtos에 추가하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dtos.add(new Dept(deptno, dname, loc));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

// (2) deptno로 부서정보 가져오는 함수 : getDept(10)
	public Dept getDept(int deptno) {
		Dept dto = null;
		// query 수행 결과를 dto에
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT WHERE DEPTNO=? ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dto = new Dept(deptno, dname, loc);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;

	}

// (3) dname으로 부서정보 가져오는 함수 : getDept
	public Dept getDept(String dname) {
		Dept dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *FROM DEPT WHERE UPPER(DNAME) = UPPER(?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int deptno = rs.getInt("deptno");
				dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dto = new Dept(deptno, dname, loc);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return dto;
	}

// (4) insertDept(new Dept(10,"it","seoul"))
	public int insertDept(int deptno, String dname, String loc) {
		int result = FAIL;
		// insert
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO DEPT VALUES(?,UPPER(?),UPPER(?))";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCESS ? "입력성공" : "입력실패");

		} catch (SQLException e) {
			System.out.println(e.getMessage() + deptno + dname + loc);

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

// (5) updateDept
	public int updateDept(int deptno, String dname, String loc) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE DEPT\r\n" + "    SET DNAME=UPPER(?),\r\n" + "        LOC = UPPER(?)\r\n"
				+ "        WHERE DEPTNO=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCESS ? "수정성공" : "부서번호가 유효하지 않아 수정 실패");

		} catch (SQLException e) {
			System.out.println(e.getMessage() + deptno + dname + loc);

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
// (6) deleteDept
	public int deleteDept(int deptno) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM DEPT WHERE DEPTNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();
			if(result==SUCESS) {
				System.out.println(deptno+"번 부서 삭제성공");
			}else {
				System.out.println(deptno+"부서번호가 유효하지 않아 삭제 실패");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}