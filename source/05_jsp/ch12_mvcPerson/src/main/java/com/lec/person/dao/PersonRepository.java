package com.lec.person.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.person.dto.Person;

public class PersonRepository {
	public static final int SUCCESS= 1;
	public static final int FAIL = 0;//수정, 삭제 , 추가 성공 실패시 SUCCESS와 FAIL 의 값을 리턴
	private DataSource ds;
	//싱글톤 
	private static PersonRepository INSTANCE = new PersonRepository();
	public static PersonRepository getInstance() {
		return INSTANCE;
	}
	private PersonRepository() { // 커넥션 풀에 있는 DataSource 가져오기(ds)
		
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
//	private Connection getConnection () {
//		Connection conn = null;
//		try {
//			ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
//			conn = ds.getConnection();
//		} catch (NamingException e) {
//			System.out.println(e.getMessage());
//		}
//		return conn;
//	}
	
	//1. LIST(PAGING없이) : public ArrayList<person> getPersonList()
	public ArrayList<Person> getPersonList(){
		ArrayList<Person> dtos = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT*FROM PERSON";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id=  rs.getInt("id");
				String name= rs.getString("name");
				String tel= rs.getString("tel");
				String address= rs.getString("address");
				Date birth= rs.getDate("birth");
				String memo= rs.getString("memo");
				Timestamp rdate= rs.getTimestamp("rdate");
				dtos.add(new Person(id,name,tel,address,birth,memo,rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
		
	}
	//1. LIST(PAGING 추가) : public Arraylist<person> getPersonList(int startRow,int endRow)(몇등, 몇등까지)
	public ArrayList<Person> getPersonList(int startRow,int endRow){
		ArrayList<Person> dto = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN,A.* FROM (SELECT *FROM PERSON ORDER BY ID DESC) A)\r\n"
				+ "WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id=  rs.getInt("id");
				String name= rs.getString("name");
				String tel= rs.getString("tel");
				String address= rs.getString("address");
				Date birth= rs.getDate("birth");
				String memo= rs.getString("memo");
				Timestamp rdate= rs.getTimestamp("rdate");
				dto.add(new Person(id,name,tel,address,birth,memo,rdate));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
		
	}
	//2. getCount (PAGING 처리시 필요한 전체 갯수) :public int getCount()
	public int getCount() {
		int count =0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM PERSON";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		
		return count; 
		
	}
	//3. 추가 : public int insertperson(Person person)
	public int insertperson(Person person) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO PERSON(ID, NAME, TEL, ADDRESS,BIRTH, MEMO)"
				+ "    VALUES (PERSON_ID_SEQ.NEXTVAL, ?, ?, ?, ?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,person.getName());
			pstmt.setString(2,person.getTel());
			pstmt.setString(3,person.getAddress());
			pstmt.setDate(4,person.getBirth());
			pstmt.setString(5,person.getMemo());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("추가 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
		
		
		
	}
	//4. 한명출력 : public Person getPerson(int id)
	public Person getPerson(int id) {
		Person dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PERSON WHERE ID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name= rs.getString("name");
				String tel= rs.getString("tel");
				String address= rs.getString("address");
				Date birth= rs.getDate("birth");
				String memo= rs.getString("memo");
				Timestamp rdate= rs.getTimestamp("rdate");
				dto=new Person(id,name,tel,address,birth,memo,rdate);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
		
		
		
		
		
		
	}
	
	//5. 수정: public int updatePerson(Person person)
	public int updatePerson(Person person) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE PERSON SET NAME=?, TEL=?, ADDRESS=?, BIRTH=?, MEMO=? WHERE ID=?";	
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,person.getName());
			pstmt.setString(2,person.getTel());
			pstmt.setString(3,person.getAddress());
			pstmt.setDate(4,person.getBirth());
			pstmt.setString(5,person.getMemo());
			pstmt.setInt(6,person.getId());
			
			result = pstmt.executeUpdate();
			System.out.println("수정 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//6. 삭제 : public int deletePerson(int id)
	public int deletePerson(int id) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM PERSON WHERE ID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			result =pstmt.executeUpdate(); 
			System.out.println("삭제 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				
				if(pstmt!=null) pstmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	
	
	
}
