<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
	<%
		Date now = new Date();
		String str = String.format("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초 입니다",now);
		GregorianCalendar now2 = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일은 무슨날 ?");
		String str2 = sdf.format(now2.getTime());
	%>
	<p>str1 : <%=str %></p>
	<p>str2 : <%=str2 %></p>
	<hr>
	<%@ include file="1_hello.jsp" %> <!-- 지시자 명령어 -->
=======
	<% // 스크립트릿 : JAVA 코드
		Date now = new Date();
		String str = String.format("%1$TY년 %1$Tm월  %1$Td일 %1$TH시 %1$TM분 %1$TS초입니다", now);
		GregorianCalendar now2 = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일은 좋은날");
		String str2 = sdf.format(now2.getTime());
	%>
	<p>str1 :  <%=str %></p> <!-- %= 표현식  : 결과값 출력 -->
	<p>str2 : <%=str2 %></p>
	<hr>
	<%@ include file="1_hello.jsp" %>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>