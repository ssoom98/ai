package com.lec.person.service;

import java.sql.Date;

import com.lec.person.dao.PersonRepository;
import com.lec.person.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertService implements Service {

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) {
		// name.tel, address,birth,memo 파라미터 받아 insert 결과를 request에 setattribute
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		Date birth = null;
		if(! birthStr.equals("")) {
			birth = Date.valueOf(birthStr);
			
		}
		String memo = request.getParameter("memo");
		Person newPerson= new Person(0, name, tel, address, birth, memo, null);
		PersonRepository dao = PersonRepository.getInstance();
		int insertResult = dao.insertperson(newPerson);
		//request.setAttribute("insertResult", insertResult); //1방법
		if(insertResult == PersonRepository.SUCCESS) {
			request.setAttribute("insertMsg","성공");
		}else{
			request.setAttribute("insertMsg","실패");
		}
		System.out.println(insertResult);

	}

}
