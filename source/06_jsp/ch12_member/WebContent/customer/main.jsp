<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#mainForm_wrap {
			height: 600px; 
			line-height: 600px;
			font-size : 32px;
			text-align: center;
			width: 800px;
			margin: 0px auto;
			color:#805040;
			border: 1px solid #805040;
		}
	</style>
</head>
<body>
	<jsp:include page="../customer/header.jsp"/>
	<div id="mainForm_wrap">
		<h2>main 화면</h2>
	</div>
	<jsp:include page="../customer/footer.jsp"/>
</body>
</html>