<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이 파일은 hello.jsp 임</h1>
	<%
		int total = 0; // total 이라는 변수에 값을 누적 할거임 맨 처음엔 당연히 0 why : 누적 시작도 안했으니까
		for (int cnt = 1; cnt <= 100; cnt++) {
		total += cnt; 
		// 반복문 돌리자 cnt라는 변수가 total에 들어갈 값임 (int cnt=1;)로 선언했으니 처음엔 1이고
		// 이게 100번(cnt<=100;) 돌때까지 cnt가 계속 1씩 증감되고 (cnt ++)
		// 증감 되는 값은 1~100번까지 계속 total에 차곡차곡 쌓임 100번을 다 돌면 끝
		}
	%>
</body>
</html>