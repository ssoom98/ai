package com.lec.ex4_Object;
//Person p1 = new Person()
//Person p2 = new Person(9812121021452L)
//p1.equals(p2) => true
// sysout(p1) => 주민번호는 98121221021452입니다
public class Person {
	private long juminNo;
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "주민번호는" + juminNo;
	}
	@Override
	public boolean equals(Object obj) {
		//p1.equals(p2) p1.juminNo와 p2의 juminNo 비교결과 return
		//p1 this, p2는 obj => juminNo와 obj.juminNo 비교
		if(obj!=null && obj instanceof Person) {
			Person other = (Person)obj;
			boolean juminNoChk= juminNo == other.juminNo;
			return juminNoChk;
		}
		return false;
	}
}
