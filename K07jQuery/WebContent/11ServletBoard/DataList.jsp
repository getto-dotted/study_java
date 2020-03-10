<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataList.jsp</title>
</head>
<body>
	<!-- 액션태그를 통한 외부파일 인클루드 -->
	<%@ include file="../common/CommonLink.jsp"%>
	
	
	
	<h2>
		자료실 - 목록[${map.Column==null || map.Column=="" ||map.Word=="" ? "총 " : "검색된 " }게시물수:${map.totalCount }]
		[${map.nowPage } / ${map.totalPage } 페이지]
	</h2>

	<!-- 검색폼 -->
	<form method="get">
		<table border="1" width="90%">
			<tr>
				<td align="center">
				<!-- 검색시 선택한 항목이 유지되게 처리 -->
				<select name="searchColumn">
						<option value="title" ${map.Column=="title" ? "selected" : ""}>제목</option>
						<option value="content" ${map.Column=="content" ? "selected" : ""}>내용</option>
				</select> 
				<input type="text" name="searchWord" /> 
				<input type="submit" value="검색하기" /></td>
			</tr>
		</table>
	</form>

	<!-- 글쓰기버튼 -->
	<table border="1" width="90%">
		<tr>
			<td align="right">
				<button type="button" onclick="location.href='./DataWrite';">글쓰기</button>
			</td>
		</tr>
	</table>
	<!-- 리스트 반복출력 -->
	<table border="1" width="90%">
		<tr>
			<th width="10%">번호</th>
			<th width="*">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
			<th width="5%">첨부</th>
		</tr>	
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
						<td><a href="../DataRoom/DataView?idx=${row.idx }&nowPage=${param.nowPage }">${row.title }</a></td>
						<td>${row.name }</td>
						<td>${row.visitcount }</td>
						<td>${row.postdate }</td>
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
	</table>
	<!-- 페이지번호 -->
	<table border="1" width="90%">
		<tr>
			<td align="center">
				${map.pagingImg }
			</td>
		</tr>
	</table>
</body>
</html>