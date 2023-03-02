<%@page import="com.lec.dao.BoardDao2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto2" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setIp(request.getRemoteAddr());
		BoardDao2 bDao = BoardDao2.getInstance();
		int result = bDao.insertBoard(dto);
		if (result == BoardDao2.SUCCESS) {
	%>
		<script>
			alert('글쓰기 완료');
			location.href = '<%=conPath%>/board2/list.jsp';
		</script>
	<%}else{ %>
		<script>
			alert('글쓰기 실패(길어)');
			history.back();
		</script>
	<%} %>
</body>
</html>