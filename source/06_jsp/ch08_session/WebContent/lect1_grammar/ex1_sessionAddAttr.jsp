<%@page import="com.lec.ex.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<<<<<<< HEAD
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
=======
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</head>
<body>
	<%
		// 세션에 데이터를 저장 = 세션에 속성을 추가
		session.setAttribute("sessionName", "sessionValue");
		session.setAttribute("sessionNum", 123);
		// session.setAttribute("sessionNum", new Integer(123));
<<<<<<< HEAD
		Member member = new Member ("aaa", "111", "강길동");
=======
		Member member = new Member ("aaa", "111", "홍길동");
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
		session.setAttribute("member", member);
		// jsp 파일에서는 session이 내장객체라서 바로 사용가능. 자바(서블릿)에서는 session을 사용 하려면 다음과 같이
		HttpSession session2 = request.getSession();
	%>
	<h2>session sessionName 속성 값 : <%=session.getAttribute("sessionName") %></h2>
	<h2>session sessionNum 속성 값 : <%=session.getAttribute("sessionNum") %></h2>
	<h2>session member 속성 값 : <%=session.getAttribute("member") %></h2>
	<hr>
	<h2>세션 ID : <%=session.getId() %></h2>
	<h2>세션의 유효시간 : <%=session.getMaxInactiveInterval() %></h2>
	<hr>
	<a href="ex1_sessionAddAttr.jsp">세션 데이터 추가</a><br>
	<a href="ex2_sessionGet.jsp">특정 세션 GET</a><br>
	<a href="ex3_sessionList.jsp">모든 세션 리스트</a><br>
	<a href="ex4_sessionRemove.jsp">세션 삭제(특정 세션이나 모든 세션 데이터)</a>
</body>
</html>