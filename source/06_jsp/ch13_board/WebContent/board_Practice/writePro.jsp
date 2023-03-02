<%@page import="com.lec.dao2.BoardDao2"%>
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
	<jsp:useBean id="dto" class="com.lec.dto2.BoardDto2" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	
	<%
		dto.setIp(request.getRemoteAddr()); // 클라이언트가 요청한 컴퓨터의 IP
		BoardDao2 bDao = BoardDao2.getInstance();
		int result = bDao.insertBoard(dto);
		if (result == BoardDao2.SUCCESS) {
	%>
		<script>
			alert("글쓰기 성공");
			location.href ='<%=conPath%>/board_Practice/list.jsp';
		</script>
	
	<%}else {%>
		<script>
			alert("글쓰기 실패(너무길어요)");
			history.back();
		</script>
	<%} %>	
</body>
</html>