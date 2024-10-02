package com.lec.EX;

import java.util.ArrayList;
import java.util.Scanner;

import com.lec.dao.PersonRepository;
import com.lec.dto.Person;

public class PersonMng {
	public static void main(String[] args) {
		PersonRepository repository = PersonRepository.getInstance();
		Scanner sc = new Scanner(System.in);
		String fn;
		ArrayList<String> jnames = repository.jnameList();
		do {
				System.out.print("1:입력||2:직업별출력||3:전체출력||그외:종료");
				fn = sc.next();
				switch (fn) {
				case "1": 
					System.out.println("입력할 이름은?");
					String pname = sc.next();
					System.out.println("직업명"+ jnames +"은?");
					String jname = sc.next();
					System.out.println("국어?");
					int kor = sc.nextInt();
					System.out.println("영어?");
					int eng = sc.nextInt();
					System.out.println("수학?");
					int mat = sc.nextInt();
					int result = repository.insertperson(pname, jname, kor, eng, mat);
					System.out.println(result == PersonRepository.SUCESS? "성공":"실패");
					break;
				case"2":
					System.out.print(jnames+"중 입력하세요");
					jname=sc.next();
					ArrayList<Person> person = repository.getPerson(jname);
					if(person.isEmpty()) {
						System.out.println(jname+"직업군에 등록된 사람이 없습니다");
					}else {
						for(Person p: person){
							System.out.println(p);
						}
					}
					
				
				break;
				case"3":
					person = repository.getPerson();
					if(person.isEmpty()) {
						System.out.println("등록된 사람이 없습니다");
					}else {
						for(Person p: person) {
							System.out.println(p);
						}
					}
				}
			}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
			System.out.println("bye");
		}
}