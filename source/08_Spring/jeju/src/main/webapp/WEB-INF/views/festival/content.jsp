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
	<c:set var="SUCCESS" value="1" />
	<c:set var="FAIL" value="0" />
	<c:if test="${modifyResult eq SUCCESS }">
		<script>
			alert('${param.bid}번 글 수정 성공')
		</script>
	</c:if>
	<c:if test="${modifyResult eq FAIL }">
		<script>
			alert('${param.bid}번 글 수정 실패')
			history.back();
		</script>
	</c:if>
	<table>
		<caption>상세보기</caption>
		<tr>
			<th>글번호</th>
			<td>${contentFestival.festivalno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${contentFestival.ftitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${contentFestival.aid }</td>
		</tr>
		<tr>
			<th>본문</th>
			<td><pre>${contentFestival.fcontent }</pre></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${contentFestival.frdate }"
					pattern="yy/MM/dd(E) HH:mm:ss:SS" /></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${contentFestival.fhit }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button
					onclick="location.href='${conPath}/festival/modifyView.do?festivalno=${param.festivalno }&pageNum=${param.pageNum }'">
					수정</button>
				<button
					onclick="location.href='${conPath}/festival/delete.do?festivalno=${param.festivalno }&pageNum=${param.pageNum }'">
					삭제</button>
				<button
					onclick="location.href='${conPath}/festival/reply.do?festivalno=${param.festivalno}&pageNum=${param.pageNum }'">
					답변</button>
				<button
					onclick="location.href='${conPath}/festival/list.do?pageNum=${param.pageNum }'">
					목록</button>
			</td>
		</tr>
	</table>
</body>
</html>