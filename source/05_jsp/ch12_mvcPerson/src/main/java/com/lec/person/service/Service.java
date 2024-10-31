package com.lec.person.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Service {
	public void execute(HttpServletResponse response,
			HttpServletRequest request);
}
