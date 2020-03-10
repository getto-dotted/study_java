<%@page import="util.JsFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 로그인 체크위한 공통파일 인클루드 --%>
<%@ include file="../common/isLogin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardWrite.jsp-글쓰기</title>
<script type="text/javascript">
	function checkValidate(f) {
		if (f.title.value == "") {
			alert("제목을 입력하세요");
			f.title.focus();
			return false;
		}
		if (f.content.value == "") {
			alert("내용을 입력하세요");
			f.content.focus();
			return false;
		}
	}
</script>

</head>
<body>
	<%-- include지시어를 통해 외부파일 포함시킴 --%>
	<%@include file="../common/CommonLink.jsp"%>
	<h2>회원제 게시판 - 글쓰기 폼</h2>

	<form name="writeFrm" method="post" action="WriteProc.jsp"
		onsubmit="return checkValidate(this);">
		<table border=1 width=800>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" style="width: 90%;" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" style="width: 90%; height: 200px;"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">작성완료</button>
					<button type="reset">RESET</button>
					<button type="button" onclick="location.href='BoardList.jsp';">
						리스트바로가기</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>