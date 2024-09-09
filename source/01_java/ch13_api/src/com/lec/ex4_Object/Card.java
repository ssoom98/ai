package com.lec.ex4_Object;
// Card c1 = new card(◆,7)
// Card c2 = new card(◆,7)
// c1.equals(c2) => true
// sysout(c1) => 카드 다이아몬드 7입니다
public class Card {
	private String kind; // ♥ ◆ ♠ ♣
	private int num;
	public Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Card) {
			Card other = (Card)obj;
			boolean kindChk= kind.equals(other.kind);
			boolean numChk= num == other.num;
			return kindChk && numChk;
		}
		return false;
	}
	@Override
	public String toString() {
		return "카드는" + kind + "의" + num + "입니다";
	}
	
}
