package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		
		if(num>0) {
			System.out.println(num);
		}
		else {
			System.out.println(num*-1);// -(-1)=1
		scanner.close();
		}

	}

}
