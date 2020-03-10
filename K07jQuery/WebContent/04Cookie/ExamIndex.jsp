<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//생성된 쿠키 전체를 배열형태로 가져온다.
	Cookie[] cookies = request.getCookies();
	String user = "";
	if (cookies != null) {
		for (Cookie ck : cookies) {
			if (ck.getName().equals("USER_ID")) {
				//USER_ID라는 이름으로 생성된 쿠키가 있다면
				//변수에 쿠키값을 저장한다.
				user = ck.getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ExamIndex.jsp</title>
</head>
<body>
	<h2>쿠키를 이용한 아이디 저장예제</h2>
	<!-- 로그인 처리 페이지에서 리퀘스트 영역에 저장한 속성을
	가져와서 출력한다. -->
	<span style="color: red; font-size: 1.5em;"> 로그인 처리 메세지 출력부분 : 
	<%=request.getAttribute("ERROR_MSG") == null ? "로그인" : request.getAttribute("ERROR_MSG")%>

	</span>

	<form action="LoginProc.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<!-- 변수 user에 값이 있다면 value에 삽입한다.
				아무런 값도 없다면 공백문자를 삽입한다. -->
				<td><input type="text" name="user_id"
					value="<%=(user == null) ? "" : user%>" tabindex="1" /> &nbsp; 
					
					<!-- user가 값을 가지고 있다면 체크된 상태로 변환해준다. -->	
									
					<input type="checkbox" name="id_save" value="Y" tabindex="3"
					<%if (user.length() != 0) {%> checked="checked"
					<%}%> /> 아이디저장하기</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="user_pw" value="" tabindex="2" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="로그인하기" tabindex="4" /></td>
			</tr>
		</table>
	</form>

</body>
</html>