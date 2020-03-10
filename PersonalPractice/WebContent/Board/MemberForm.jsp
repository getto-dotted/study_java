<%@page import="practice.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormAction.jsp</title>
<script>
	function frmCheck() {
		var f = document.frm;
		//폼의 전송방식과 action경로를 JS에서 설정함
		f.action = "JoinMember.jsp";
		f.method = "post";
	}
</script>
</head>
<body>
	<h2>회원가입</h2>
	<form name="frm" onsubmit="return frmCheck();">
		<ul>
			<li>사용할 아이디 : <input type="text" name="id" /></li>
			<li>이름 : <input type="text" name="name" /></li>
			<li>비밀번호 : <input type="password" name="pass" /></li>
			<li><input type="submit" value="전송하기" /></li>			
		</ul>
	</form>
</body>
</html>