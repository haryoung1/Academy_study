<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ex2_scope.jsp">
		<p>ID <input type="text" name="id"></p>
		<p>PW <input type="password" name="pw"></p>
		<p>name <input type="text" name="name"></p>
		<p><input type="submit"></p>
	</form>
	<% // 자바에서 사용 할 로직
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requestValue"); // ★ 이 두가지를 주로 많이 사용 할 예정
		session.setAttribute("sessionName", "sessionValue"); //	★ 이 두가지를 주로 많이 사용 할 예정
		application.setAttribute("applicationName", "applicationValue");
		// 자바에서 forward 할 객체 생성 : dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex2_scope.jsp?id=aaa&pw=111&name=kang");
		dispatcher.forward(request, response);
	%>
<%-- 	<jsp:forward page="ex2_scope.jsp">
		<jsp:param value="aaa" name="id"/>
		<jsp:param value="111" name="pw"/>
		<jsp:param value="hong" name="name"/>
	</jsp:forward> 
--%>
	
	<h3>페이지 내 attribute : <%=pageContext.getAttribute("pageName") %></h3>
	<h3>request 내 attribute : <%=request.getAttribute("requestName") %></h3>
	<h3>session 내 attribute : <%=session.getAttribute("sessionName") %></h3>
	<h3>application 내 attribute : <%=application.getAttribute("applicationName") %></h3>
	<hr>
	<h3>페이지 내 attribute : ${pageName } </h3>
	<h3>request 내 attribute : ${requestName }</h3>
	<h3>session 내 attribute : ${sessionName }</h3>
	<h3>application 내 attribute : ${applicationName}</h3>
</body>
</html>