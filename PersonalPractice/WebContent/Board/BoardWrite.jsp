<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
 <!-- 글쓰기 페이지의 경우는 순수 HTML폼만 있다. 별도의 JSP처리는 필요없다. -->
<body>
	<h2>글 작성하기</h2>
	
		<form name="writeFrm" method="post" action="WriteProc.jsp" onsubmit="return checkWrite(this);">
			<table border=1 width=100%>
				<tr>
				    <td>제목</td>
				    <td>
				        <input type="text" name="title" style="width:90%;" />
				    </td>
				</tr>
				<tr>
				    <td>내용</td>
				    <td>
				        <textarea name="content" style="width:90%;height:200px;"></textarea>
				    </td>
				</tr>
				<tr>
				    <td colspan="2" align="center">
				        <button type="submit">작성완료</button>
				        <button type="reset">다시쓰기</button>
				        <button type="button" onclick="location.href='BoardList.jsp';">목록으로</button>
				    </td>
				</tr>
			</table>    
		</form>
</body>
</html>