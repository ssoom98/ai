package com.lec.servlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.lec.dao.EmpDao;
import com.lec.dto.Emp;
@WebServlet("/empSch")
public class EmpSch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// schName과 schJob 파라미터 받아서,
		String schName = request.getParameter("schName");
		String schJob = request.getParameter("schJob");
		// dao.getEmpList(schName, schJob)의 결과를 request에 setAttribute
		// jsp로 forward (empSch.jsp)
		EmpDao empDao = EmpDao.getInstance();
		ArrayList<Emp> empList = empDao.getEmpList(schName, schJob);
		// 뷰단에 출력할 내용은 request에 setAttribute
		request.setAttribute("empList", empList);
		// jsp페이지로 forwrad
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_emp/empSch.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}