<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); 
	if(session.getAttribute("customer") != null) { // 로그인 상태
		response.sendRedirect("main.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link  href='<%=conPath%>/css/join.css' rel='stylesheet'>
	<script src="<%=conPath%>/js/join.js"></script>
</head>
<body>
	<jsp:include page="../customer/header.jsp" />
	<div id="joinForm_wrap">
		<form action="joinPro.jsp" method="post" name="frmjoin">
			<div id="join_title">회원가입</div>
			<input type="hidden" name="hiddenParam" value="xx">
			<table>
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="cid"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<th><label for="pw">비밀번호</label></th>
					<td><input type="password" name="cpw" class="pw"></td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호확인</label></th>
					<td><input type="password" name="cpwChk" class="pwChk"></td>
				</tr>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="cname" class="name"
							   autofocus="autofocus"></td>
				</tr>
				<tr>
					<th><label for="tel">전화</label></th>
					<td><input type="text" name="ctel" class="tel"
							   autofocus="autofocus"></td>
				</tr>
				<tr>
					<th><label for="email">이메일</label></th>
					<td><input type="email" name="cemail" id="email" class="email"></td>
				</tr>
				<tr>
					<th><label for="address">주소</label></th>
					<td><input type="text" name="caddress" id="address" class="address"></td>
				</tr>
				<tr>
					<th><label for="birth">생년월일</label></th>
					<td><input type="date" name="cbirth" id="birth" class="birth">
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="m" id="m"
						checked="checked"> 
						<label for="m">남자</label> 
						<input type="radio" name="gender" value="f" id="f"> 
						<label for="f">여자</label>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="가입하기" class="joinBtn_style"
					onclick="location.href'<%=conPath%>/customer/joinPro.jsp"> 
					<input type="reset"  value="다시하기" class="joinBtn_style"> 
					<input type="button" value="로그인"  class="joinBtn_style"
					onclick="location.href='<%=conPath%>/customer/login.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>