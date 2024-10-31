package com.lec.person.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
	private int id;
	private String name;
	private String tel;
	private String address;
	private Date birth;
	private String memo;
	private Timestamp rdate;
}
