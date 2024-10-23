package com.lec.lect;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
@WebListener

public class Ex4_Listener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent sce) {
		// 웹프로젝트가 메모리에 load되는 시점에 실행
		System.out.println("★★★ch04 프로젝트 구동★★★");
	}
	public void contextDestroyed(ServletContextEvent sce) {
		//웹 프로젝트가 메모리 해제되는 시점에 실행
		System.out.println("★★★ch04 프로젝트 종료★★★");
	}
}
	
