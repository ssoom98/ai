package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.Person;

public class PersonRepository {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pw = "tiger";
	public final static int SUCESS = 1;
	public final static int FAIL = 0;
	private static PersonRepository INSTANCE = new PersonRepository();

	public static PersonRepository getInstance() {
		return INSTANCE;
	}

	private PersonRepository() {
	}

	// jname list
	public ArrayList<String> jnameList() {
		ArrayList<String> jnames = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				jnames.add(rs.getString("jname"));
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

			return jnames;
		}
	}

	// 1번기능(INSERTPERSON): PNAME,JNAME, KOR,ENG, MAT를 입력받아 PERSON 테이블 INSERT
	public int insertperson(String pname, String jname, int kor, int eng, int mat) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON \r\n" + "    VALUES(PERSON_PNO_SEQ.NEXTVAL,?,\r\n"
				+ "    (SELECT JNO FROM JOB WHERE JNAME=?), ?,?,?)";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			pstmt.setString(2, jname);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, mat);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCESS ? "입력성공" : "입력실패");

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
			return result;

		}
	}

	// 2번기능(GETPERSONJNAME) : JNAME, 입력받아 RANK, PNAME(PNO), JNAME, KOR, ENG, MAT,
	// SUM, 출력
	// RANK는 SUM내림차순으로 순위를 정한다. --ROWNUM
	public ArrayList<Person> getPerson(String jname) {
		ArrayList<Person> dtos = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' RANK ,A.*\r\n"
				+ "    FROM(SELECT PNAME||'('||PNO||'번)' PNAME ,JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUMSCORE\r\n"
				+ "    FROM PERSON P, JOB J\r\n" + "    WHERE P.JNO=J.JNO AND JNAME=? \r\n"
				+ "    ORDER BY SUMSCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String rank = rs.getString("rank");
				String pname = rs.getString("pname");

				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sumscore = rs.getInt("sumscore");
				dtos.add(new Person(rank, pname, jname, kor, eng, mat, sumscore));
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
			return dtos;
		}
	}

	// 3번기능(GETPERSON) : RANK, PNAME(PNO), JNAME, KOR,ENG, MAT, SUM 출력
	public ArrayList<Person> getPerson() {
		ArrayList<Person> dtos = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' RANK ,A.*\r\n"
				+ "    FROM(SELECT PNAME||'('||PNO||'번)' PNAME ,JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUMSCORE\r\n"
				+ "    FROM PERSON P, JOB J\r\n" + "    WHERE P.JNO=J.JNO \r\n" + "    ORDER BY SUMSCORE DESC)A";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String rank = rs.getString("rank");
				String pname = rs.getString("pname");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sumscore = rs.getInt("sumscore");
				dtos.add(new Person(rank, pname, jname, kor, eng, mat, sumscore));
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
			return dtos;

		}
	}
}
