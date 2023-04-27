<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기한 숙소 목록</title>
<link href="${conPath }/css/bookmark/style.css" rel="stylesheet">
<style>
img {
	width: 400px;
	height: 250px;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<br>
	<br>
	<h2 align="center">${member.mname}님이 즐겨찾기 한 숙소LIST</h2>
	<br>
	<br>
	<div class="box">
		<c:if test="${empty hotelList }">
			<h2 align="center">즐겨찾기한 숙소가 없어요</h2>
		</c:if>
		<c:forEach var="hotel" items="${hotelList}">
			<div>
<%-- 				<img src="${conPath}/hotelImgFileUpload/${hotel.imgPath}" alt="${hotel.hname}"> --%>
				<img alt="" src="${conPath }/hotelImgFileUpload/${hotel.imgPath}">
				<p>${hotel.hname}</p>
				<a style="text-align: center;" href="${conPath}/hotel/detail.do?hname=${hotel.hname}">상세보기</a>
			</div>
		</c:forEach>
	</div>
	<br>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>
