<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/member/modify.css" rel="stylesheet">
<style>
</style>
<script src="${conPath }/js/address.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
	$(function() {
		// macth함수 사용
		var patternMemail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/;
		$('input[name="memail"]').keyup(function() {
			let memail = $(this).val();
			if ((!memail) || (memail == '${member.memail}')) {
				$('#memailConfirmResult').html(' &nbsp; ');
			} else if (patternMemail.test(memail)) {
				$.ajax({
					url : '${conPath}/member.do',
					type : 'get',
					data : "method=memailConfirm&memail=" + $('#memail').val(),
					dataType : 'html',
					success : function(data) {
						$('#memailConfirmResult').html(data);
					},
				});
			} else if (!patternMemail.test(memail)) {
				$('#memailConfirmResult').html('<b>메일 형식을 지켜 주세요</b>');
			}
		});
		$('form').submit(
				function() {
					// 현비밀번호확인과 사용불가한 중복된 메일일 경우 submit 제한
					var oldMpw = $('input[name="oldMpw"]').val();
					var memailConfirmResult = $('#memailConfirmResult').text()
							.trim();
					if (oldMpw != '${member.mpw}') {
						alert('현비밀번호를 확인하세요');
						$('input[name="oldMpw"]').focus();
						return false; // submit 제한
					} else if ((memailConfirmResult == '메일 형식을 지켜 주세요')
							|| (memailConfirmResult == '사용 불가한 중복된 메일')) {
						alert('메일을 확인하세요');
						$('input[name="memail"]').focus();
						return false;
					}
				});
	});
</script>
</head>
<body>
	<c:if test="${empty member }">
		<script>
			location.href = '${conPath}/member.do?method=login&after=member/modify.do';
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div id="content">
		<form action="${conPath }/member.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="method" value="modify">
			<table>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="mid" value="${member.mid }" readonly="readonly" size="3">
					</td>
					<td rowspan="4">
						<img src="${conPath }/memberPhoto/${member.mphoto}" alt="${member.mname }사진">
					</td>
				</tr>
				
				<tr>
					<td>현 비밀번호</td>
					<td>
						<input type="password" name="oldMpw" required="required" size="3">
					</td>
				</tr>
				<tr>
					<td>새비밀번호</td>
					<td>
						<input type="password" name="mpw" size="3">
					</td>
					</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="mname" value="${member.mname }" required="required" readonly="readonly" size="3">
					</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<input type="text" name="mtel" value="${member.mtel }" required="required" size="3">
					</td>
				</tr>
				<tr>
					<td>메일</td>
					<td colspan="2">
						<input type="email" name="memail" value="${member.memail }">
						<div id="memailConfirmResult">&nbsp;</div>
					</td>
					</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" id="sample4_postcode" name="mpost" class="text_box" size="3" value="${member.mpost }">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" id="sample4_roadAddress" name="maddr" size="3" value="${member.maddr }"> 
						<input type="hidden" id="sample4_jibunAddress" name="X" placeholder="지번주소"> 
						<span id="guide"></span>
					</td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td>
						<input type="text" name="mdeaddr" value="${member.mdeaddr }" required="required" size="3">
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<input type="date" name="mbirth" id="datepicker" value="${member.mbirth }" required="required" size="3">
					</td>
				</tr>
				<tr>
					<td>프로필사진</td>
					<td>
						<input type="file" name="tempmphoto">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center">
						<input type="submit" value="수정">
						<input type="button" value="취소" onclick="history.back()">
						<input type="button" value="회원탈퇴" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>
