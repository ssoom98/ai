package com.lec.method;
//private= 접근제한 같은 파일에서만 사용가능 
//sum(1,10), sum(10) ##함수의 오버로딩## / evenOdd(10) / abs(-9)
public class Arithmetic {
	public static int abs(int value) { // value의 절대값을 return
		int result = (value>= 0) ? value : -value;
		return result;
	}
	
	public int sum(int from, int to) {// from 부터 to까지 누적합 return
		int sum = 0; // 누적변수
		for (int i = from; i <= to; i++) {
			sum += i;
		}
		return sum;
	}

	public int sum(int to) { // 1부터 to 까지 누적합 return
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i;
		}
		return result;

	}

	public String evenOdd(int value) {// value가 짝수인지 홀수인지를 return
		String result = value % 2 == 0 ? "짝수입니다" : "홀수입니다";
		return result;
//		if(value%2==0) {
//			return"짝수입니다";
//		}else {
//			return "홀수입니다";
//		}
	}

}
