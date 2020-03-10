<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileUploadMain.jsp</title>
</head>
<body>
	<script>
		function isValidate(f) {
			if (f.chumFile1.value == "") {
				alert("파일1을 선택하세요");
				return false;
			}
			if (f.chumFile2.value == "") {
				alert("파일2을 선택하세요");
				return false;
			}
		}
		function isValidate2(f) {
			if (f.chumFile1.value == "") {
				alert("파일1을 선택하세요");
				return false;
			}
		}
	</script>
	
	<h2>파일 업로드 폼(DB처리X)</h2>

	<h4 style="color: red;">${errorMessage }</h4>

	<a href="FileList.jsp">파일목록 바로가기</a>
	<!-- 
	파일업로드를 위한 Form태그 구성
	: method(전송방식) =>POST방식	/  enctype=>"multipart/form-data"
	이와같이 구성해야만 파일이 서버로 전송된다. 그렇지 않으면 파일명(Text)만 전송된다. 	-->
	<form name="fileFrm" method="post" enctype="multipart/form-data"
		action="UploadProc.jsp" onsubmit="return isValidate(this);">

		작성자 : <input type="text" name="name" value="정우성" /> <br /> 
		제목 : <input
			type="text" name="title" value="파일업로드 Test" /> <br /> 
			관심사항 : <input type="checkbox" name="inter" value="정치" checked="checked" />
			정치 <input	type="checkbox" name="inter" value="경제" checked="checked" />
			경제 <input	type="checkbox" name="inter" value="문화" />문화 <br /> 
			첨부파일1 : <input type="file" name='chumFile1' /> <br /> 
			첨부파일2 : <input type="file" name="chumFile2" /> <br /> 
			<input type="submit" value="파일업로드GoGo" />
	</form>
</body>
</html>