<%@page import="com.lec.ex.dto.MemberDto"%>
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
<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
<style>
p {
	text-align: center;
}
</style>
</head>
<body>
	<c:if test="${empty member }">
		<h2>로그인 상태가 아닙니다.</h2>
		<hr>
		<td colspan="2">
			<p>
				<button onclick="location.href='${conPath}/loginView.do'">로그인</button>
				<button onclick="location.href='${conPath}/joinView.do'">회원가입</button>
			</p>
	</c:if>
	<c:if test="${not empty member }">
		<h2>${member.mname }(${member.mid })님어서오세요</h2>
		<hr>
		<p>
			<button onclick="location.href='${conPath}/logout.do'">로그아웃</button>
		</p>
	</c:if>
</body>
</html>
