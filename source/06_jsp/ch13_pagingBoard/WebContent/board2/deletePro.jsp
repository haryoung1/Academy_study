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
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String pw = request.getParameter("pw");
		BoardDao2 bDao = BoardDao2.getInstance();
		int result = bDao.deleteBoard(num, pw);
		/* pageNum 추가 */
		String pageNum = request.getParameter("pageNum");
		if(result == BoardDao2.SUCCESS) {
	%>
		<script>
			alert('<%=num%>번 글 삭제 완료');
			location.href = '<%=conPath%>/board2/list.jsp?pageNum=<%=pageNum%>';
		</script>
	<%}else{ %>
		<script>
			alert('<%=num%>번 글 삭제 실패. 비밀번호를 확인하세요');
			history.back();
		</script>
	<%} %>
</body>
</html>