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
<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
#content_form {
	height: 370px;
	margin: 130px auto 0px;
}
</style>
</head>
<body>
	<c:if test="${not empty admin }">
		<script>
			alert('환영 합니다. 관리자님');
			location.href='${conPath }/allView.do';
		</script>
	</c:if>
	<c:if test="${not empty member }">
		<script>
			alert('관리자 전용 모드 입니다.');
			history.back();
		</script>
	</c:if>
</body>
<jsp:include page="../main/header.jsp" />
<div id="content_form">
	<form action="${conPath }/adminLogin.do" method="post">
		<table>
			<caption>관리자 로그인</caption>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="aid" required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="apw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<p>
						<input type="submit" value="로그인" class="btn">
					</p>
				</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp" />
</html>
