<%@page import="util.PagingUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="practice.BbsDTO"%>
<%@page import="java.util.List"%>
<%@page import="practice.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//한글처리
	request.setCharacterEncoding("UTF-8");

	BbsDAO dao = new BbsDAO(application);

	//매개변수 저장을 위한 컬렉션 생성(DAO로 전달)
	Map<String, Object> param = new HashMap<String, Object>();

	//폼값받기(검색관련)
	String searchColumn = request.getParameter("searchColumn");
	String searchWord = request.getParameter("searchWord");

	//입력한 검색어가 있다면 맵에 추가함
	param.put("Column", searchColumn);
	param.put("Word", searchWord);
	
	String queryStr = "";

	if(searchWord != null) {		
		//파라미터 추가
		/* queryStr = String.format("searchColumn=%s" + "&searchWord=%s&", searchColumn, searchWord); */
		queryStr = "searchColumn="+searchColumn+"&searchWord="+searchWord+"&";
	} 
	else {//파라미터가 아예 없는 경우(첫진입 시)
		searchColumn="";
		searchWord="";
	}

	//페이지 처리를 위한 로직 시작
	//1.게시판 테이블의 전체 레코드 갯수 구하기
	int totalRecordCount = 
	    dao.getTotalRecordCount(param); 

	//2.web.xml에 설정된 값 가져오기
	int pageSize = Integer.parseInt(
	    application.getInitParameter("PAGE_SIZE"));
	int blockPage = Integer.parseInt(
	    application.getInitParameter("BLOCK_PAGE"));

	//3.전체페이지수 계산하기
	int totalPage =  
	(int)Math.ceil((double)totalRecordCount/pageSize);

	//4.페이지번호가 없는경우 무조건 1로 설정
	int nowPage = 
	  request.getParameter("nowPage")==null
	  ? 1 : 
	  Integer.parseInt(request.getParameter("nowPage"));

	//5.가져올 레코드의 구간을 결정하기 위한 연산
	int start = (nowPage-1)*pageSize + 1;
	int end = nowPage * pageSize;

	//6.파라미터 전달을 위해 map에 추가
	param.put("start", start);
	param.put("end", end);

	/////게시판 페이지 처리 로직 끝

	//기존 리스트에서는 파라미터가 없으나 여기서는 파라미터를 DAO로 넘겨줘야 한다.
	List<BbsDTO> bbs = dao.selectList(param);

	dao.close();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<%-- include지시어를 통해 외부파일 포함시킴 --%>
	<%@include file="../common/CommonLink.jsp"%>
	<h2>회원제 게시판(검색O, 페이징O) - 목록보기(List)</h2>


	<!-- 검색폼 -->
	<form method="get">
		<table border="1" width="100%">
			<tr>
				<td align="center"><select name="searchColumn">
						<option value="title"
							<%=(searchColumn.equals("title")) ? "selected":"" %>>제목</option>
						<option value="content"
							<%=(searchColumn.equals("content")) ? "selected":"" %>>내용</option>
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
	<table border="1" width="100%">
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>

		<!--게시물 번호를 일련번호로  -->
		<%-- <%
			if (bbs.isEmpty()) {//컬렉션에 저장된 데이터가 없는경우
		%>
		<tr>
			<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
		</tr>
		<%
			} else {
				//컬렉션에 저장된 데이터가 있는경우 for-each문을통해 내용 출력    
				for (BbsDTO dto : bbs) {
		%>
		
		<!-- 리스트반복 -->
		<tr>
			<td><%=dto.getNum()%></td>
			<td><a href="BoardView.jsp?num=<%=dto.getNum()%>"> <%=dto.getTitle()%></a>
			</td>
			<td><%=dto.getId()%></td>
			<td><%=dto.getVisitcount()%></td>
			<td><%=dto.getPostDate()%></td>
		</tr>
		
		
		
		<!-- 리스트반복 -->
		<%
			} //for-each문 끝
			} //if문 끝
		%>
	</table> --%>

		<!-- 게시물 번호를 일련번호 대신 가상번호를 생성하여 출력하기 -->
<%
	if(bbs.isEmpty()){
	    //컬렉션에 저장된 데이터가 없는경우
%>
			<tr>
				<td colspan="5" align="center">등록된 게시물이 없습니다^^*</td>
			</tr>
<%
	}
	else{
	    //컬렉션에 저장된 데이터가 있는경우 for-each문을통해
	    //내용 출력
	    int vNum = 0;
	    int countNum = 0;
	    for(BbsDTO dto : bbs)
	    {
	        //게시물의 번호를 순서대로 출력하기위한 가상번호 생성(게시물의 갯수를 기준)
	        vNum = totalRecordCount - 
	            (((nowPage-1)*pageSize)+countNum++);
	        /*
	        전체게시물수 : 121개
	        현재페이지 : 1
	        페이지사이즈 : 10
	        1페이지일때 
	            1번게시물 : 121 - (((1-1)*10) + 0) => 121
	            2번게시물 : 121 - (((1-1)*10) + 1) => 120
	        2페이지일때 
	            1번게시물 : 121 - (((2-1)*10) + 0) => 111
	            2번게시물 : 121 - (((2-1)*10) + 1) => 110
	        */
%>
		<!-- 리스트반복 -->
		<tr>
			<td>
				<%-- <%=dto.getNum() %> --%> <%=vNum %>
			</td>
			<td><a href="BoardView.jsp?num=<%=dto.getNum()%>"> <%=dto.getTitle() %>
			</a></td>
			<td>
				<%-- <%=dto.getId() %> --%> <%=dto.getName() %>
			</td>
			<td><%=dto.getVisitcount() %></td>
			<td><%=dto.getPostDate() %></td>
		</tr>
		<!-- 리스트반복 -->
<%
	    }//for-each문 끝
	}//if문 끝
%>
	<!-- 페이지 번호 출력되는 부분에 추가하기 -->
	<table border=1 width="100%">
		<tr>
			<td align="center">
				<!-- <img src="../images/paging1.gif" alt="" />
			            <img src="../images/paging2.gif" alt="" />            
			            1 2 3 4 5 6 7 8 9 10
			            <img src="../images/paging3.gif" alt="" />
			            <img src="../images/paging4.gif" alt="" /> --> 
         			<%=PagingUtil.pagingImg(totalRecordCount, pageSize, blockPage, nowPage, "BoardList.jsp?"+queryStr) %>
			</td>
		</tr>
	</table>
</body>
</html>