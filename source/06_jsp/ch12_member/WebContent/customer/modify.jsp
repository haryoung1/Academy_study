<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/modify.css" rel="stylesheet" type="text/css">
	<script>
		// submit 이벤트 추가 : pw와 pwchk 같은지 , email 유효성 검사
	</script>
</head>
<body>
	<%! 
		String cid, cname, ctel, cemail, caddress, cgender;
		Date cbirth;
	%>
	
	<%
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		if (customer == null) {
			response.sendRedirect("login.jsp");
		}else {
			cid = customer.getCid();
			cname = customer.getCname();
			ctel = customer.getCtel();
			cemail = customer.getCemail();
			caddress = customer.getCaddress();
			cgender = customer.getCgender();
			cbirth = customer.getCbirth();
			
		}
	%>
	<jsp:include page="../customer/header.jsp" />
	<form action="modifyPro.jsp" method="post">
		<div id="modify_wrap">
		<table>
			<caption>정보수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="cid" value="<%=cid %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>현비밀번호</th>
				<td><input type="password" name="oldPw" required="required"></td>
			</tr>
			<tr>
				<th>새비밀번호</th>
				<td>
					<input type="password" name="cpw" placeholder="비밀번호 수정을 원하지 않으면 입력하지 마">
				</td>
			</tr>
			<tr>
				<th>새비밀번호 확인</th>
				<td>
					<input type="password" name="cpwChk">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="cname" value="<%=cname %>" required="required"></td>
			</tr>
			<tr>
				<th>전화</th>
				<td>
					<input type="text" name="ctel" value="<%=ctel %>" required="required">
				</td>
			</tr>
			
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" value='<%= cemail == null? "": cemail%>'>
			</tr>

			<tr>
				<th>주소</th>
				<td><input type="text" name="address" value='<%=caddress!=null? caddress : ""%>'></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="cbirth" value='<%= cbirth == null? "": cbirth.toString()%>'>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				<%if("m".equals(cgender)){ %>
					<input type="radio" name="gender" value="m" checked="checked">남
					<input type="radio" name="gender" value="f">여
				<%} else if("f".equals(cgender)){ %>
					<input type="radio" name="gender" value="m">남
					<input type="radio" name="gender" value="f" checked="checked">여
				<%}else {%>
					<input type="radio" name="gender" value="m">남
					<input type="radio" name="gender" value="f">여
				<%} %>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기" class="joinBtn_style">
					<input type="reset"  value="다시하기"  class="joinBtn_style">
					<input type="button" value="이전으로" onclick="history.back()"
					class="joinBtn_style">
			</tr>
		</table>
		</div>
	</form>
	
	<jsp:include page="../customer/footer.jsp" />
</body>
</html>







			
			
			
			
			
			
			
