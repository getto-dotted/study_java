<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       


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

<form enctype="multipart/form-data">
<table class="table table-bordered">
<colgroup>
	<col width="20%"/>
	<col width="30%"/>
	<col width="20%"/>
	<col width="*"/>
</colgroup>
<tbody>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">작성자</th>
		<td>
			${dto.name }
		</td>
		<th class="text-center" 
			style="vertical-align:middle;">작성일</th>
		<td>
			${dto.postdate }
		</td>
	</tr>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">이메일</th>
		<td>
			${dto.email }
		</td>
		<th class="text-center" 
			style="vertical-align:middle;">조회수</th>
		<td>
			${dto.visitcount }
		</td>
	</tr>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">제목</th>
		<td colspan="3">
			${dto.title }
		</td>
	</tr>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">내용</th>
		<td colspan="3">
			${dto.content }
		</td>
	</tr>
	<tr>
		<th class="text-center" style="vertical-align:middle;">업로드된 사진</th>
		<td colspan="3">
		<c:choose>		<c:when test="${dto.sfile != null}">
			<img src="../Upload/${dto.sfile }" width="300px">
		</c:when>
		<c:otherwise>
			<span></span>
		</c:otherwise>
		</c:choose>
		
		</td>
	</tr>	
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">첨부파일</th>
		<td colspan="3">
			<c:if test="${not empty dto.ofile }">
					${dto.ofile }
					<a href="./Download?ofile=${dto.ofile }&sfile=${dto.sfile }&idx=${dto.idx}">[다운로드]</a>		
				</c:if>		
		</td>
	</tr>
</tbody>
</table>

<div class="row text-center" style="">
	<!-- 각종 버튼 부분 -->
	<button type="button" class="btn btn-primary" method="post" onclick="location.href='./sub01_Iden?idx=${param.idx }&mode=edit&nowPage=${param.nowPage }';">수정하기</button>
	<button type="button" class="btn btn-success" method="post" onclick="location.href='../notice/sub01_Iden?idx=${dto.idx }&mode=delete&nowPage=${param.nowPage }';">삭제하기</button>	
	<button type="button" class="btn btn-warning" 
		onclick="location.href='./sub01_list2?nowPage=${param.nowPage }';">리스트보기</button>
</div>
</form> 

				</div>
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>


	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>