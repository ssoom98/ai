package com.lec.ex1_store;
//HeadQuarterStore를 상속 받은 측에서 반드시 override 하도록

public abstract class HeadQuaterStore {
	private String storeName;

	public HeadQuaterStore(String storeName) {
		super();
		this.storeName = storeName;
	}

	// 추상메소드 : 메소드 선언만 있고, 구현은 없는 메소드(구현은 상속 받은 측에서)
	public abstract void kimchi();

	public abstract void bude();

	public abstract void bibim();

	public abstract void sunde();

	public abstract void gongi();

	public String getStoreName() {
		return storeName;
	}

	@Override
	public String toString() {
		return "*" + storeName + "*";
	}
}
