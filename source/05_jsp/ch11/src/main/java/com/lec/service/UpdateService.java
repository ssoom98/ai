package com.lec.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// update 로직 수행 후  수행결과 request 
		System.out.println("파라미터들 받아 dao 함수 호출 후  결과를 request에 set");
		request.setAttribute("updateResult", 1);
		

	}

}
