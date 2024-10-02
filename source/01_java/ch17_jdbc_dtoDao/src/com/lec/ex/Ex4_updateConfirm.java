package com.lec.ex;

import java.util.Scanner;

import com.lec.dao.DeptRepository;
import com.lec.dto.Dept;

public class Ex4_updateConfirm {
	public static void main(String[] args) {
		DeptRepository deptRepository = DeptRepository.getInstance();
		Scanner sc	=new Scanner(System.in);
		System.out.println("수정할 부서번호는 >");
		int deptno = sc.nextInt();
		Dept dept = deptRepository.getDept(deptno); // 해당부서번호가 있는지 조회
		if(dept!=null) {
			System.out.print("수정할 부서명은?");
			String dname = sc.next();
			System.out.print("수정할 위치는?");
			String loc = sc.next();
			deptRepository.updateDept(deptno, dname, loc);
		}else {
			System.out.println("유효한 부서번호가 아닙니다");
		}
		sc.close();
	}
}
