package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lec.dto.Emp;

public class EmpRepository {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	private static EmpRepository INSTANCE = new EmpRepository();

	public static EmpRepository getInstance() {
		return INSTANCE;
	}

	private EmpRepository() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// SELECT * FROM EMP 수행결과 return
	public ArrayList<Emp> empList() {
		ArrayList<Emp> dtos = new ArrayList<Emp>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM EMP";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				dtos.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno, null));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
		return dtos;
	}

	// 부서번호로 검색 empLise return
	public ArrayList<Emp> empListByDeptno(String deptnoStr) {
		ArrayList<Emp> dtos = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT E.*,DNAME\r\n" + "    FROM EMP E, DEPT D\r\n"
				+ "    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, deptnoStr);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				String dname= rs.getString("dname");
				dtos.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));
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
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
		return dtos;
	}


// 이름으로 검색해서 empList return

public ArrayList<Emp> empListBySchName(String schName) {
	ArrayList<Emp> dtos = new ArrayList<Emp>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "SELECT E.*,DNAME\r\n"
			+ "    FROM EMP E, DEPT D\r\n"
			+ "    WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%'||TRIM(UPPER(?))||'%'";
	try {
		conn = DriverManager.getConnection(url, uid, upw);
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, schName);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			String mgr = rs.getString("mgr");
			Date hiredate = rs.getDate("hiredate");
			int sal = rs.getInt("sal");
			int comm = rs.getInt("comm");
			int deptno = rs.getInt("deptno");
			String dname= rs.getString("dname");
			dtos.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));
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
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	return dtos;
}
}