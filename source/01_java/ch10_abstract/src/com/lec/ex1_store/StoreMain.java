package com.lec.ex1_store;

public class StoreMain {

	public static void main(String[] args) {
		HeadQuaterStore[] stores = {
				//new HeadQuaterStore("= = 본사 = ="), 
				new Store1("= = 주택가 1호점 = ="),
				new Store2("= = 대학가 2호점 = ="),
				new Store3("= = 증권가 3호점 = =") 
		};
		for (int idx = 0; idx < stores.length; idx++) {
			System.out.println(stores[idx]);
			stores[idx].kimchi();
			stores[idx].bude();
			stores[idx].bibim();
			stores[idx].sunde();
			stores[idx].gongi();
		}//일반 for
		// 일반 for문을 확장 for문으로 수정해보기
//		for(HeadQuaterStore store : stores) {
//			System.out.println(store);
//			store.kimchi();
//			store.bude();
//			store.bibim();
//			store.sunde();
//			store.gongi();
//		}// 확장 for문
//		HeadQuaterStore head = new HeadQuaterStore("= = 본사 = =");
//		Store1 st1 = new Store1("= = 주택가 1호점 = =");
//		Store2 st2 = new Store2("= = 대학가 2호점 = =");
//		Store3 st3 = new Store3("= = 증권가 3호점 = =");
//		HeadQuaterStore[] stores = {head, st1, st2, st3};

	}

}
