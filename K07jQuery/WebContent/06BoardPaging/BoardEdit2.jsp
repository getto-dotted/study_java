<%@page import="model.BbsDTO"%>
<%@page import="model.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 로그인 체크위한 공통파일 인클루드 --%>
<%@ include file="../common/isLogin.jsp"%>
<%
	String num = request.getParameter("num");
	BbsDAO dao = new BbsDAO(application);
	//파라미터로 전달된 일련번호에 해당하는 게시물을 가져옴
	BbsDTO dto = dao.selectView(num);
	dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardEdit.jsp-게시물 수정</title>
</head>
<body>
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
	<%-- include지시어를 통해 외부파일 포함시킴 --%>
	<%@include file="../common/CommonLink.jsp"%>
	<h2>회원제 게시판 - 수정하기 폼</h2>

	<form name="writeFrm" method="post" action="EditProc2.jsp"
		onsubmit="return checkValidate(this);">
		<!-- 해당 hidden폼은 수정할 게시물의 일련번호를 서버로 전송하기 위한
		목적으로 생성된다. 해당 hidden폼이 없다면 게시물을 수정할 수 없다. -->
		<input type="hidden" name="num" value="<%=num%>" />
		<table border=1 width=800>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" style="width: 90%;"
					value="<%=dto.getTitle()%>" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" style="width: 90%; height: 200px;"><%=dto.getContent()%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">수정완료</button>
					<button type="reset">RESET</button>
					<button type="button" onclick="location.href='BoardList.jsp';">
						리스트바로가기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>