package com.lec.ex8_store;

public class Store3 extends HeadQuaterStore {

	public Store3(String storeName) {
		super(storeName);

	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 9,000원");
	}

	@Override
	public void bude() {
		System.out.println("부대찌개 : 9,000원");

	}

	@Override
	public void bibim() {
		System.out.println("비빔밤 : 9,000원");

	}

	@Override
	public void sunde() {
		System.out.println("얼큰 순대국 : 9,000원");
	
	}
	@Override
	public String toString() {
		return "★" + getStoreName()	+ "★";
	}
	
}
