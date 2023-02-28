<%@page import="java.sql.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name 			 = request.getParameter("name");
	String id 				 = request.getParameter("id");
	String pw 				 = request.getParameter("pw");
	String birth 			 = request.getParameter("birth");
	//Date birthDate 			 = Date.valueOf(birth);
	//Timestamp birthTimestamp = Timestamp.valueOf(birth + " 00:00:00");
	Date birthDate = null;
	Timestamp birthTimestamp = null;
	if(birth!=null && !birth.equals("")) {
		birthDate = Date.valueOf(birth);
		birthTimestamp = Timestamp.valueOf(birth + "00:00:00");
	}
	String[] hobby 			 = request.getParameterValues("hobby");
	String gender 			 = request.getParameter("gender");
	String email 			 = request.getParameter("email");
	String[] mailSend 		 = request.getParameterValues("mailSend");
	// 받은 파라미터 값을 Member DB에 저장 : SELECT * FROM MEMBER WHERE ID = '?' AND
%>
	<script>
		alert('<%=name%>님 회원가입 완료 되었습니다. 감사합니다');
		location.href = '<%=conPath%>/member/login.jsp';
	</script>
</body>
</html>