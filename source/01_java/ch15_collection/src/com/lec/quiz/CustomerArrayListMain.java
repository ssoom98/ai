package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerArrayListMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Scanner scanner = new Scanner(System.in);
		String answer=null, name, tel, address;
		while(true) {
			System.out.print("회원가입 진행하시겠습니까 (Y/N)?");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("y")) {
				Customer newCustomer = new Customer();
				System.out.print("이름은?");
				newCustomer.setName(scanner.next());
				System.out.print("전화 ?");
				newCustomer.setTel(scanner.next());
				scanner.nextLine(); // 버퍼 지우기
				System.out.print("주소?");
				newCustomer.setAddress(scanner.nextLine());
				customers.add(newCustomer);
//				System.out.print("이름은?");
//				name = scanner.next();
//				System.out.print("전화?");
//				tel = scanner.next();
//				System.out.print("주소?");
//				scanner.nextLine(); // 버퍼 지우기
//				address = scanner.nextLine();
//				customers.add(new Customer(name, tel, address));
			}else if(answer.equalsIgnoreCase("n")) {
				break;
			}
		}
		scanner.close();
		// N(n)을 입력할 경우 회원정보 출력
//		if(customers.isEmpty()) {
		if(customers.size()==0) {
			System.out.println("가입한 회원 목록이 없습니다");
		}else {
			System.out.println("가입한 회원 목록입니다");
			for(Customer customer : customers) {
				System.out.println(customer);
			}//for
		}//if
	}//main
}