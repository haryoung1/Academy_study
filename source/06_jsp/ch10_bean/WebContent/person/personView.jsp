<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- 뷰단 -->
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
<<<<<<< HEAD
	<h2>입력받은 개인정보(step4이후의 뷰단)</h2>
	<p>이름 <jsp:getProperty property="name" name="p"/></p>
	<p>나이 <jsp:getProperty property="age" name="p"/></p>
	<p>성별 <jsp:getProperty property="gender" name="p"/></p>
	<p>주소 <jsp:getProperty property="address" name="p"/></p>
=======
	<h2>입력 받은 개인정보 (step4 이후의 뷰단)</h2>
	<p>이름 : <jsp:getProperty property="name" name="p"/></p>
	<p>나이 : <jsp:getProperty property="age" name="p"/></p>
	<p>성별 : <jsp:getProperty property="gender" name="p"/></p>
	<p>주소 : <jsp:getProperty property="address" name="p"/> </p>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>