package com.lec.method;
//같은 패키지에 있을때 실행하는 매서드를 사용하는 방법
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("-9의 절대값 : " + Arithmetic.abs(-9));
		Arithmetic ar = new Arithmetic();
		int tot = ar.sum(10,100);
		System.out.println("합은"+ tot);
		System.out.println(ar.evenOdd(tot));
		
	}
}
