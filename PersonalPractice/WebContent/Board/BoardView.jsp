<%@page import="practice.BbsDTO"%>
<%@page import="practice.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*
	  상세보기의 경우 작성자 본인이 아니더라도 열람할수 
	있어야 한다.
	  대신 수정, 삭제의 경우에만 회원인증을 통하여 작성자
	본인만 할수 있도록 처리한다.
	*/

	String num = request.getParameter("num");

	BbsDAO dao = new BbsDAO(application);

	//조회수 증가
	dao.updateVisitCount(num);

	//게시물 가져오기
	BbsDTO dto = dao.selectView(num);

	dao.close();//DB자원반납
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>본문확인</title>
<script type="text/javascript">
	function isDelete() {
		var ans = confirm("정말로 삭제하시겠습니까?");
		if (ans == true) {
			//삭제처리페이지로 전송    
			var f = document.writeFrm;
			f.action = "DeleteProc.jsp";
			f.method = "post"
			f.submit();
		}
	}
</script>
</head>
<body>
	<h2>회원제 게시판 - 상세보기</h2>

	<form name="writeFrm">

		<!-- 삭제를 위한 hidden 폼 -->
		<input type="hidden" name="num" value="<%=dto.getNum()%>">

		<table border=1 width=100%>
			<tr>
				<td>번호</td>
				<td><%=dto.getNum()%></td>
				<td>작성자</td>
				<td>
					<!--dto.getId() %> --> <%=dto.getName()%>
				</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=dto.getPostDate()%></td>
				<td>조회수</td>
				<td><%=dto.getVisitcount()%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><%=dto.getTitle()%></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3" height="200">
					<!-- textarea에서 엔터키로 줄바꿈을 하면 DB에 저장될때 \n\r 로 저장되므로, HTML에서
        			줄바꿈을 하려면 해당 문자를 <br/>로 바꿔준다. --> 
        			<%=dto.getContent().replace("\r\n", "<br/>")%>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
<%
					if (session.getAttribute("USER_ID") != null
							&& session.getAttribute("USER_ID").toString().equals(dto.getId())) {
%>
					<button type="button"
						onclick="location.href='BoardEdit.jsp?num=<%=dto.getNum()%>';">
						수정하기</button>

					<button type="button" onclick="isDelete()">삭제하기</button> 
<%
 					}
%>
					<button type="button" onclick="location.href='BoardList.jsp';">목록으로</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>