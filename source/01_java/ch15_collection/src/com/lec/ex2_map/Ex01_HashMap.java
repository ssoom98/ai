package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(11,"str11"); // key11에 데이터 "str11"추가
		hashmap.put(12,"str12");
		hashmap.put(22,"str33");
		hashmap.put(20,"str20");
		System.out.println(11 + "key값의 데이터 : "+ hashmap.get(11));
		System.out.println(10 + "key값의 데이터(없으면 null) : "+ hashmap.get(10));
		System.out.println(hashmap);
		hashmap.remove(12); //remove시 key값으로 : 12key값의 데이터 제거
		System.out.println("12remove후 : "+ hashmap);
		hashmap.clear();// hashmap의 모든 데이터 제거
		System.out.println(hashmap.isEmpty()? "데이터 없음" : "데이터 있음");
		//출력
		hashmap.put(0, "Hong gildong");
		hashmap.put(10, "Kim dongil");
		hashmap.put(22, "Lee soonsin");
		hashmap.put(40, "Shin gildong");
		Iterator<Integer> iterator = hashmap.keySet().iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "의 데이터는 "+ hashmap.get(key));
		}
	}
}
