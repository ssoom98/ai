package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*1. 사용자에게 원하는 부서번호(60)를 입력받아
 * 1.1 해당 부서번호가 존재하는 경우 : 부서정보 출력
 * 	사원정보(사번, 이름, 급여, 상사명) 출력, 사원이 존재하지 않는 경우 사원이 없다고 출력
 * 1.2 해당 부서번호가 존재하지 않을 경우 : 존재하지않는 부서라고 출력
 */
public class EX2_selectWhere {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.print("출력을 원하는 부서 번호는? : ");
		int deptno = scanner.nextInt();
		String query1 = "SELECT * FROM DEPT WHERE DEPTNO="+ deptno;
		String query2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME \"MANAGER\"\r\n"
				+ "    FROM EMP W, EMP M\r\n"
				+ "        WHERE W.MGR=M.EMPNO AND W.DEPTNO ="+deptno;
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query1);
			if(rs.next()) { // 부서번호가 존재하는 경우
				System.out.println("원하는 부서 번호는 : "+deptno);
				System.out.println("원하는 부서 이름 : " + rs.getString("dname"));
				System.out.println("원하는 부서 위치 : " + rs.getString("loc"));
				// query2 전송해서 사원정보출력하기
				rs.close();
				rs=stmt.executeQuery(query2);
				if(rs.next()) {
					System.out.println("사번\t 이름\t 급여\t 상사명");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int		sal =	rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.println(empno+"\t"+ ename+"\t"+sal+"\t"+ manager);
					}while(rs.next());
				}else {
					System.out.println(deptno + "부서 사원은 없습니다");// 사원이 없는 경우
				}
			}else {// 부서번호가 없는 경우
				System.out.println(deptno + "부서번호는 없는 부서번호입니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
			} finally {
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
