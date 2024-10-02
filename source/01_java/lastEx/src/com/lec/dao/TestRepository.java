package com.lec.dao;

import java.util.ArrayList;

import com.lec.dto.Person;

public class TestRepository {
	public static void main(String[] args) {
		PersonRepository repository = PersonRepository.getInstance();
		System.out.println("0. jnames 들 가져오기 테스트");
		ArrayList<String> jnames = repository.jnameList();
		System.out.println(jnames);
		System.out.println("1번 기능 테스트");
		int result = repository.insertperson("신길동", "가수", 70, 80, 90);
		System.out.println(result==1? "성공":"실패");
		System.out.println("2번 기능 테스트");
		ArrayList<Person> person = repository.getPerson("배우");
		for(Person p : person) {
			System.out.println(p);
		}
		System.out.println("3번 기능 테스트");
		person = repository.getPerson();
		for(Person p : person) {
			System.out.println(p);
		}
		
	}
}
