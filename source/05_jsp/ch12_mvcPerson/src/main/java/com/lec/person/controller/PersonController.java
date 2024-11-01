package com.lec.person.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.lec.person.service.DeleteService;
import com.lec.person.service.InfoService;
import com.lec.person.service.InsertService;
import com.lec.person.service.ListService;
import com.lec.person.service.Service;
import com.lec.person.service.UpdateService;
import com.lec.person.service.UpdateService2;

@WebServlet("*.do")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		Service service = null; // 비즈니스 로직이 들어갈 공통 함수 포함
		String viewPage = null;
		if (command.equals("/list.do")) {
			service = new ListService();
			service.execute(response, request);
			viewPage = "person/list.jsp";
		} else if (command.equals("/info.do")) {
			service = new InfoService();
			service.execute(response, request);
			viewPage = "person/info.jsp";

		} else if (command.equals("/insert.do")) {
			viewPage = "person/insert.jsp";
		} else if (command.equals("/delete.do")) {
			service = new DeleteService();
			service.execute(response, request);
			viewPage = "list.do";
		} else if (command.equals("/update.do")) {
			service = new InfoService();
			service.execute(response, request);
			viewPage = "person/update.jsp"; // person내용이 input의 value값
		} else if (command.equals("/update2.do")) {
			service = new InfoService();
			service.execute(response, request);
			viewPage = "person/update2.jsp";// person내용이 input의 placeholder

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		Service service = null; // 비즈니스 로직이 들어갈 공통 함수 포함
		String viewPage = null;
		if (command.equals("/list.do")) {
			service = new ListService();
			service.execute(response, request);
			viewPage = "person/list.jsp";
		
		} else if (command.equals("/insert.do")) {
			service = new InsertService();
			service.execute(response, request);
			viewPage = "list.do";
		
		} else if (command.equals("/update.do")) {
			service = new UpdateService();
			service.execute(response, request);
			viewPage = "info.do";

		} else if (command.equals("/info.do")) {
			service = new InfoService();
			service.execute(response, request);
			viewPage = "person/info.jsp";

		} else if (command.equals("/update2.do")) {
			service = new UpdateService2();
			service.execute(response, request);
			viewPage = "info.do";

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
