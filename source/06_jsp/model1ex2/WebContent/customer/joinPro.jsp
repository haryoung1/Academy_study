<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page" />
	<jsp:setProperty property="*" name="dto" />
	<%
		String cbirth = request.getParameter("cbirth");
	if (!cbirth.equals("")) {
		dto.setCbirth(Date.valueOf(cbirth));
	}
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.confirmId(dto.getCid());
	if (result == CustomerDao.CUSTOMER_NONEXISTENT) {
		// 중복된 아이디 없어서 회원가입 가능
		result = cDao.joinCustomer(dto);
		if (result == CustomerDao.SUCCESS) {
			// 가입 성공
			session.setAttribute("cid", dto.getCid());
	%>
	<script>
		alert('회원가입 감사합니다');
		location.href = 'loginForm.jsp'
	</script>
	<%
		} else {
	// 회원가입 실패
	%>
	<script>
		alert('회원가입 실패, 길이 제한이 있습니다')
		history.back();
	</script>
	<%
		}
	} else {
	// 중복된 id라서 join으로
	%>
	<script>
		alert('중복된 ID입니다. 다른 아이디를 사용하세요');
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>