package com.lec.person.service;



import com.lec.person.dao.PersonRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListService implements Service {

	@Override
	public void execute(HttpServletResponse res, HttpServletRequest req) {
		PersonRepository dao = PersonRepository.getInstance();
		req.setAttribute("personList", dao.getPersonList());
	}

}
