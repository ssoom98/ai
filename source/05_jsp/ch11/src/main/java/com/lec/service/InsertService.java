package com.lec.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// insert 로직 : 파라미터들 쫙 받아 dao 함수 호출
		System.out.println("insert 로직 수행함");
		request.setAttribute("insertResult", 1);
		
			
	}

}
