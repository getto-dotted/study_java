<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>	
<script>
function deleteRow(idx){
	
	if(confirm('정말로 삭제하시겠습니까?')){
		location.href='delete.do?idx='+idx;
	}	
}
</script>
<div class="container">
	<h3 class="text-center">방명록(한줄게시판)</h3>
	
<div class="row">
  		<div class="col-sm-5 col-xl-5">
		  	<form name="searchForm">
		  	<div class="input-group mb-3">
		  		<select name="searchColumn" id="searchColumn" class="form-control">
		  			<option value="contents">내용</option>
		  		</select>
				<input type="text" class="form-control" placeholder="검색어입력"
					name="searchWord" id="searchWord">
				<input type="text" class="form-control" placeholder="start idx값"
					name="startIdx" id="startIdx">
				<input type="text" class="form-control" placeholder="end idx값"
					name="endIdx" id="endIdx">
				<div class="input-group-append">
				  <button class="btn btn-success" type="submit">Go</button>
				</div>
			</div>
			</form>  		
  		</div>
  		<div class="col-sm-7 col-xl-7">
			<div class="text-right">
				<c:choose>
					<c:when test="${not empty sessionScope.siteUserInfo }">
						<button class="btn btn-danger"
							onclick="location.href='logout.do';">로그아웃
						</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-info" 
							onclick="location.href='login.do';">로그인
						</button>		
					</c:otherwise>
				</c:choose>	 
					 
				&nbsp;&nbsp;
				<button class="btn btn-success" 
					onclick="location.href='write.do';">
					방명록쓰기
				</button>
			</div>  		
  		</div>
  	</div>

		
	<!-- 방명록 반복 부분 s -->

		<c:forEach items="${lists }" var="row">	 
		<div class="border mt-2 mb-2">
			<div class="media">
				<div class="media-left mr-3">
					<img src="../images/img_avatar3.png" class="media-object" style="width:60px">
				</div>
				<div class="media-body">
					<h4 class="media-heading">작성자:${row.name }(${row.id })</h4>
					<p>${row.contents }</p>
				</div>	  
				<!--  수정,삭제버튼 -->
				<div class="media-right">
					<!-- 작성자 본인에게만 수정/삭제 버튼 보임 -->
					<c:if test="${sessionScope.siteUserInfo.id eq row.id }">		
						<button class="btn btn-primary" onclick="location.href='modify.do?idx=${row.idx}';">수정</button>
						<button class="btn btn-danger" onclick="javascript:deleteRow(${row.idx});">삭제</button>
					</c:if>
					
				</div>
			</div>
		</div>	 
	</c:forEach>	
	<!-- 방명록 반복 부분 e -->
	<ul class="pagination justify-content-center">
		${pagingImg }
	</ul>
</div>
</body>
</html>
