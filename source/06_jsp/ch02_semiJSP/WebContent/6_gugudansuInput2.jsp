<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<style>
	p {
	text-align:center;
	font-weight: bold;
	}
	#num {
	width : 50px; 
	}
	#sub {
	width : 140px; 
	}
</style>
<script>
	window.onload = function() {
		document.querySelector('form').onsubmit = function() {
		var su1 = document.querySelector('input[name="su1"]');
		var su2 = document.querySelector('input[name="su2"]');
		if(!su1.value) {
			alert('첫번째 수를 입력 안했습니다');
			su1.focus();
			return false;
		}else if(!su2.value) {
			alert('두번째 수를 입력 안했습니다');
			su2.focus();
			return false;
		}
		var s1 = parseInt(su1.value);
		var s2 = Number(su2.value);
		if (s1> s2) {
			alert('첫번째 숫자에 작거나 같은 수를 넣으세요')
			su1.focus();
			return false;
		}
	};
};
</script>
<body>
	<form action="6_gugudansuOut2.jsp" method="get">
	<table>
		<tr>
	<p>단수 <input id="num" type="number" name="su1"> ~
		  <input id="num" type="number" name="su2"></p>
	<p><input id="sub" type="submit" value="원하는 구구단 출력"></p>
		</tr>
	</table>
	</form>
</body>
</html>