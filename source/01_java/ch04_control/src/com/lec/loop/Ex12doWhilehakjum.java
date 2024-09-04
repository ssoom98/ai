package com.lec.loop;
import java.util.Scanner;
// 점수(0~100점)를 입력받아 학점 출력
public class Ex12doWhilehakjum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score;
		do{
			System.out.print("점수는?");
			score = scanner.nextInt();
			if( 90 <= score && score <= 100 ) {
				System.out.println("A학점");
			}else if( 80 <= score && score < 90) {
				System.out.println("B학점");
			}else if( 70 <= score && score < 80) {
				System.out.println("C학점");
			}else if( 60 <= score && score < 70) {
				System.out.println("D학점");
			}else if( 0 <= score && score < 60) {
				System.out.println("F학점"); 
			}//else {
				//System.out.println("떼끼");
			//}
		}while (score>100 ||score<0);
		scanner.close();
	}
}





