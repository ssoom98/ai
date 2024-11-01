package com.lec.person.service;

import java.sql.Date;

import com.lec.person.dao.PersonRepository;
import com.lec.person.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateService implements Service {

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) {
		// id, name, tel, address, birth, memo 파라미터 받아 update
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		//Date birth = Date.valueOf(request.getParameter("birth"));
		Date birth =null;
		if(!birthStr.equals("")) {
				birth = Date.valueOf(birthStr);
		}
		String memo = request.getParameter("memo");
		PersonRepository dao = PersonRepository.getInstance();
		Person person = new Person(id, name, tel, address, birth, memo, null); // 수정할 내용
		int updateResult = dao.updatePerson(person);
		System.out.println(updateResult==PersonRepository.SUCCESS? "수정성공": "수정실패");
	}

}
