package com.lec.ex4_acccount;

// 데이터(인스턴스변수), : accountNo(String), ownerName(String), balance(long)
// 생성자 new Account("010-777-77", "홍길동"),new Account("010-777-77", "홍길동",100)
// 기능(Method) :deposit(예금), withdraw(인출), infoPrint(정보출력), infoString(정보문자열 반환)
public class Account {
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주
	private long balance; // 예금잔액

	// 생성자 없으면 JVM이 디폴트 생성자 함수 자동 생성
	// public Account() {} // 디폴트 생성자 함수
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	public Account(String accountNO, String ownName, long balance) {
		this.accountNo = accountNO;
		this.ownerName = ownName;
		this.balance = balance;
	}

	public void deposite(long money) { // 무조건 예금하기
		// balance = balance + money;
		balance += money;
		System.out.println(money + "원 예금하여 잔액 :" + balance);
	}

	public void withdraw(long money) { // 잔액이 있을 경우만 인출하기
		if (money <= balance) {
			balance -= money;
			System.out.println(money + "원 인출하여 잔액:" + balance);
		} else {
			System.out.println("잔액이 부족하여 인출 불가합니다");
		}
	} // withdraw

	public void infoPrint() {
		// 100-1 "홍길동"님 잔액 : 100원 을 출력
		// System.out.println(accountNo + " \"" + ownerName + "\"님 잔액 : " + balance +
		// "원");
		System.out.printf("%s \"%s\"님 잔액 : %d\n", accountNo, ownerName, balance);
	}

	public String infoString() {
		// 100-1 "홍길동"님 잔액 : 100원 을 return
		// return accountNo +"\"" + ownerName+ "\"님 잔액 : " + balance ;
		return String.format("%s \"%s\"님 잔액 : %d\n", accountNo, ownerName, balance);

	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
