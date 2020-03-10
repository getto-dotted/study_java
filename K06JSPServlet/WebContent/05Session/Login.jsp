<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login.jsp</title>
<script>
	var loginValidate = function(frm) {
		if (frm.user_id.value == "") {
			alert("아이디를 입력하세요");
			frm.user_id.focus();
			return false;
		}
		if (!frm.user_pw.value) {
			alert("패스워드를 입력하세요");
			frm.user_pw.focus();
			return false;
		}
	}
</script>
</head>
<!-- 해당 문서의 로드가 완료되면 아이디 입력창에 자동으로 포커스가 이동됨. -->
<body onload="document.loginFrm.user_id.focus();">
	<%-- include지시어를 통해 외부파일 포함시킴 --%>
	<%@include file="../common/CommonLink.jsp"%>
	<h2>로그인 페이지</h2>

	<h3>로그인 유지시간 확인하기</h3>
	<fieldset>
		<legend>세션유지시간</legend>
		<h4>
			<%=session.getMaxInactiveInterval()%>초
		</h4>

	</fieldset>

	<span style="color: red; font-size: 1.5em;"> <%=request.getAttribute("ERROR_MSG") == null ? "" : request.getAttribute("ERROR_MSG")%>
	</span>
	<%
		//세션영역에 데이터가 없는 경우(로그아웃인 경우)
		if (session.getAttribute("USER_ID") == null) {
	%>
	<!-- count(*)를 이용한 로그인 	
<form action="LoginProcess.jsp" method="post" name="loginFrm"
		onsubmit="return loginValidate(this);"> -->
	<!-- MemberDTO객체를 이용한 로그인 -->
	<form action="LoginProcess2.jsp" method="post" name="loginFrm"
		onsubmit="return loginValidate(this);">
		<table>
			<tr>
				<td>아 이 디</td>
				<td><input type="text" name="user_id" tabindex="1" /></td>
				<td rowspan="2"><input type="submit" value="로그인"
					style="height: 50px;" tabindex="3" /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="user_pw" tabindex="2" /></td>
			</tr>
		</table>
	</form>
	<%
		} else {
	%>
	<!-- 세션영역에 USER_ID 속성값이 있는 경우 : 로그인 된 상태 -->
	<table border="1" width="400">
		<tr>
			<td><%=session.getAttribute("USER_NAME")%> (<%=session.getAttribute("USER_ID")%>)님,
				로그인 성공 <br /> <a href="Logout.jsp">로그아웃</a></td>
		</tr>
	</table>
	<%
		}
	%>

</body>
</html>