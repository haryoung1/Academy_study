<%@page import="com.lec.customer.CustomerDao"%>
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
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="page" />
	<jsp:setProperty property="*" name="dto" />
	<%
		String cbirth = request.getParameter("cbirth");
	if (!cbirth.equals("")) {
		dto.setCbirth(Date.valueOf(cbirth));
	}
	CustomerDao mDao = CustomerDao.getInstance();
	int result = mDao.confirmId(dto.getCid());
	if (result == CustomerDao.CUSTOMER_NONEEXISTENT) {
		// 사용가능한 ID라서 회원가입 진행
		result = mDao.joinCustmor(dto); // 회원가입
		if (result == CustomerDao.SUCCESS) {
			// 회원가입 성공
			session.setAttribute("cid", dto.getCid());
	%>
	<script>
		alert('회원가입 감사합니다 !')
		location.href = 'login.jsp';
	</script>
	<%
		} else {
	// 회원가입 실패
	%>
	<script>
		alert('회원가입이 실패 했습니다. 길이 제한이 있습니다');
		history.back();
		/* location.href = 'join.jsp';  */
	</script>
	<%
		}
	} else {
	// 중복된 ID라서 join.jsp로
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
