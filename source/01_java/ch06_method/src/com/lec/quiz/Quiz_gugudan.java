package com.lec.quiz;

import java.util.Scanner;

//사용자로부터 구구단 수를 입력받아 gugudanOut(입력받은 수) 호출 -> 호출한 메소드에서 대한 구구단 출력
public class Quiz_gugudan {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("출력하고자 하는 구구단 수는?");
		int dansu = scanner.nextInt();
		System.out.println("입력하신 구구단 수는" + dansu);
		gugudanout(dansu);
	}
		
	private static void gugudanout(int dansu) { //dansu=변수 다른것으로 설정가능
		for(int i =1; i<=9; i++) {
			System.out.println(dansu +"*"+i+"="+ dansu*i);
			System.out.printf("%d X %d = %d\n", dansu, i ,dansu*i );
		}
	}
}
