package com.lec.conditionQuiz;

import java.util.Scanner;

//(Quiz 3) 가위바위보 중 하나를 내고(scanner.nextInt()사용) 낸 것을 출력하세요. 
//단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고,
//보를 선택하고자 할 때는 2를 입력하여 합니다.
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in) ;
		System.out.print("가위(0)바위(1)보(2)->");
		int rsp = scanner.nextInt();
	
		String rspStr = (rsp == 0) ? "가위" : (rsp == 1) ? "바위" :(rsp == 1)? "보":"유효하지 않은 값"; //삼항연산자
		
//		if(rsp==0) {
//			rspStr ="가위";
//		}else if(rsp==1) {
//			rspStr ="바위";
//		}else if(rsp==2){
//			rspStr ="보";
//		}else {
//			rspStr="유효하지않습니다";
//		} //if문
		System.out.println(rspStr);
		scanner.close();
	}
}
