<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadAction</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<h2>파일 업로드 결과보기</h2>
	
	<a href="./uploadForm.do">파일업로드 폼 바로가기</a>
	
	<c:forEach begin="0" end="${returnObj.files.size()-1 }" var="i">
		<ul>
			<li>제목${i+1 } : ${returnObj.files[i].title }</li>
			<li>원본파일명${i+1 } : ${returnObj.files[i].originalName }</li>
			<li>저장된 파일명${i+1 } : ${returnObj.files[i].saveFileName }</li>
			<li>전체경로${i+1 } : ${returnObj.files[i].serverFullName }</li>
			<!-- servlet-context.xml에 리소스 폴더에 대해 매핑되어있음 -->
			<li><img src="../images/upload/${returnObj.files[i].saveFileName }" width="200" />
			</li>
		</ul>
	
	
	
	</c:forEach>
</body>
</html>