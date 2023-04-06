<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h3 style="text-align: right;">
		<span style="text-align: right;">"현재 총${cnt }명"</span>
	</h3>
	<table>
		<caption>결과는 다음과 같습니다</caption>
		<tr>
			<th>이름 :</th>
			<td>${member.name }</td>
		</tr>
		<tr>
			<th>국어 :</th>
			<td>${member.kor }</td>
		</tr>
		<tr>
			<th>영어 :</th>
			<td>${member.eng }</td>
		</tr>
		<tr>
			<th>수학 :</th>
			<td>${member.mat }</td>
		</tr>
		<tr>
			<th>총점 :</th>
			<td>${member.kor + member.eng + member.mat}</td>
		</tr>
		<tr>
			<th>평균 :</th>
			<td>${member.kor + member.eng + member.mat / 3}</td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="history.back()">뒤로가기</button>
				<button onclick="location.href='${conPath }/input.do'">다시입력</button>
			</th>
		</tr>
	</table>
</body>
</html>