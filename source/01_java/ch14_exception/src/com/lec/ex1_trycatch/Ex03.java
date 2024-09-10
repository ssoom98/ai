package com.lec.ex1_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

// 첫번째 정수를 제대로 입력할때 까지 입력받음
// 두번째 정수를 제대로 입력하지 않으면 1로 할당받고, 곱셈, 덧셈, 뺄셈을 출력
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 0, j = 1;
		do {
			try {
				System.out.print("첫번째 정수는 : ");
				i = scanner.nextInt();// InputMismatchException
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			}
		} while (true);
		System.out.print("두번째 정수는 : ");
		try {
			j = scanner.nextInt();// InputMismatchException
			System.out.println("i/j = " + (i / j)); // ArithmeticException
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수는 없습니다 : " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("두번째 정수를 잘못 입력하셔서 1로 처리합니다.");
		}
		System.out.println("i*j = " + (i * j));
		System.out.println("i+j = " + (i + j));
		System.out.println("i-j = " + (i - j));
		scanner.close();
	}
}
