package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇월인가요?");
		int num = scanner.nextInt();
		if (num < 1 || num > 12) {
			System.out.println("다시입력하세요");
			System.exit(0);
		}
		switch (num) {
		case 1:
		case 2:
		case 11:
		case 12:
			System.out.println("겨울");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("봄");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름");
			break;
		case 9:
		case 10:
			System.out.println("가을");
			break;
		}
		scanner.close();
		}
} 
