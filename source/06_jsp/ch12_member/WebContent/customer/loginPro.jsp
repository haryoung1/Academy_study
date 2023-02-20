<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
		String msg = "";
		request.setCharacterEncoding("utf-8");
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		String method = request.getParameter("method"); // null 또는 "modify"
		CustomerDao mDao = CustomerDao.getInstance();
		int result = mDao.loginCheck(cid, cpw);
		if (result == CustomerDao.LOGIN_SUCCESS) { // 로그인 성공
			CustomerDto customer = mDao.getCustomer(cid);
			session.setAttribute("customer", customer);
			if(method.equals("null")) {
			response.sendRedirect("main.jsp");
			}else {
				response.sendRedirect(method + ".jsp");
			}
			
		}else if (result == CustomerDao.LOGIN_FAIL) { 
	%>	
		<script>
			alert('아이디 또는 비밀번호를 확인하세요.');
			history.go(-1); // 입력하던 정보 그대로 냄겨두기 (바로 뒤로)
		</script>
		
	<% }%>

</body>
</html>