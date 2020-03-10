<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ include file="../include/global_head.jsp" %>


 <body>
	<center>
	<div id="wrap">
		<%@ include file="../include/top.jsp" %>

		<img src="../images/space/sub_image.jpg" id="main_visual" />

		<div class="contents_box">
			<div class="left_contents">
				<%@ include file = "../include/space_leftmenu.jsp" %>
			</div>
			<div class="right_contents">
				<div class="top_title">
					<img src="../images/space/sub01_title.gif" alt="공지사항" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린공간&nbsp;>&nbsp;공지사항<p>
				</div>
				<div>

<div class="row text-right" style="margin-bottom:20px;
		padding-right:50px;">
<!-- 검색부분 -->
<form class="form-inline">	
	<div class="form-group">
		<select name="searchColumn" class="form-control">
			<option value="title" ${map.Column=="title" ? "selected" : ""}>제목</option>
			<option value="name" ${map.Column=="name" ? "selected" : ""}>작성자</option>
			<option value="content" ${map.Column=="content" ? "selected" : ""}>내용</option>
		</select>
	</div>
	<div class="input-group">
		<input type="text" name="searchWord"  class="form-control"/>
		<div class="input-group-btn">
			<button type="submit" class="btn btn-default">
				<i class="glyphicon glyphicon-search"></i>
			</button>
		</div>
	</div>
</form>	
</div>
<div class="row">
	<!-- 게시판리스트부분 -->
	<table class="table table-bordered table-hover">
	<colgroup>
		<col width="80px"/>
		<col width="*"/>
		<col width="120px"/>
		<col width="120px"/>
		<col width="80px"/>
		<col width="50px"/>
	</colgroup>
	
	<thead>
	<tr class="success">
		<th class="text-center">번호</th>
		<th class="text-left">제목</th>
		<th class="text-center">작성자</th>
		<th class="text-center">작성일</th>
		<th class="text-center">조회수</th>
		<th class="text-center">첨부</th>
	</tr>
	</thead>
	
	<tbody>
	<!-- 리스트반복 -->
	<tr>
		<c:choose>
			<c:when test="${empty lists }">
				<tr>
					<td colspan="6">등록된 게시물이 없습니다.</td>
				</tr>		
			</c:when>
			<c:otherwise>
				<c:forEach items="${lists }" var="row" varStatus="loop">
					<tr>
						<!-- 일반적으로 게시판 리스트의 No부분에는 일련번호(idx)를 사용하지 않고
						전체 레코드수를 통한 가상번호를 출력하게 된다. 게시물이 100개라면
						가상번호는 100부터 99,98 순으로 부여된다. -->
						<td>${map.totalCount-(((map.nowPage-1)*map.pageSize)+loop.index) }</td>
						<td><a href="../notice/sub01_view2?idx=${row.idx }&nowPage=${param.nowPage }">${row.title }</a></td>
						<td>${row.name }</td>
						<td>${row.postdate }</td>
						<td>${row.visitcount }</td>
						<td align="center">
							<c:if test="${not empty row.ofile }">
								<a href="./Download?ofile=${row.ofile }&sfile=${row.sfile }&idx=${row.idx }">
								<img src="../images/disk.png" width="20" alt="" /></a>
							</c:if>
						</td>
					</tr>
				</c:forEach>		
			</c:otherwise>
		</c:choose>
	</tr>
	</tbody>
	</table>
</div>
<div class="row text-center" style="padding-right:50px;">
	<!-- 각종 버튼 부분 -->
	<!-- <button type="reset" class="btn">Reset</button> -->
		<!-- 관리자일때만 보여야 함  -->
		
<%
	//세션영역에 USER_ID 속성값이 없는 경우(로그아웃 상태)
	if (session.getAttribute("USER_ID") == null) {} 
	else{
	/* 세션영역에 USER_ID 속성값이 있지만 관리자가 아닌경우*/
		if(session.getAttribute("grade").toString().equals("0") || session.getAttribute("grade") == null){}
	/* 세션영역에 USER_ID 속성값이 있고 관리자인 경우 */
		else {	
		%>
	<button type="button" class="btn btn-default" onclick="location.href='sub01_write2';">글쓰기</button>
		<%
		}
	}
	%>	
	<!-- <button type="button" class="btn btn-primary">수정하기</button>
	<button type="button" class="btn btn-success">삭제하기</button>
	<button type="button" class="btn btn-info">답글쓰기</button>
	<button type="button" class="btn btn-warning">리스트보기</button>
	<button type="submit" class="btn btn-danger">전송하기</button> -->
</div>
<div class="row text-center">
	<!-- 페이지번호 부분 -->
	
		${map.pagingImg }
		
</div>

				</div>
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>


	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>