<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/emp.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	$(document).ready(function() {
		$('form').submit(function() {
			var confirmMsg = $('span').text().trim();
			if (!confirmMsg) {
				alert('사번 중복확인 후 등록 하세요.');
				return false; // submit 이벤트 제한
			} else if (confirmMsg != '사용가능한 사번 입니다') {
				alert('사용가능 한 사번으로 등록 하세요.')
				frm.empno.focus
				return false;
			}
		});
	});
	function idConfirmChk() {
		var empno = frm.empno.value;
		if (!empno) {
			alert('사번 입력 후 중복 확인 하세요.');
			frm.empno.focus();
		} else {
			var ename = frm.ename.value;
			var job = frm.job.value;
			var mgr = frm.mgr.value;
			var sal = frm.sal.value;
			var comm = frm.comm.value;
			var deptno = frm.deptno.value;
			var hiredate = frm.hiredate.value;
			location.href = 'confirmNo.do?empno=' + empno + '&ename=' + ename
					+ '&job=' + job + '&mgr=' + mgr + '&hiredate=' + hiredate
					+ '&sal=' + sal + '&comm=' + comm + '&deptno=' + deptno;
		}
	}
</script>
</head>
<body>
	<c:if test="${not empty writeResult }">
		<script>
			alert('등록실패! 필드 값이 너무 길어요');
		</script>
	</c:if>
	<form action="${conPath }/write.do" method="post" name="frm">
		<table>
			<tr>
				<th>사번</th>
				<td><input type="number" name="empno" required="required"
					value="${param.empno }"> <input type="button" value="중복확인"
					onclick="idConfirmChk()"><br> <span class="confirmMsg">
						${confirmMsg } </span></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="ename" value="${param.ename }">
				</td>
			</tr>
			<tr>
				<th>직책</th>
				<td><input type="text" name="job" value="${param.job }">
				</td>
			</tr>
			<tr>
				<th>상사사번</th>
				<td><select name="mgr">
						<option></option>
						<c:forEach items="${managerList }" var="mgrEmp">
							<option value="${mgrEmp.empno }"
								<c:if test="${mgrEmp.empno eq param.mgr }">
									selected="selected"
								</c:if>>
								${mgrEmp.empno }- ${mgrEmp.ename }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="date" name="hiredate"
					value="${param.hiredate }" required="required"></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="number" name="sal" value="${param.sal }"
					required="required"></td>
			</tr>
			<tr>
				<th>상여</th>
				<td><input type="number" name="comm" value="${param.comm }">
				</td>
			</tr>
			<tr>
				<th>부서번호</th>
				<td>
					<select name="deptno">
						<c:forEach var="dept" items="${deptList }">
							<option value="${dept.deptno }"
								<c:if test="${dept.deptno eq emp.deptno }">
										selected="selected"
									</c:if>
							>
								${dept.deptno }-${dept.dname }-${dept.loc }
							</option>
						</c:forEach>
				</select>
			</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록" class="btn">
					<input type="button" value="목록"
					onclick="location.href='${conPath}/empDeptList.do'"></td>
			</tr>
		</table>
	</form>
</body>
</html>