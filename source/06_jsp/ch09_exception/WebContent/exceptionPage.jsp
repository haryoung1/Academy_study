<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이 페이지는 ex2.jsp(NullPointException, 0으로 나눌때 예외 - 500상태)에서 예외가 발생하면 오는 페이지 --%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<%--   http 에러
	200 : 정상상태 
	404 : 해당 문서를 찾을 수 없을때 
	500 : 문법오류 or 예외발생 상태
	407 : 인증을 받지 못한 경우
	400 : 
	
--%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		consol.log('예외 타입 : <%=exception.getClass().getName() %>');
		consol.log('예외 메세지 : <%=exception.getMessage()%>');
	</script>
</head>
<body>
	<h1>공사중 입니다. 조속한 시일내 복구 하겠습니다.</h1>
	<%
		System.out.println("예외타입 : " + exception.getClass().getName());
		System.out.println("예외 메세지 : " + exception.getMessage());
	%>
</body>
</html>