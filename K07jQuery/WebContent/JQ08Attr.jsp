<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ08Attr.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<script>
$(function(){
	/*  
	attr() : DOM객체에 속성을 부여하거나 부여된 속성값을 가져올때 사용하는 메소드
			사용법은 css()메소드와 동일하다.
			
	removeAttr() : 속성을 제거할때 사용하는 메소드
	*/

	$('#btn1').mouseover(function(){
		$('#viewImg').attr('src', './images/baseball.jpg').attr('width','400px');
	});
	
	$('#btn2').mouseover(function(){
		$('#viewImg').attr('src', './images/basketball.jpg')
			.attr('width',function(){return '450px'});
	});
	
	$('#btn3').mouseover(function(){
		$('#viewImg').attr({'src': './images/soccer.jpg','width':'500px'});
	});
	
	$('#btnDel').click(function(){
		var attrName = $('#attrSelect option:selected').val();	
		$('#viewImg').removeAttr(attrName);
		alert(attrName+'속성이 제거됨')
	});	
});
</script>
</head>
<body>
	<h2>attr(), removeAttr() 메서드</h2>
	
	<div>
		<img src="./images/basketball.jpg" id="viewImg" width="300" />
	</div>
	
	<div>
		<button id="btn1">야구 이미지로변경</button>
		<button id="btn2">농구 이미지로변경</button>
		<button id="btn3">축구 이미지로변경</button>
	</div>
	
	<div>
		<h3>위 변경 이미지를 먼저 누른후 속성제거 버튼을 누르시오</h3>
		<select id="attrSelect">
			<option value="src">src속성</option>
			<option value="width">width속성</option>
		</select>
		<button id="btnDel">속성제거</button>
	</div>	
	
</body>
</html>