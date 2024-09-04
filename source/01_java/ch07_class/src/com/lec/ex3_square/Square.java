package com.lec.ex3_square;

//Square s = new Square() : s의 side를 0 초기화;
//Square s = new Square(10) : s의 side 를 10으로 초기화;
public class Square {
	private int side;

	public Square() {
		System.out.println("매개변수 없는 생성자 함수 호출됨");
	}

	public Square(int side) {
		this.side = side;
		System.out.println("매개변수 있는 생성자 함수 호출됨");

	}

	public int area() {
		return side * side;
	}

	// setters&getters
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

}
