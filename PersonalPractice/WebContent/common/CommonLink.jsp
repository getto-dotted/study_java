<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CommonLink.jsp</title>
</head>
<body>
	<h2>페이지링크</h2>
		<table border="1" width="90%">
			<tr>
				<td>
<%
				if(session.getAttribute("USER_ID")==null){ 
%>
					<a href="../Session/Login.jsp">로그인</a>
<% 				}
				else{ 
%>
					<a href="../Session/Logout.jsp">로그아웃</a>
<%
				}
%>
				</td>
				<td><a href="../Board/BoardList.jsp">회원제게시판(검색o,페이징o)</a></td>
				<td><a href="../Board/MemberForm.jsp">회원가입</a></td>
			</tr>
		</table>	
</body>
</html>