package com.lec.ex;

import com.lec.method.Arithmetic;

//다른 패키지에 있을때 실행하는 매서드를 사용하는 방법
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("-9의 절대값 : " + Arithmetic.abs(-9));
		Arithmetic ar = new Arithmetic();// 만든 변수= 객체
		int tot = ar.sum(100);
		System.out.println("합은" + tot);
		System.out.println(ar.evenOdd(tot));

	}
}
