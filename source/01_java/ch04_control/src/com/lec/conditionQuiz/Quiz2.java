package com.lec.conditionQuiz;

// 최대값 출력
public class Quiz2 {
	public static void main(String[] args) {
		int num1 = 27;
		int num2 = 32;
		// 방법 1 : if 블럭안의 max 변수를 if블럭 전에 선언
		// int max;
		// 방법 2 : if 블럭안에 선언한 max 변수를 if안에서 출력
		if (num1 > num2) {
			int max = num1;
			System.out.println(max);//alt + 화살표↓,↑ : 소스 한줄 단위로 이동
		} else {
			int max = num2;
			System.out.println(max);//ctrl + alt + 화살표↓,↑ : 소스 한줄 복사
		}
	} // main
}
