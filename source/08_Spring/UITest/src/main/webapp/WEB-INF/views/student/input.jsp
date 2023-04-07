<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${conPath}/css/style.css">
</head>
<body>
	<div id="wrap">
		<p id="right">
			<span>현재 총 ${cnt }명</span>
		</p>
		<form action="${conPath }/input.do" method="post">
			<table>
				<caption>개인정보 입력</caption>
				<tr>
					<th>이름:</th>
					<td><input type="text" name="name" placeholder="홍길동">
					</td>
				</tr>
				<tr>
					<th>국어:</th>
					<td><input type="number" name="kor" min="0" max="100"
						placeholder="100"></td>
				</tr>
				<tr>
					<th>영어:</th>
					<td><input type="number" name="eng" min="0" max="100"
						placeholder="100"></td>
				</tr>
				<tr>
					<th>수학:</th>
					<td><input type="number" name="mat" min="0" max="100"
						placeholder="99"></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="입력" id="input"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>