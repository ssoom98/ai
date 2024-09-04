package com.lec.ex5_super;
//super() : 부모 클래스의 생성자 함수
//super.intro () : 부모 클래스의 intro()
// private(name, character) public(intro(),getter&setter)
public class Baby extends Person {

	public Baby() {
		//super(); //부모 클래스의 매개변수 없는 생성자 함수. super()생략할 경우 super() 자동 실행
		System.out.println("매개변수 없는 Baby 생성자");
	}
	public Baby (String name, String character) {
		super(name,character); // 부모클래스의 매개변수 있는 생성자 함수. 반드시 메소드 첫번째 줄에 호출
		System.out.println("매개변수 있는 Baby 생성자");
	}
	@Override
	public void intro() {
		System.out.print("(◑ㅁ◐) 응애");
		super.intro(); //super.은 어디에 있어도 된다.
	}

}
