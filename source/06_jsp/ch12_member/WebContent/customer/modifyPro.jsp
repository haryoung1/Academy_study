<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/modifiy.css" rel="stylesheet" type="text/css">
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String cbirth = request.getParameter("cbirth");
		if(!cbirth.equals("")){
			dto.setCbirth(Date.valueOf(cbirth));
		}
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		String sessionPw = null;
		if(customer != null) {
			sessionPw = customer.getCpw();
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)) {
			// 현 비밀번호를 맞게 입력한 경우 정보 수정 진행
			if(dto.getCpw()==null) {
				// 새 비밀번호를 현 비밀번호로 
				dto.setCpw(oldPw);
			}
			CustomerDao mDao = CustomerDao.getInstance();
			int result = mDao.modifyCustomer(dto);
			if (result == CustomerDao.SUCCESS) {
				// 정보 수정성공
				session.setAttribute("customer", dto); // 수정 된 정보를 session 속성으로 수정
		%>	
			<script>
				alert('정보수정이 완료 되었습니다.');
				location.href = 'main.jsp';
			</script>
			<% }else { // 수정 실패 %>
			<script>
				alert('회원정보 수정이 실패 되었습니다');
				location.href = 'modify.jsp';
			</script>
		<%} %>
		<% }else {
			// 현 비밀번호를 틀리게 입력한 경우 정보수정 했던 페이지로 이동
		%>
		<script>
			alert('현 비밀번호가 바르지 않습니다. 확인하세요')
			history.back();
		</script>
	<%}%>
</body>
</html>