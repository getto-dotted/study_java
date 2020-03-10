<%@page import="practice.BbsDTO"%>
<%@page import="practice.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 로그인 확인하기 --%>
<%@ include file="../common/isLogin.jsp"%>
<%
	String num = request.getParameter("num");
	
	BbsDAO dao = new BbsDAO(application);
	BbsDTO dto = dao.selectView(num);
	
	//작성자 확인하기
	String session_id = session.getAttribute("USER_ID").toString();
	if(!session_id.equals(dto.getId())){
%>
	<script>
		alert("작성자 본인만 수정할 수 있습니다.");
		location.href="BoardList.jsp";
	</script>
<%    
	    return;// 뒤쪽의 JSP코드가 먼저 실행되는 것을 방지
	}		
	dao.close();//DB자원반납
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정하기</title>
</head>
<body>

	<h2>회원제 게시판 - 수정하기 폼</h2>

	<form name="writeFrm" method="post" action="EditProc.jsp"
		onsubmit="return checkWrite(this);">

		<input type="hidden" name="num" value="<%=dto.getNum() %>" />

		<table border=1 width=100%>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" style="width: 90%;"
					value="<%=dto.getTitle()%>" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" style="width: 90%; height: 200px;"><%=dto.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">작성완료</button>
					<button type="reset">다시쓰기</button>
					<button type="button" onclick="location.href='BoardList.jsp';">리스트바로가기</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>