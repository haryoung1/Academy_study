<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
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
	<h1>테스트 페이지</h1>
	<%
		CustomerDao dao = CustomerDao.getInstance(); // 아이디 중복체크
		String id = "bbb";
		int result = dao.confirmId(id);
		if (result == CustomerDao.CUSTOMER_EXISTENT) {
			out.println("<h3>1. confirmId 결과 : " + id + "는 있는 아이디, 회원가입 불가</h3>");
		}else {
			out.println("<h3>1. confirmId 결과 : " + id + "는 없는 아이디, 회원가입 가능</h3>");
			CustomerDto dto = new CustomerDto (id, "123", "강길동", null, null, null, null, null, null);
			result = dao.joinCustmor(dto);
			if (result == CustomerDao.SUCCESS) {
				out.println("<h3>2. join 결과 : 회원가입 성공");
			}else {
				out.println("<h3>2. join 결과 : 회원가입 실패 : " + dto);
			}
		}
		out.println("<h3>3. 로그인 결과 : "); // 로그인 일치할때
		result = dao.loginCheck("aaa", "111");
		if (result == CustomerDao.LOGIN_SUCCESS) {
			out.println(": aaa - 111 로그인 성공</h3>");
		}else if (result == CustomerDao.LOGIN_FAIL) {
			out.println(": aaa - pw 오류로 로그인 실패</h3>");
		}
		
		out.println("<h3>3. 로그인 결과 : "); // 로그인 비번 불 일치
		result = dao.loginCheck("aaa", "222");
		if (result == CustomerDao.LOGIN_SUCCESS) {
			out.println(": aaa - 222 로그인 성공</h3>");
		}else if (result == CustomerDao.LOGIN_FAIL) {
			out.println(": aaa - 222 : pw 오류로 로그인 실패</h3>");
		}
		
		out.println("<h3>3. 로그인 결과 : "); // 로그인 아디 불 일치
		result = dao.loginCheck("bbb", "123");
		if (result == CustomerDao.LOGIN_SUCCESS) {
			out.println(": bbb - 123 로그인 성공</h3>");
		}else if (result == CustomerDao.LOGIN_FAIL) {
			out.println(": bbb - 123 : pw 오류로 로그인 실패</h3>");
		}
		
		out.println("<h3>4. id로 dto 가져오기</h3>"); // id로 dto 정보 가져오기
		CustomerDto dto = dao.getCustomer("aaa");
		out.println("aaa 아이디인 customer : " + dto + "<br>");
		out.println("<hr>");
		dto = dao.getCustomer("qqq");
		out.println("qqq 아이디인 customer : " + dto + "<br>"); // 일치하는 id 정보 없으면 null로 나옴
		out.println("<hr>");
		out.println("<h3>5. 정보수정</h3>");
		dto = new CustomerDto ("aaa", "222", "테스트1", null, null, null, null, null, null);
		result = dao.modifyCustomer(dto);
		if (result == CustomerDao.SUCCESS) {
			out.println("<h3>수정완료<br></h3>");
			out.println("db의 수정 된 데이터 : " + dao.getCustomer(dto.getCid()) + "<br>");
		}else {
			out.println(dto.getCid() + " 는(은) 없는 아이디라서 수정 불가<br>");
		}
				
	%>
</body>
</html>