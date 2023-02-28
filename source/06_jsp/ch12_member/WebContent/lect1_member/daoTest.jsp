<%@page import="com.lec.member.MemberDto"%>
<%@page import="com.lec.member.MemberDao"%>
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
		MemberDao dao = MemberDao.getInstance(); // 아이디 중복체크
		String id = "bbb";
		int result = dao.confirmId(id);
		if (result == MemberDao.MEMBER_EXISTENT) {
			out.println("<h3>1. confirmId 결과 : " + id + "는 있는 아이디, 회원가입 불가</h3>");
		}else {
			out.println("<h3>1. confirmId 결과 : " + id + "는 없는 아이디, 회원가입 가능</h3>");
			MemberDto dto = new MemberDto(id, "123", "홍길동", null, null, null, null, // 회원가입
					null, null, null, null);
			result = dao.joinMember(dto);
			if (result == MemberDao.SUCCESS) {
				out.println("<h3>2. join 결과 : 회원가입 성공");
			}else {
				out.println("<h3>2. join 결과 : 회원가입 실패 : " + dto);
			}
		}
		out.println("<h3>3. 로그인 결과 : "); // 로그인 일치할때
		result = dao.loginCheck("aaa", "111");
		if (result == MemberDao.LOGIN_SUCCESS) {
			out.println(": aaa - 111 로그인 성공</h3>");
		}else if (result == MemberDao.LOGIN_FAIL_PW) {
			out.println(": aaa - pw 오류로 로그인 실패</h3>");
		}else if (result == MemberDao.LOGIN_FAIL_ID) {
			out.println(": aaa - id 오류로 로그인 실패</h3>");
		}
		
		out.println("<h3>3. 로그인 결과 : "); // 로그인 비번 불 일치
		result = dao.loginCheck("aaa", "222");
		if (result == MemberDao.LOGIN_SUCCESS) {
			out.println(": aaa - 222 로그인 성공</h3>");
		}else if (result == MemberDao.LOGIN_FAIL_PW) {
			out.println(": aaa - 222 : pw 오류로 로그인 실패</h3>");
		}else if (result == MemberDao.LOGIN_FAIL_ID) {
			out.println(": aaa - 222 : id 오류로 로그인 실패</h3>");
		}
		
		out.println("<h3>3. 로그인 결과 : "); // 로그인 아디 불 일치
		result = dao.loginCheck("abc", "222");
		if (result == MemberDao.LOGIN_SUCCESS) {
			out.println(": abc - 222 로그인 성공</h3>");
		}else if (result == MemberDao.LOGIN_FAIL_PW) {
			out.println(": abc - 222 : pw 오류로 로그인 실패</h3>");
		}else if (result == MemberDao.LOGIN_FAIL_ID) {
			out.println(": abc - 222 : id 오류로 로그인 실패</h3>");
		}
		out.println("<h3>4. id로 dto 가져오기</h3>"); // id로 dto 정보 가져오기
		MemberDto dto = dao.getMember("aaa");
		out.println("aaa 아이디인 member : " + dto + "<br>");
		out.println("<hr>");
		dto = dao.getMember("qqq");
		out.println("qqq 아이디인 member : " + dto + "<br>"); // 일치하는 id 정보 없으면 null로 나옴
		out.println("<hr>");
		out.println("<h3>5. 정보수정</h3>");
		dto = new MemberDto("ddd", "222", "이름임", null, null, null, null, // 회원가입
			  "north@hong.com", null, "북한", null);
		result = dao.modifyMember(dto);
		if (result == MemberDao.SUCCESS) {
			out.println("<h3>수정완료<br></h3>");
			out.println("db의 수정 된 데이터 : " + dao.getMember(dto.getId()) + "<br>");
		}else {
			out.println(dto.getId() + " 는(은) 없는 아이디라서 수정 불가<br>");
		}
				
	%>
</body>
</html>