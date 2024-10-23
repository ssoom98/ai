package com.lec.quiz;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Quiz2")
public class Quiz2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number= Integer.parseInt(request.getParameter("number"));
		int sum = 0;
		for(int i=1; i<=number; i++) {
			sum += i;
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String msg= String.format("<h2> 1부터 %d까지 누적한 합은 %d입니다</h2>",number,sum);
		out.println(msg);
		out.close();
	}

	
}
