package com.lec.ex5_super;

// super() : 부모 클래스의 생성자 함수
// super.~: 부모 클래스의 
public class Person {
	private String name;
	private String character;

	public Person() {
		System.out.println("매개변수 없는 Person 생성자 함수");
	}

	public Person(String name, String character) {
		System.out.println("매개변수 있는 Person 생성자 함수");
		this.name = name;
		this.character = character;
	}

	public void intro() {
		System.out.println("★" + name + "은" + character);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
	
}
