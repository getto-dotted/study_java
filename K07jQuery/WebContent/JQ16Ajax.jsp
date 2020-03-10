<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ16Ajax.jsp</title>

<script src="./js/jquery-3.4.1.js"></script>
<script>
/*  
 Ajax => Asynchronous JavaScript and XML
				(비동기식 자바스크립트와 XML)
브라우저가 가지고 있는 XMLHttpRequest 객체를 이용해서 전체 페이지를
새로고침 없이 페이지의 일부만을 위한 데이터를 로드하는 기법
즉, JavaScript를 통한 비동기 통신으로 클라이언트와
서버간에 XML데이터를 주고받는 기술이라고 할 수 있다.
사용법
	$.ajax({
		url: 요청할 URL경로
		type : 요청시 전송방식(post or get),
		contentType : 컨텐츠 타입(post와 get은 타입이 다름),
		data : 요청시 전송할 파라미터. JSON형태로 조립해야 함.
		dataType : 콜백데이터의 타입(html, text, json, xml, script),
		success : 요청성공시 콜백 함수,
		error : 요청실패시 콜백 함수		
	});
 ajax()함수 사용시 필요없는 속성은 생략해도 된다.
 
 콜백함수를 정의하는 방법
 	1.익명함수로 정의 : 
 		success : function(){
 			함수몸체
 		}
 	2.JS외부함수로 정의
 		-단 이때 함수 호출시 함수의 이름만을 기술해야 한다.
 		success : 함수명
*/
$(function(){
	
	$.ajax({
		url: './common/JsData.js',
		type : 'get',
		contentType : "text/html;charset:utf-8",
		dataType : "script",
		success : function(resData){
			MyAlert("Hello","AJAX");
		},
		error : errFunc		
	});
	$('#ajaxBtn').click(function(){
		$.ajax({
			url: './common/PrintToday.jsp',
			dataType : "html",
			type : "get",
			contentType : "text/html;charset:utf-8",
			data : {
				msg : $(this).text(),
				varStr : "$.ajax()메소드 열라 짱조아효"
			},
			success : sucFunc,
			error : errFunc		
		});
	});
	
	$('#ajaxBtn2').click(function(){
		$.ajax({
			url: './common/PrintToday.jsp',
			dataType : "html",
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset:utf-8",
			data : {
				msg : $(this).text(),
				varStr : "$.ajax()메소드 POST 짱조아효"
			},
			success : sucFunc,
			error : errFunc		
		});
	});
});
function errFunc(){
	alert("에러발생. 디버깅하세욤.");
}
function sucFunc(resData){
	alert("$.ajax()메소드 요청성공");
	$('#ajaxDisplay').html(resData);
}
</script>
</head>
<body>
	
	<h2>$.ajax() 메소드 사용하기</h2>
	
	<button id="ajaxBtn">ajax(get)메소드실행하기</button>
	<button id="ajaxBtn2">ajax(post)메소드실행하기</button>
	
	<div id="ajaxDisplay">
		ajax결과를 여기에 디스플레이
	</div>
	
</body>
</html>