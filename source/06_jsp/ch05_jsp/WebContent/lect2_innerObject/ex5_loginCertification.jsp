<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex5.css" rel="stylesheet">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8"); // 한글 필요 할 경우
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if (id==null || !id.equals("aaa") || pw==null || !pw.equals("111")) {
			String msg = "아이디와 비밀번호를 확인하세요"; 
			msg = URLEncoder.encode(msg,"utf-8"); // 한글로 출력할 경우에 URL인코더를 해야함. (임포트도)
			response.sendRedirect("ex5_loginFrm.jsp?msg="+msg);
		}
	%>
	<h2>
		ID는 <%=id %> 이고<br> 비밀번호는 <%=pw %>입니다<br>
		어서옵쇼!
	</h2>
</body>
</html>