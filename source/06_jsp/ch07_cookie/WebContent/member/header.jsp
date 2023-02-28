<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header {
	width: 800px;
	margin: 0 auto;
}

header ul {
	overflow: hidden;
}

header ul li {
	list-style: none;
	float: right;
	padding: 10px 30px;
}
header ul li a {
	text-decoration: none;
	font-weight: bold;
	font-size : 1.5em;
	color:#805040;
}
</style>
</head>
<body>
	<header>
		<div id="nav">
			<%
				String id = null; // id 쿠키가 있을 경우 쿠키값을 저장하는 용도
				Cookie[] cs = request.getCookies();
				if (cs!=null) {
					for(Cookie c : cs) {
						if(c.getName().equals("id")) {
							id = c.getValue();
							break;
						}
					} // for
				} // if
				if(id == null) { // 로그인 전 헤더 화면 (id가 null면 아무것도 입력 안한거니께)
			%>	
				<ul>
					<li><a href="<%=conPath%>/member/join.jsp">회원가입</a></li>
					<li><a href="<%=conPath %>/member/login.jsp">로그인</a></li>
					<li><a href="<%=conPath %>/index.jsp">홈</a></li>
				</ul>
			<%	}else { // 로그인 성공 후 화면 %>
				<ul>
					<li><a href="<%=conPath %>/member/cookieList.jsp">쿠키리스트</a></li>
					<li><a href="<%=conPath %>/member/logout.jsp">로그아웃</a></li>
					<li><a href="<%=conPath %>/"><%=id %>님</a></li>
				</ul>
			<%} %>
		</div>
	</header>
</body>
</html>