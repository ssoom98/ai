package com.lec.ex1_String;

import java.util.Scanner;

//quiz : 전화번호(010-9999-9999) 입력받아, 전화번호, 짝수번째문자,거꾸로, 국번, 뒷4자리출력(x를 입력할때까지 반복적으로) 
public class Ex04_tel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("번호를 입력하세요(XXX-XXXX-XXXX), 단 종료시 x : ");
			String tel = scanner.next(); // 문자열을 입력 "02-0000-0000"
			if(tel.equalsIgnoreCase("x")) break;//반복문 종료조건
			//입력한 전화번호 출력
			System.out.println("전화번호 : " + tel);
			//짝수번째 문자열 출력(length(),charAt(),일반 for문 이용)
			for(int i=0; i<tel.length(); i++) {
				if(i%2==0) {
					System.out.print(tel.charAt(i)+ " ");
				}
			}
			System.out.println();
			System.out.println("-------------------------");
			//거꾸로 문자열 출력(length(), charAt(), for문 이용)
			for(int i = tel.length()-1; i>=0; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			System.out.println("-------------------------");	
			//전화번호 앞자리 출력(indexOf()), substring() 이용)
			int idx = tel.indexOf("-");
			if(idx != -1) {
				String preTel =tel.substring(0,tel.indexOf("-"));
				System.out.println("전화번호 앞자리는 :" +preTel);
				//System.out.println("전화번호 앞자리는 :" + tel.substring(0,tel.indexOf("-")));
				//뒷자리 출력(lastIndexOf(), substring() 이용)
				String postTel =tel.substring(tel.lastIndexOf("-")+1);
				System.out.println("전화번호 뒷자리는 :" +postTel);
				//System.out.println("전화번호 뒷자리는 :" + tel.substring(0,tel.lastIndexOf("-")+1));
			}
		}
	}
}
