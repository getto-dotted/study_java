<%@page import="model.BbsDTO"%>
<%@page import="model.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*  
	게시글 상세보기는 회원이 아니라도 자유롭게 열람할 수
	있어야 하므로, 회원인증(로그인) 없이도 접근할 수 있다.
	단, 수정과 삭제는 본인만 가능하도록 처리해야 한다.
	*/
	String num = request.getParameter("num");
	BbsDAO dao = new BbsDAO(application);
	//조회수 증가
	dao.updateVisitCount(num);
	//파라미터로 전달된 일련번호에 해당하는 게시물을 가져옴
	BbsDTO dto = dao.selectView(num);

	dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardView.jsp-게시물읽기</title>
</head>
<body>
	<h2>회원제 게시판 - 상세보기</h2>
	<script>
		function isDelete() {
			var c = confirm("정말로 삭제하시겠습니까?");
			if (c) {
				var f = document.writeFrm;
				f.method = "post";
				f.action = "DeleteProc.jsp";
				f.submit();
			}
		}
	</script>
	<form name="writeFrm">
		<!-- 해당 게시물의 일련번호 : 삭제시 사용함 -->
		<input type="hidden" name="num" value="<%=num%>" />
		<table border=1 width=800>
			<tr>
				<td>번호</td>
				<td><%=dto.getNum()%></td>
				<td>작성자</td>
				<td><%=dto.getId()%></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=dto.getpostdate()%></td>
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
					<!-- textarea에서 엔터키로 줄바꿈을 하면 DB에 저장될때
				\r\n으로 저장되므로, HTML에서 출력할때는 <br>태그로 변경해준다. --> <%=dto.getContent().replace("\r\n", "<br/>")%>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<%
						/* 로그인이 완료된 상태이면서 동시에 해당 게시물의 작성자
						(세션에 저장된 아이디==작성자 아이디)일 경우 수정, 삭제버튼이 보이게 처리*/
						if (session.getAttribute("USER_ID") != null
								&& session.getAttribute("USER_ID").toString().equals(dto.getId())) {
					%>

					<%
 	}
 %>
					<button type="button"
						onclick="location.href='BoardEdit2.jsp?num=<%=dto.getNum()%>';">
						수정하기</button>
					<button type="button" onclick="isDelete();">삭제하기</button> 


					<button type="button" onclick="location.href='BoardList.jsp';">
						리스트바로가기</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>