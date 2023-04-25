<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/emp.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<c:if test="${not empty msg}">
		<div class="alert alert-danger" role="alert">${msg}</div>
	</c:if>
	<form action="${conPath }/member.do" method="post">
		<input type="hidden" name="method" value="delete">
		<label for="mpw">현재 비밀번호</label>
		<input type="password" name="mpw" id="mpw"> 
		<input type="submit" value="회원탈퇴">
	</form>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>