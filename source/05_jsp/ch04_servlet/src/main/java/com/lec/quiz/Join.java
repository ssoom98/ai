package com.lec.quiz;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.tribes.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String [] id = req.getParameterValues("id");
		String [] pw=req.getParameterValues("pw");
		String [] pwChk=req.getParameterValues("pwChk");
		String [] birth=req.getParameterValues("birth");
		String [] hobby=req.getParameterValues("hobby");
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
		String mailSend=req.getParameter("mailSend");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println(Arrays.toString(id));
		out.println(Arrays.toString(pw));
		out.println(Arrays.toString(birth));
		out.println(Arrays.toString(hobby));
		out.println(gender);
		out.println(email);
		out.println(mailSend);
	}
}
