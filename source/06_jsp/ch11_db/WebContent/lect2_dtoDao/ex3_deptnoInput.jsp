<%@page import="com.lec.dto.DeptDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.DeptDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
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
	<form action="ex3_empOut.jsp">
	<p>
		<select name="deptno">
			<option value="0"></option>
			<%
				DeptDao dDao = DeptDao.getInstance();
=======
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<form action="ex3_empOut.jsp">
		<p>
			부서번호 <select name="deptno">
				<option value="0"></option>
				<%
					DeptDao dDao = DeptDao.getInstance();
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
				ArrayList<DeptDto> deptList = dDao.deptList();
				for (DeptDto dept : deptList) {
					int deptno = dept.getDeptno();
					String dname = dept.getDname();
					String loc = dept.getLoc();
<<<<<<< HEAD
					out.println("<option value='" + deptno + "'>"+
					deptno + " - " + dname + " - " + loc + "</option>");
				}
			%>
		</select>
		<input type="submit" value="검색">
	</p>
=======
					out.println("<option value='" + deptno + "'>" + deptno + " - " + dname + " - " + loc + "</option>");
				}
				%>
			</select> <input type="submit" value="검색">
		</p>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
	</form>
</body>
</html>