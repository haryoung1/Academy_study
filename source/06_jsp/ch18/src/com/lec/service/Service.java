package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	// HttpServletRequest : FrontController.java 에 있는
	public void execute(HttpServletRequest request, HttpServletResponse response); // 얘는 추상 메소드

	
}
