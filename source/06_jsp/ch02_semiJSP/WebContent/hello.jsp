<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>이 파일은 hello.jsp 입니다.</h1>
	<%
		int total = 0; // << java로 인식
		for (int cnt = 1 ; cnt<=100 ; cnt ++) {
			total += cnt;
		}
	%>
	<h2>1부터 100까지 누적한 값은 <%=total%> 입니다</h2>
	<!-- 스크립트릿을 식으로도 사용가능  -->
</body>
</html>