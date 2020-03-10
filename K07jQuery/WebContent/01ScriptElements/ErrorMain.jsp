<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="ErrorPage.jsp"%>
<%-- 
    errorPage 지시어 : 해당 페이지에서 에러(예외)가 발생했을때
    예외처리를 설정한 페이지에서 하겠다는 의미. 에러페이지를 사용자에게 
    보여주지 않기 때문에 사이트에 대한 신뢰를 높일 수 있다.
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ErrorMain.jsp</title>
</head>
<body>
	<%
		String age = "10살";
		//런타임 오류가 발생하는 지점.
		int afterAge = Integer.parseInt(age) + 10;
		out.print("10년후 나이는 " + afterAge + " 입니다.");
	%>

</body>
</html>