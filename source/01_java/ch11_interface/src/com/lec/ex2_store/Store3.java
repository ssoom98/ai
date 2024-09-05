package com.lec.ex2_store;

public class Store3 implements HeadQuaterStore {
	private String storeName;

	public Store3(String storeName) {
		this.storeName = storeName;

	}

	@Override
	public void bude() {
		System.out.println("부대찌개 8,000원");
	}

	@Override
	public void sunde() {
		System.out.println("얼큰 순대국 10,000");
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 8,000원");
	}

	@Override
	public void bibim() {
		System.out.println("비빔밥 9,000원");
	}

	@Override
	public void gongi() {
		System.out.println("공기밥 1,000원");
	}

	@Override
	public String toString() {
		return "★" + storeName + "★";
	}

}
