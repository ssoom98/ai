package com.lec.ex4_Object;

public class CardMain {
	public static void main(String[] args) {
		 Card c1 = new Card("다이아몬드",7);
		 Card c2 = new Card("다이아몬드",7);
		 System.out.println(c1.equals(c2)? "c1과 c2는 같은 카드" : "c1과 c2는 다른 카드");
		 System.out.println(c1==c2 ? "c1과 c2는 같은 주소" : "c1과 c2는 다른 주소");
		 System.out.println(c1);
		 System.out.println(c2);
	}
}
