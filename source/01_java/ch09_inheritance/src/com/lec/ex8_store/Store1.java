package com.lec.ex8_store;

public class Store1 extends HeadQuaterStore {

	public Store1(String storeName) {
		super(storeName);

	}

	@Override
	public void bude() {
		System.out.println("부대찌개 : 8,000원");
	}

	@Override
	public void sunde() {
		System.out.println("순대국은 안 팔아요");
	}
	@Override
	public String toString() {
		return "★" + getStoreName()	+ "★";
	}
}
