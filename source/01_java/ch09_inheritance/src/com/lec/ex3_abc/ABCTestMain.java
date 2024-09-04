package com.lec.ex3_abc;
// 시간을 아끼기 위해 상속사용 사용시 protected
public class ABCTestMain {
	public static void main(String[] args) {
		S sobj = new S(); // 생성자 1개 실행
		// A aobj = new A(); // 생성자 2개 실행 (S->A)
		S aobj = new A(); // 생성자 2개 실행 (S->A)
		B bobj = new B(); // 생성자 2개 실행 (S->B)
		C cobj = new C(); // 생성자 2개 실행 (S->C)
		S[] arr = { sobj, aobj, bobj, cobj, new A() };
		for(S temp : arr) {
			System.out.println(temp.s);
		}
	}
}
