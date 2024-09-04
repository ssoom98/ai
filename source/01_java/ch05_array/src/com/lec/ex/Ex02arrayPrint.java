package com.lec.ex;

public class Ex02arrayPrint {
	public static void main(String[] args) {
		int[] arr = { 0, 0, 0 };
		// 확장 for. 배열 출력
		for(int X : arr) {
			System.out.println(X);
		}
		//일반 for문을 이용한 배열값 변경
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = 99;
		}
		System.out.println("일반 for문을 이용한 배열값 변경" );
		for(int X : arr) {
			System.out.println(X);
		}
		// 확장 for 문을 이용한 배열값 변경(변경하려면 일반 for문으로 써야한다.)
		for(int temp : arr) {
			temp = 55;
		}
		System.out.println("확장 for문을 이용한 배열값 변경은 무효 임시변수만 바꿔줌" );
		for(int X : arr) {
			System.out.println(X);
		}	
	}
}
