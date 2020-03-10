<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ07Effect.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<script>
$(function(){
	/*  
	toggle() : 보임/숨김 처리가 번갈아가면서 진행된다. 
	show() : 엘리먼트를 보임 처리한다.
	hide() : 엘리먼트를 숨김 처리한다.
	※메소드의 인자로 1/1000초단위의 시간을 주게되면 해당 시간만큼
	애니메이션 효과가 적용된다.
	*/
	
	$('#btn1').click(function(){
		$('#title').toggle();
	});
	$('#btn1_s').click(function(){
		$('#title').show();
	});
	$('#btn1_h').click(function(){
		$('#title').hide(1000);
	});
	
	$('#btn2').click(function(){
		$('#content').toggle();
	});
	$('#btn2_s').click(function(){
		$('#content').show(2000);
	});
	$('#btn2_h').click(function(){
		$('#content').hide(1000);
	});		
});

$(function(){
	$('#btn3').click(function(){
		$('#box1').fadeIn();
		$('#box2').fadeIn('slow');
		$('#box3').fadeIn(3000);
	});
	$('#btn4').click(function(){
		$('#box1').fadeOut();
		$('#box2').fadeOut('fast');
		$('#box3').fadeOut(3000);
	});
	$('#btn5').click(function(){
		$('#box1').fadeToggle();
		$('#box2').fadeToggle('normal');
		$('#box3').fadeToggle(3000);
	});
});
</script>
<style>
	#title{
		border:1px solid red; width:300px; height:50px;
		color:red;
	}
	#content{
		border:1px solid blue; width:300px; height:300px;
		color:blue;
	}
	#box1, #box2, #box3{
		width:100px; height:100px; display:none;
	}
</style>

</head>
<body>
	<h2>show() / hide() / toggle()</h2>
	<div>
		<button id="btn1">제목토글</button>
		<button id="btn1_s">제목보임</button>
		<button id="btn1_h">제목숨김(1초)</button>
		
		<button id="btn2">내용토글</button>
		<button id="btn2_s">내용보임(2초)</button>
		<button id="btn2_h">내용숨김(1초)</button>
	</div>	
	<div id="title">기사 제목 부분입니다.</div>
	<div id="content">
		기사 내용 부분입니다 <br />
		기사 내용 부분입니다 <br />
		기사 내용 부분입니다 <br />
		기사 내용 부분입니다 <br />
		기사 내용 부분입니다 <br />
		기사 내용 부분입니다 <br />
		기사 내용 부분입니다 <br />
		기사 내용 부분입니다 <br />
	</div>
	
	<h2>fadeIn() / fadeOut() / fadeToggle()</h2>
	<p>
		<button id="btn3">페이드인</button>
		<button id="btn4">페이드아웃</button>
		<button id="btn5">페이드토글</button>
	</p>	
	<div id="box1" style="background-color:red;">파란박스</div>
	<div id="box2" style="background-color:blue;">빨간박스</div>
	<div id="box3" style="background-color:green;">녹색박스</div>
	
	
</body>
</html>