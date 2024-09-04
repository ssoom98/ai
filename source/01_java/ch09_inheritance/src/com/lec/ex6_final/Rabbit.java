package com.lec.ex6_final;
// final을 변수앞: 변수 수정 불가
// final을 메소드앞: override 불가
// final을 class앞: 상속불가
public final class Rabbit extends Animal {
	@Override
	public void running() {
		speed += 30;
		System.out.println("토끼가 마구 뛰어요. 현재 속도 : " + speed);
	}
}
