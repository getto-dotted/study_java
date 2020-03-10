<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ01Start.jsp</title>
<!-- jQuery Core 라이브러리 파일을 로컬에 다운로드 후 링크 -->
<script src="./js/jquery-3.4.1.js"></script>
<!-- 구글 CDN을 통해 링크 -->
<!-- CDN(Contents Delivery Network)
		: 지리적 물리적으로 떨어져 있는 사용자에게  컨텐츠 제공자의 컨텐츠를 
			더 빠르게 제공할 수 있는 기술을 말한다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
/*  
 jQuery의 출발점으로 해당 HTML문서의 내용이 모두 로드된 이후 실행된다.
 JS의 load이벤트와 비슷하다. 따라서 DOM을 선택하기 위해
 jQuery는 문서위치에 상관없이 기술이 가능하다.
 
 jQuery시작하기 : 총4가지 방법이 있음.
 */
$(document).ready(function(){
	alert('jQuery시작하기1');
});
$().ready(function(){
	alert('jQuery시작하기2');
});
jQuery(function(){
	alert('jQuery시작하기3');
});
$(function(){
	alert('jQuery시작하기4');
});


</script>
</head>
<body>

</body>
</html>