<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
		function checkValidate(f) {
			if (f.name.value == "") {
				alert("이름을 입력하세요");
				f.name.focus();
				return false;
			}
			if (f.pass.value == "") {
				alert("패스워드를 입력하세요");
				f.pass.focus();
				return false;
			}
			if (f.title.value == "") {
				alert("제목을 입력하세요");
				f.title.focus();
				return false;
			}
			if (f.content.value == "") {
				alert("내용을 입력하세요");
				f.content.focus();
				return false;
			}
		}
	</script>

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
					<img src="../images/space/sub05_title.gif" alt="정보자료실" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린공간&nbsp;>&nbsp;정보자료실<p>
				</div>
				<div>

<form name="writeFrm" method="post" action="../info/Edit"
		enctype="multipart/form-data" onsubmit="return checkValidate(this);">
<table class="table table-bordered">
<!-- 수정처리를 위한 파라미터 : 일련번호, 페이지번호 -->
		<input type="hidden" name="idx" value="${dto.idx }"/>
		<input type="hidden" name="nowPage" value="${param.nowPage }"/>
<colgroup>
	<col width="20%"/>
	<col width="*"/>
</colgroup>
<tbody>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">작성자</th>
		<td>
			<input type="text" class="form-control" 
				style="width:100px;" name="name" value="${dto.name }" />
		</td>
	</tr>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">이메일</th>
		<td>
			<input type="text" class="form-control" 
				style="width:400px;" name="email" value="${dto.email }" />
		</td>
	</tr>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">패스워드</th>
		<td>
			<input type="password" class="form-control" 
				style="width:200px;" name="pass" value="${dto.pass }" />
		</td>
	</tr>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">제목</th>
		<td>
			<input type="text" class="form-control" name="title" value="${dto.title }" />
		</td>
	</tr>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">내용</th>
		<td>
			<textarea rows="10" class="form-control" name="content">${dto.content }</textarea>
		</td>
	</tr>
	<tr>
		<th class="text-center" 
			style="vertical-align:middle;">첨부파일</th>
		<td>
			<input type="file" name="attachedfile" class="form-control" />
		</td>
	</tr>
</tbody>
</table>

<div class="row text-center" style="">
	<!-- 각종 버튼 부분 -->
	
	<button type="submit" class="btn btn-danger">작성완료</button>
	<button type="reset" class="btn">Reset</button>
	<button type="button" class="btn btn-warning" 
		onclick="location.href='../info/List';">리스트보기</button>
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