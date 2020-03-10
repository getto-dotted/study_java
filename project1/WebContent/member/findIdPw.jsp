<%@page import="dataObject.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#wrap {
	width: 490px;
	text-align: center;
	margin: 0 auto 0 auto;
}

#chk {
	text-align: center;
}

#cancelBtn {
	visibility: visible;
}

#useBtn {
	visibility: hidden;
}
</style>
<meta charset="UTF-8">
<title> </title>
</head>
<script>

function findId(){
	document.findId.method="post";
    document.findId.action="find.jsp";
}
function findPw(){
	document.findPw.method="post";
    document.findPw.action="find.jsp";
}

</script>
<body>
	<div id="wrap">
		<br> <b><font size="4" color="gray">아이디 찾기</font></b>
		<hr size="1" width="460">
		<br>
		<div id="chk">

			<form name="findId" method="post" onsubmit="findId();" action="find.jsp">
				<span style="font-weight: bold;">이름 &nbsp&nbsp<input type="text" name="name" id="memberName"></span>
				<br />
				<span style="font-weight: bold;">E-Mail &nbsp&nbsp<input type="text" name="email" id="memberEmail"></span>			
				<br /> 
				<input type="submit" value="아이디 찾기">
			</form>
			
<br> <b><font size="4" color="gray">비밀번호 찾기</font></b>
		<hr size="1" width="460">
		<form name="findPw" method="post" onsubmit="findPw();" action="find.jsp">
				<span style="font-weight: bold;">ID &nbsp&nbsp<input type="text" name="id" id="memberName2"></span>
				<br />
				<span style="font-weight: bold;">이름 &nbsp&nbsp<input type="text" name="name2" id="memberName2"></span>
				<br /> 
				<span style="font-weight: bold;">E-Mail &nbsp&nbsp<input type="text" name="email2" id="memberEmail2"></span>			
				<br />
				<input type="submit" value="비밀번호 찾기">
				<br /> 
			</form>
			
			<br> <input id="cancelBtn" type="button" value="취소" onclick="window.close()"><br> 
		</div>
	</div>
</body>
</html>
