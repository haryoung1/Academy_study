<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
<<<<<<< HEAD
	
=======
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</head>
<body>
	<form action="agree.jsp" method="post">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th>아이디</th>
<<<<<<< HEAD
				<td><input type="text" name="id" 
					required="required">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw"
					required="required">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="pwChk"
					required="required">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" 
					required="required">
				</td>
=======
				<td><input type="text" name="id" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="pwChk"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" required="required"></td>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
			</tr>
			<tr>
				<th colspan="2">
				<input type="submit" value="가입" class="btn">
				<input type="reset" value="취소" class="btn">
				<input type="button" value="로그인" class="btn"
<<<<<<< HEAD
				onclick="location.href='<%=conPath%>/lect2_login/login.jsp'">
=======
				 onclick="location.href='<%=conPath %>/lect2_login/login.jsp'">
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
			</tr>
		</table>
	</form>
</body>
</html>