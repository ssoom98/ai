package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Scanner;

import com.lec.ex1_list.Friend;

public class Ex03_FriendHashMapTelSearch {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("010-9999-9999", new Friend("홍길동","010-9999-9999"));
		friends.put("010-9888-9999", new Friend("김길동","010-9888-9999"));
		friends.put("010-8888-8888", new Friend("신길동","010-8888-8888"));
		friends.put("010-7777-7777", new Friend("김수동","010-7777-7777"));
		friends.put("010-6666-6666", new Friend("박길동","010-6666-6666"));
		Scanner scanner = new Scanner(System.in);
		//String searchTel= null;
		while(true){//(!searchTel.equalsIgnoreCase("x")) {
			System.out.print("검색하고자하는 전화번호는(단 종료는 X)? ");
			String searchTel = scanner.next();
			if(searchTel.equalsIgnoreCase("X")) break;
			Friend searchFriend = friends.get(searchTel);
			if(searchFriend == null) {
				System.out.println("검색되지 않는 전화번호입니다");
			}else {
				System.out.println("검색한 정보는 " + searchFriend);
			}
		}
		scanner.close();
	}
}
