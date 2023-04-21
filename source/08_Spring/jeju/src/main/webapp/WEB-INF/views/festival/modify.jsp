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
<link href="${conPath }/css/festivalList.css" rel="stylesheet">
<style>
.ck-editor__editable {
	height: 400px;
}
</style>
</head>
<body>
	<!-- model의modifyBoard, param.bid, param.pageNum가 있음 -->
	
	<div id="wrap">
		<div id="content_form">
			<form action="${conPath }/festival/modify.do" method="post">
				<input type="hidden" name="pageNum" value="${param.pageNum }">
				<input type="hidden" name="festivalno"
					value="${festival.festivalno }">
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="ftitle"
							value="${festival.ftitle }" required="required"></td>
					</tr>
					<tr>
						<th>본문</th>
						<td><textarea id="summernote" name="fcontent">${festival.fcontent }</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="저장" class="btn">
							<input type="reset" value="취소" class="btn"
							onclick="history.go(-1)"> <input type="button" value="목록"
							class="btn"
							onclick="location.href='${conPath}/festival/list.do?pageNum=${param.pageNum }'">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>

<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<script>
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 400,
			minHeight : null,
			maxHeight : null,
			lang : 'ko-KR',
			onImageUpload : function(files, editor, welEditable) {
				sendFile(files[0], editor, welEditable);
			}
		});
	});
</script>
</html>