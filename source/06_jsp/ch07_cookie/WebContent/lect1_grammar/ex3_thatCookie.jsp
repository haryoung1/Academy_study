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
	<h1>특정 쿠키(쿠키이름이 cookieName인 쿠키)의 값 확인</h1>
	<%
		Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		int idx;
		for (idx = 0; idx < cookies.length; idx++) {
			String ckName = cookies[idx].getName(); // idx번째 쿠키 이름
			if (ckName.equals("cookieName")) {
		String value = cookies[idx].getValue(); // 쿠키 값
		out.println("<h3>찾고자 하는 쿠키 이름 : " + ckName + ", 값 : " + value + "</h3>");
		break;
			} // if
		} // for
		if (idx == cookies.length) {
			out.println("<h3>찾고자 하는 쿠키가 없습니다</h3>");
		}
	} else {
		out.println("<h3>생성된 쿠키가 없습니다</h3>");
	}
	%>
	<hr>
	<a href="ex1_cookieConstruct.jsp">쿠키생성</a>
	<br>
	<a href="ex2_cookieList.jsp">쿠키 리스트</a>
	<br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(쿠키 이름이 cookieName) 찾기</a>
	<br>
	<a href="ex4_cookieDelete.jsp">특정 쿠키 지우기</a>
	<br>
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
	<h1>특정 쿠키(쿠키이름 : cookieName인 쿠키) 확인</h1>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			int idx;
			for(idx=0; idx<cookies.length; idx++) {
				String name = cookies[idx].getName(); // idx번째 쿠키 이름
				if(name.equals("cookieName")) {
					String value = cookies[idx].getValue(); // 쿠키 값
					out.println("<h3>찾고자 하는 쿠키 이름 : " + name + ", 값 : " + value + "</h3>");
					break;
				}//if
			}//for
			if(idx==cookies.length) {
				out.println("<h3>찾고자 하는 쿠키가 없음</h3>");
			}
		}else {
			out.println("<h3>생성된 쿠키가 없습니다..!</h3>");
		}
	%>
	<hr>
	<a href="ex1_cookieConstruct.jsp">쿠키 생성</a><br>
	<a href="ex2_cookieList.jsp">쿠키 리스트</a><br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(쿠키 이름이 cookieName)찾기</a><br>
	<a href="ex4_cookieDelete.jsp">특정 쿠키 지우기</a><br>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>