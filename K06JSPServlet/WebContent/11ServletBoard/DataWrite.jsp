<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataWrite.jsp</title>
	
	<script type="text/javascript">
		function checkValidate(f) {
			if (f.name.value == "") {
				alert("이름을 입력하세요");
				f.name.focus();
				return false;
			}
			if (f.pass.value == "") {
				alert("패스워드를 입력하세요");
				f.pass.focus();
				return false;
			}
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

	<h2>자료실 - 글작성</h2>
	<!--첨부파일을 업로드하기 위해 enctype을 아래와 같이 설정함.
	이 경우 서버로 submit()했을때 Multipart객체를 통해 요청을 받아야 한다. -->
	<form name="writeFrm" method="post" action="../DataRoom/DataWrite"
		enctype="multipart/form-data" onsubmit="return checkValidate(this);">
		<table border=1 width=800>
			<colgroup>
				<col width="25%" />
				<col width="*" />
			</colgroup>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name" style="width: 50%;" /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pass" style="width: 30%;" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" style="width: 90%;" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" style="width: 90%; height: 200px;"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="attachedfile" style="width: 90%;" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">작성완료</button>
					<button type="reset">RESET</button>
					<button type="button" onclick="location.href='../DataRoom/DataList';">리스트바로가기</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>