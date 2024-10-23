package com.lec.lect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import org.apache.catalina.tribes.util.Arrays;
@WebServlet("/ex2")


/**
 * Servlet implementation class Ex2Params
 */
public class Ex2Params extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()호출");
		actionDo(request,response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			// 복수개의 menu, rest파라미터, 1개의 gender
			String gender =request.getParameter("gender");// 같은 이름의 파라미터가 없을 때
			String[] menu= request.getParameterValues("menu");//같은이름의 파라미터가 전달될때
			String[] rest= request.getParameterValues("rest"); // 
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out =response.getWriter(); //스트림생성
			if(menu!=null) {
				out.println("<h2>선택한 메뉴는 ");
				for(String m : menu) {
					out.println(m +" ");
				}
				out.println("입니다</h2>");
			}else {
				out.println("<h2>선택한 메뉴가 없습니다</h2>");
			}
			//out.println("<h2>선택한 메뉴는"+ Arrays.toString(menu)+"입니다</h2>");
			out.println("<h2>선택한 식당은"+ Arrays.toString(rest)+"입니다</h2>");
			String genderOut = gender==null? "-" : gender.equals("f")? "여자": gender.equals("m")? "남자":"-";
			out.println("<h2>성별은"+ genderOut +"입니다</h2>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()호출");
		doGet(request, response);
	}
}
