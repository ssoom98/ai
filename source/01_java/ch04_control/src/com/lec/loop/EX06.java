package com.lec.loop;
// 반복(loop)문을 작성 할때는 무한 loop에 빠지지 않도록 주의
public class EX06 {

	public static void main(String[] args) {
//		int i =10;
//		if(i>5) {
//			System.out.println("5보다 크네");
//			System.out.println("1111111");
//		}
		for(int i=1 ; ; i++) {
			System.out.println(i+",안녕");
			if(i==10) break;
		}
		System.out.println();
	}
}
