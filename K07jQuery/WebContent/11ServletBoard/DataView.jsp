<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataView.jsp</title>
</head>
<body>
	<h2>자료실 - 글보기</h2>
	
	<table border=1 width=90%>
		<colgroup>
			<col width="20%" />
			<col width="30%" />
			<col width="20%" />
			<col width="30%" />
		</colgroup>
		<tr>
			<th>작성자</th>
			<td>${dto.name }</td>
			<th>작성일</th>
			<td>${dto.postdate }</td>
		</tr>
		<tr>
			<th>다운로드수</th>
			<td>${dto.downcount }</td>
			<th>조회수</th>
			<td>${dto.visitcount }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">
				${dto.title }
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3" style="height:150px;">
				${dto.content }
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">
				<c:if test="${not empty dto.ofile }">
					${dto.ofile }
					<a href="./Download?ofile=${dto.ofile }&sfile=${dto.sfile }&idx=${dto.idx}">[다운로드]</a>		
				</c:if>			
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="button" 
				onclick="location.href='./DataPassword?idx=${param.idx }&mode=edit&nowPage=${param.nowPage }';">수정하기</button>
				<button type="button" 
				onclick="location.href='../DataRoom/DataPassword?idx=${dto.idx }&mode=delete&nowPage=${param.nowPage }';">삭제하기</button>
				<button type="button" 
				onclick="location.href='./DataList?nowPage=${param.nowPage }';">목록보기</button>
			</td>
		</tr>		
</body>
</html>