<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataPassword.jsp</title>
	
	<script type="text/javascript">
		function checkValidate(f) {		
			if(f.id.value == ""){
				alert("아이디를 입력하세요");
				f.id.focus();
				return false;
			}
			if (f.pass.value == "") {
				alert("패스워드를 입력하세요");
				f.pass.focus();
				return false;
			}			
		}
	</script>

</head>
<body onload="document.writeFrm.id.focus()">

	<h2>프로그램 일정</h2>
	<!--
	패스워드 검증 폼은 패스워드만 전송하면 되므로 enctype을 지정하지 않아도 된다.
	일반적인 형태를 사용한다.
	-->
	<form name="writeFrm" method="post" action=""
		onsubmit="return checkValidate(this);">
		
		<!-- 
		파라미터로 전달되는 값은 컨트롤러에서 굳이 리퀘스트 영역에 저장하지 않아도 
		EL의 param내장객체를 통해 가져올 수 있으므로 이경우는 EL식을 사용하는 것이
		훨씬 더 간편하다.
		 -->
		<input type="hidden" name="idx" value="${param.idx }"/> 
		<input type="hidden" name="mode" value="${mode }"/> 
		<input type="hidden" name="nowPage" value="${param.nowPage }"/> 
		
		<table border=1 width=800>
			<colgroup>
				<col width="25%" />
				<col width="*" />
			</colgroup>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" style="width: 30%;" /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pass" style="width: 30%;" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">ID/Pass검증하기</button>
					<button type="reset">RESET</button>
					<button type="button" onclick="location.href='../program/sub01_list2';">목록보기</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>