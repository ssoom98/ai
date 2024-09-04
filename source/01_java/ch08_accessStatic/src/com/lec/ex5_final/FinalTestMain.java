package com.lec.ex5_final;

import constant.Constant;

// 변수 앞에 final : final 변수 = 수정 불가
public class FinalTestMain {
	public static void main(String[] args) {
		//final double PI = 3.141592;
		double r = 3;
		r = 5;
		//PI =3.1415926535; = final로 인해서 수정불가
		double area = r*r*Constant.PI;
		System.out.println(area);
	}
}