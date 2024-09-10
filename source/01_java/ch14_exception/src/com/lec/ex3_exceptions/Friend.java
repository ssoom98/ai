package com.lec.ex3_exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

// 데이터 : 이름, 전화번호, 생년월일(Date) 
//Friend f = new Friend("홍길동","010-9999-9999", new Date(98,8,10))
// sysout(f) =>[이름] 홍길* [전화] ***-****-9999 [생일]9월 10일 ♬ 생일축하 ♬
public class Friend {
	private String name;
	private String tel;
	private Date birthday;

	public Friend(String name) {
		this.name = name;
	}

	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	public Friend(String name, String tel, Date birthday) {
		super();
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		String result = "";
		String nameOut = name.substring(0, name.length() - 1) + "*";
		result += "[이름]" + nameOut;
			if(tel!= null) {
				String telOut = tel.substring(tel.lastIndexOf("-") + 1);
				result += "\n[전화]***-****-" + telOut;
			}
			if(birthday!=null) {
				SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일");
				String birthOut = sdf.format(birthday);
				result += "\n[생일]" + birthOut;
				// 오늘이 생일인지 아닌지 
				String today = sdf.format(new Date()); // "9월10일"
				if(today.equals(birthOut)) {
					result += "\n♬ 생일축하 \n";
			}
		}
		return result;
	}
}
