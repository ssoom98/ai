package com.lec.quiz;

// 이름 번호 주소 
public class Customer {
	private String name;
	private String tel;
	private String address;
	
	public Customer() {}
	public Customer(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + address;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
