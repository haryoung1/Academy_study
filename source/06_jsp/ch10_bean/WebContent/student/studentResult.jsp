<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<<<<<<< HEAD
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!--  뷰단   -->
	<jsp:useBean id="st" class="com.lec.ex.Student" scope="request"/>
	<h2>입력된 개인정보</h2>
	<p>학번 : <jsp:getProperty name="st" property="studentNum"/></p>
	<p>이름 : <jsp:getProperty name="st" property="name"/> </p>
	<p>학년 : <jsp:getProperty name="st" property="grade"/></p>
	<p>반    : <jsp:getProperty name="st" property="className"/> </p>
	<p>점수 : <jsp:getProperty name="st" property="score"/> </p>
=======
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="st" class="com.lec.ex.Student" scope="request"/>
	<h2>입력 받은 정보</h2>
	<p>학번 : <jsp:getProperty property="hakno" name="st"/></p>
	<p>이름 : <jsp:getProperty property="name" name="st"/></p>
	<p>학년 : <jsp:getProperty property="grade" name="st"/></p>
	<p>반    : <jsp:getProperty property="class1" name="st"/></p>
	<p>점수 : <jsp:getProperty property="score" name="st"/></p>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>