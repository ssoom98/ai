package com.lec.person.service;

import java.sql.Date;

import com.lec.person.dao.PersonRepository;
import com.lec.person.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateService2 implements Service {

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) {
		// id,name,tel,address,birth,memo 중 빈스트링이 아닌 값만 수정
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		Date birth = null;
		if(!birthStr.equals("")) {
			birth = Date.valueOf(birthStr);
		}
		String memo = request.getParameter("memo");
		//id로 person정보 가져옴 => 빈스트링파라미터가 아닌 값만 person에 setter로 값을 수정 => update
		PersonRepository dao = PersonRepository.getInstance();
		Person person= dao.getPerson(id); //수정전 person정보
		if(!name.equals("")) {
			person.setName(name);
		}
		if(!tel.equals("")) {
			person.setTel(tel);
		}
		if(!address.equals("")) {
			person.setAddress(address);
		}
		person.setBirth(birth);
		if(!memo.equals("")) {
			person.setMemo(memo);
		}
		// if문 후에는 person에 수정할 정보가 담김
		int result = dao.updatePerson(person);
		System.out.println(result==PersonRepository.SUCCESS? "수정성공": "수정실패");
	}	

}
