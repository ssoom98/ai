package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.Emp;

public class EmpRepository {
	private static EmpRepository INSTANCE = new EmpRepository();
	public static EmpRepository getInstance() {
		return INSTANCE;
	}
	private EmpRepository() {}
	private Connection getConnection() throws SQLException {
		Connection conn= null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// SELECT * FROM EMP 수행결과 return
	public ArrayList<Emp> empList() {
		ArrayList<Emp> dtos = new ArrayList<Emp>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM EMP";
		try {
			conn = getConnection();
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
			conn = getConnection();
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
		conn = getConnection();
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