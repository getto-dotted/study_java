<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResponseMain</title>
</head>
<body>
	<h2>sendRedirect테스트</h2>
	<form action="ResponseSendRedirect.jsp" method="post">
		<table border="1" width='300'>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="txtid" /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="text" name="txtpwd" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="확인" /></td>
			</tr>
		</table>
	</form>

</body>
</html>