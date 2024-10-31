package com.lec.person.service;

import com.lec.person.dao.PersonRepository;
import com.lec.person.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteService implements Service {

	@Override
	public void execute(HttpServletResponse response, HttpServletRequest request) {
		//id 파라미터 받아 dao를 통해 delete하고 결과를 request에 setAttribute
		int id = Integer.parseInt(request.getParameter("id"));
		PersonRepository dao = PersonRepository.getInstance();
		Person person = dao.getPerson(id);
		int deleteResult = dao.deletePerson(id);
		String deleteMsg =deleteResult==PersonRepository.SUCCESS? person.getName()+"삭제 성공" : person.getName()+"삭제실패";
		request.setAttribute("deleteMsg", deleteMsg);

	}

}
