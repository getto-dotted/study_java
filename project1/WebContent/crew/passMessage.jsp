<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:choose>
	<c:when test="${param.mode=='edit' }">
		<c:set var = "moveUrl" value="/crew/Edit?idx=${param.idx }&nowPage=${requestScope.nowPage }"/>
	</c:when>
	<c:otherwise>
		<c:set var = "moveUrl" value="/crew/Delete?idx=${param.idx }&nowPage=${requestScope.nowPage }"/>
	</c:otherwise>
</c:choose>   

<script>
	<c:choose> 
	<c:when test="${PASS_CORRECT }">
		alert("본인확인 완료");
		location.href="<c:url value='${moveUrl}' />";
	</c:when>
	<c:otherwise>
		alert("아이디와 비밀번호를 확인해 주세요");
		history.back();
		//history.go(-1); 뒤로가기
	</c:otherwise>
	</c:choose>
</script>