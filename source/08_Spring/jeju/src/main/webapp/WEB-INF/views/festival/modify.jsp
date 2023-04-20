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
</head>
<body>
	<!-- model의modifyBoard, param.bid, param.pageNum가 있음 -->
	<form action="${conPath }/festival/modify.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="festivalno" value="${festival.festivalno }">
		<table>
			<caption>${param.festivalno }번 글수정</caption>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="aid" value="${festival.aid }" required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="ftitle" value="${festival.ftitle }" required="required">
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td>
					<textarea rows="5" name="fcontent">${festival.fcontent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="저장" class="btn">
					<input type="reset" value="취소" class="btn" onclick="history.go(-1)">
					<input type="button" value="목록" class="btn" onclick="location.href='${conPath}/festival/list.do?pageNum=${param.pageNum }'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>