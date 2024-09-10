package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[2];
		array[0] = "str0"; array[1] = "str1"; //array[2] = "str2";
		System.out.println(Arrays.toString(array));
		for(String arr : array) {
			System.out.print(arr + "\t");
		}
		for(int idx=0 ; idx<array.length ; idx++) {
			System.out.print(array[idx] + "\t");
		}
		System.out.println("\n--------------ArrayList----------------");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0");// 0번인덱스
		arrayList.add("str1");// 1번인덱스
		arrayList.add("str2");// 2번인덱스
		arrayList.set(1, "s t r 1");//1번 인덱스 값 수정
		arrayList.add("str3");// 3번인덱스
		System.out.println(arrayList);
		System.out.println("현재 arrayList 사이즈 : " + arrayList.size());
		for(String arr : arrayList) {
			System.out.println(arr + "\t");
		}
		for(int idx = 0; idx<arrayList.size(); idx++) {
			System.out.println(idx + "번째 : " + arrayList.get(idx));
		}
		arrayList.remove(1);// 1번 인덱스 값 제거(2번인덱스-> 1번인덱스, 3번 인덱스 -> 2번인덱스)
		System.out.println(arrayList);
		arrayList.remove(arrayList.size()-1); // 맨 마지막 인덱스 값 제거
		System.out.println(arrayList);
		System.out.println(arrayList.isEmpty()? "arrayList데이터가 없음" : "데이터 있음");
		arrayList.clear();// arrayList의 모든 데이터 제거
		System.out.println(arrayList);
		System.out.println(arrayList.isEmpty()? "arrayList데이터가 없음" : "데이터 있음");
		System.out.println(arrayList.size());
	}
}
