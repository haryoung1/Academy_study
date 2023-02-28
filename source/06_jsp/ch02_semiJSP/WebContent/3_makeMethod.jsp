<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		long result = power(2,3);
	%>
	<p>2의 3승은 : <%=result %>입니다</p>
	<p>9의 10승은 :<%=power(9,10) %></p>
	<%-- 변수나 메소드를 선언 --%>
	<%! 
	private long power(int a, int b) {
		long result = 1;
		for (int i=1 ; i<=b; i ++){
			result *= a;
		}
		return result;
	}
	%>
</body>
</html>