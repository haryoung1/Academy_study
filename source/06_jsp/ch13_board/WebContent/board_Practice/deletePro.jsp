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
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String pw = request.getParameter("pw");
		BoardDao2 bDao = BoardDao2.getInstance();
		int result = bDao.deleteBoard(num, pw);
		if(result == BoardDao2.SUCCESS) {
	%>
		<script>
			alert('<%=num%>번 글 삭제완료');
			location.href = '<%=conPath%>/board_Practice/list.jsp';
		</script>
	<%}else{ %>
		<script>
			alert('<%=num%>번 글 삭제 실패(비번 틀림)');
			histroy.back();
		</script>	
	<%} %>
</body>
</html>