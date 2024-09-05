package com.lec.ex2;

public class TestMain {
	public static void main(String[] args) {
		SuperClass obj = new SuperClass() { // method2, method3 은 SuperClass것으로
			@Override
			public void method1() {
				System.out.println("익명 클래스의 method1");
				
			}
		};
		obj.method1();
		obj.method2();
		obj.method3();
		SuperClass obj1= new ChildClass();
		obj1.method1();
		obj1.method2();
		obj1.method3();
	}
}
