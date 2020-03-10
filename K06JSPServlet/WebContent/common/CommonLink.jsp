<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CommonLink.jsp</title>
</head>
<body>
	<h2>공통링크</h2>
		<table border="1" width="90%">
			<tr>
				<td>
				<%if(session.getAttribute("USER_ID")==null){ %>
				<a href="../05Session/Login.jsp">로그인</a>
				<%}else{ %>
				<a href="../05Session/Logout.jsp">로그아웃</a>
				<%} %>
				</td>
				<td><a href="../06Board/BoardList.jsp">회원제게시판(검색x,페이징x)</a></td>
				<td><td><a href="../06BoardSearch/BoardList.jsp">회원제게시판(검색o,페이징x)</a></td></td>
				<td><td><a href="../06BoardPaging/BoardList.jsp">회원제게시판(검색o,페이징o)</a></td></td>
				<td><a href="../DataRoom/DataList">서블릿게시판</a></td>
			</tr>
		</table>
	
</body>
</html>