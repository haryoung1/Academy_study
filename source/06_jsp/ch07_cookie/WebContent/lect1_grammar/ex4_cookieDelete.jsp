<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>특정 쿠키(쿠키이름이 cooieName인 쿠키) 삭제하기</h1>
	<%
		// 같은 이름의 쿠키를 생성해서 유효시간을 0초로 세팅한 다음 덮어씌워 버리자
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie c : cookies) {
			String name = c.getName();
			if (name.equals("cookieName"));
			Cookie cookie = new Cookie("cookieName", "xxx");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			out.println("<h3>쿠키 삭제 성공</h3>");
			break;
		}
	}
	%>
	<hr>
	<a href="ex1_cookieConstruct.jsp">쿠키생성</a><br>
	<a href="ex2_cookieList.jsp">쿠키 리스트</a><br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(쿠키 이름이 cookieName) 찾기</a><br>
=======
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>특정 쿠키(쿠키이름이 cookieName인 쿠키) 삭제하기</h1>
	<% // 같은 이름의 쿠키를 생성해서 유효시간을 0초로 셋팅한 후, response에 탑재
	   // 0초짜리 같은 이름 쿠키를 덮어 씌운다.
	   Cookie[] cookies = request.getCookies();
	   if (cookies!=null) {
		   for(Cookie c : cookies) {
			   String name = c.getName();
			   if(name.equals("cookieName")) {
				   Cookie cookie = new Cookie("cookieName", "xx");
				   cookie.setMaxAge(0);
				   response.addCookie(cookie);
				   out.println("<h3>쿠키 삭제 성공</h3>");
				   break;
			   }
		   }// for
	   }// if
	%>
	<hr>
	<a href="ex1_cookieConstruct.jsp">쿠키 생성</a><br>
	<a href="ex2_cookieList.jsp">쿠키 리스트</a><br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(쿠키 이름이 cookieName)찾기</a><br>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
	<a href="ex4_cookieDelete.jsp">특정 쿠키 지우기</a><br>
</body>
</html>