<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResponseSendRedirect</title>
</head>
<body>
	<%
		//폼값받기
		String id = request.getParameter("txtid");
		String pwd = request.getParameter("txtpwd");

		if (id.equalsIgnoreCase("koreavc") && pwd.equalsIgnoreCase("1234")) {
			response.sendRedirect("../common/Welcome.jsp");
		} else {
	%>
	<script type="text/javascript">
		alert("아이디와 패스워드가 일치하지 않습니다.");
		history.go(-1);
	</script>
	<%
		}
	%>

</body>
</html>