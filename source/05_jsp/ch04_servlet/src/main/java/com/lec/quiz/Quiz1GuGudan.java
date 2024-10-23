package com.lec.quiz;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.print.PrinterAbortException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Quiz1GuGudan")
public class Quiz1GuGudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] su=request.getParameterValues("su");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(su!=null) {
			for(String s:su) {
				int gugu=Integer.parseInt(s);
				for(int i=1; i<=9; i++){
					out.printf("%d*%d=%d<br>",gugu,i,gugu*i);
					
				}
			}
		}else {
			out.println("<h2>선택된 단수가 없습니다</h2>");
		}
	}
	
	
}
