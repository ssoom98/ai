package com.lec.loopQuiz;

import java.util.Scanner;

//사용자로부터 원하는 구구단수를 입력받아 해당 구구단을 출력해 보자(for문 이용)
public class Quiz03 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.print("몇단을 출력할까요?");
		int dansu = scanner.nextInt();
		for(int i = 1; i<=9; i++) {
			System.out.println(dansu +"*"+i+"="+ dansu*i);
		}
		scanner.close();
	}
}
