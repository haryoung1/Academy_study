<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>ex5_include.jsp 파일 입니다</h1>
	<%-- <%@ include file="includePage.jsp" %> --%> <!-- jsp파일의 원본을 그대로(conPath) 가져오기 때문에 오류가 난다. -->
	<jsp:include page="includePage.jsp"/> <!-- jsp파일의 결과(출력되는거?) : html을 가져옴. -->
	<h1>ex5_include.jsp 파일 입니다</h1>
</body>
</html>