package com.lec.ex3_static;

public class MomTestMain {
	public static void main(String[] args) {
		//Child.method();
		//System.out.println(Child.mom.money);
		Child child1 = new Child("첫째 길동이");
		Child child2 = new Child("둘째 개똥이");
		Child child3 = new Child("셋째 둘순이");
		System.out.println("엄마 지갑 : "+ Child.mom.money);
		child1.takeMoney(1000);
		child2.takeMoney(1000);
		child3.takeMoney(1000);
		System.out.println("엄마 지갑 : "+ Child.mom.money);
		System.out.println("엄마 지갑 : "+ Child.mom.money);
		System.out.println("엄마 지갑 : "+ Child.mom.money);
	}
}