package com.lec.ex3_exceptions;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex02_FriendMain {
	public static void main(String[] args) {
		Friend friend1 = new Friend("홍길동", "010-9999-9999", new Date(new GregorianCalendar(1998, 8, 10).getTimeInMillis()));
		System.out.println(friend1.toString());
		Friend friend2 = new Friend("홍길동", "010-9999-9999", new Date(new GregorianCalendar(1998, 8, 18).getTimeInMillis()));
		System.out.println(friend2.toString());
		Friend friend3 = new Friend("깅길동");
		System.out.println(friend3.toString());
		Friend friend4 = new Friend("박길동", "010-7894-4564");
		System.out.println(friend4.toString());
	}
}
