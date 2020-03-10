<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.BbsDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//한글깨짐 방지
	request.setCharacterEncoding("UTF-8");

	String drv = application.getInitParameter("JDBCDriver");
	String url = application.getInitParameter("ConnectionURL");
	
	/*  
	Model로 전달할 파라미터를 저장할 용도로 생성한 맵 컬렉션.
	여러개의 파라미터를 한꺼번에 저장한 후 전달하기 위한 용도로 사용한다.
	*/
	Map<String, Object> param = new HashMap<String, Object>();	
	
	
	//검색을 위한 폼값받기
	String searchColumn = request.getParameter("searchColumn");
	String searchWord = request.getParameter("searchWord");
	
	//검색필드, 검색어 맵에 추가
	param.put("Column", searchColumn);
	param.put("Word", searchWord);
	
	//생성자1을 통해 DB연결
	BbsDAO dao = new BbsDAO(drv, url);
	//board테이블에 입력된 레코드 가져오기. 파라미터 전달됨
	List<BbsDTO> bbs = dao.selectList(param);
	//자원반납
	dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList.jsp-게시판 목록</title>
</head>
<body>
	<%-- include지시어를 통해 외부파일 포함시킴 --%>
	<%@include file="../common/CommonLink.jsp"%>
	<h2>회원제 게시판(검색O, 페이징X) - 목록보기(List)</h2>


	<!-- 검색폼 -->
	<form method="get">
		<table border="1" width="90%">
			<tr>
				<td align="center"><select name="searchColumn">
						<option value="title">제목</option>
						<option value="content">내용</option>
				</select> <input type="text" name="searchWord" /> <input type="submit"
					value="검색하기" /></td>
			</tr>
		</table>
	</form>

	<!-- 글쓰기버튼 -->
	<table border="1" width="90%">
		<tr>
			<td align="right">
				<button type="button" onclick="location.href='BoardWrite.jsp';">글쓰기</button>
			</td>
		</tr>
	</table>

	<!-- table>tr*2>td*5 -->
	<table border="1" width="90%">
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>
		<%
			//컬렉션에 저장된 데이터가 없으면 true를 반환하는 isEmpty()로 출력할 레코드가 있는지 확인
			if (bbs.isEmpty()) {
		%>
		<tr>
			<td colspan="5" align="center">등록된 게시물이 없습니다^^*</td>
		</tr>
		<%
			} else {
				//출력할 게시물이 있는 경우 foreach문을 통해 반복하면서 리스트 출력
				for (BbsDTO dto : bbs) {
					//각 항목은 getter()를 통해 출력
		%>

		<!-- 리스트반복 -->
		<tr>
			<td><%=dto.getNum()%></td>
			<td><a href="BoardView.jsp?num=<%=dto.getNum()%>"><%=dto.getTitle()%></a>
			</td>
			<td><%=dto.getId()%></td>
			<td><%=dto.getVisitcount()%></td>
			<td><%=dto.getpostdate()%></td>
		</tr>
		<!-- 리스트반복 -->
		<%
			} //for-dach문 끝
			} //if문 끝
		%>
	</table>
	<!-- 페이지번호 -->
	<table border="1" width="90%">
		<tr>
			<td align="center">
				<img src="../images/paging1.gif" alt="" />
				<img src="../images/paging2.gif" alt="" />
				1 2 3 4 5 
				<img src="../images/paging3.gif" alt="" />
				<img src="../images/paging4.gif" alt="" />
			</td>
		</tr>
	</table>
	

</body>
</html>