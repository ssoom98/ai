package com.lec.pra;

public class Pra {
	private String color;
	private int cc;
	private int speed;

	public Pra() {
	}

	public void park() {
		speed = 0;
		System.out.println(color + "색 주차하심. 현재 속도 :" + speed);
	}

	public void drive() {
		speed = 60;
		System.out.println(color + "색 차 드라이브함. 현재 속도 :" + speed);
	}

	public void race() {
		speed = 120;
		System.out.println(color + "색 차 드라이브함. 현재 속도 :" + speed);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
