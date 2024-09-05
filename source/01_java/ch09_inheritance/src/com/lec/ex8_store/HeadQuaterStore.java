package com.lec.ex8_store;

//new HeadQuarterStore("본사") new Store1("1호점")
public class HeadQuaterStore {
	private String storeName;

	public HeadQuaterStore(String storeName) {
		super();
		this.storeName = storeName;
	}

	public void kimchi() {
		System.out.println("김치찌개 : 8,000원");
	}

	public void bude() {
		System.out.println("부대찌개 : 9,000원");
	}

	public void bibim() {
		System.out.println("비빔밤 : 9,000원");
	}

	public void sunde() {
		System.out.println("순대국 : 8,000원");
	}

	public void gongi() {
		System.out.println("공기밥 : 1,000원");
	}

	public String getStoreName() {
		return storeName;
	}

	@Override
	public String toString() {
		return "*" + storeName + "*";
	}
}
