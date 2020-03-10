<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ05OnOff.jsp</title>
<style>
	div{
		width:200px; height:50px; margin:20px;	
	}
</style>
<script src="./js/jquery-3.4.1.js"></script>
<script>
$(function(){
	/*  
	on() : 기본 사용법은 bind()와 동일하며 엘리먼트에 이벤트를
			부여할때 사용한다. 다른점은 동적으로 생성된(물리적으로 존재하지 않는)
			엘리먼트에도 이벤트를 부여할 수 있다.
	off() : on()으로 부여한 이벤트를 제거한다.
	*/
	$("#onMethod").on("click", function(){
		alert("#onMethod 버튼이 클릭되었습니다.");
	});
	
	$('#offMethod').on('click',function(){
		$('#onMethod').off("click");
		alert("#onMethod의 click이벤트가 해제되었습니다.")
	});
	
	$('#div1').on('click',function(){
		alert('클릭이벤트 발생됨');
		$(this).after("<div style='background-color:green;'>동적으로 생성한 div</div>");
	});//after() : 선택된 요소 다음에 해당 컨텐츠를 추가한다.
	/* 
	 버튼을 클릭했을때 ul태그 하위에 li태그부분이 추가된다.
	 동적으로 추가된 li태그에 click이벤트를 부여해서 color와 size를 변경시킨다.
	 (개발자도구에서 추가되는 엘리먼트 확인)*/
	$(".div2 button").on("click",function(){
		$(".div2 ul").append("<li>추가된 li 태그</li>");
	});//append() : 선택된 요소 뒷부분에 컨텐츠를 추가한다.
	$(".div2").on("click","li",function(){
		$(this).css("color","red").css("fontSize","1.8em");
	});
	
	
});
</script>
</head>
<body>
	<h2>on() / off() 메소드</h2>
	
	<div id="div1" style="background-color:red;">
		미리 생성한 div(요기를 눌러보삼)
	</div>
	
	<button id="onMethod">on()메소드호출</button>
	<button id="offMethod">off()메소드호출</button>
	
	<div class="div2">
		<button>아이템추가하기</button>
		<ul>
			<li>기존아이템1</li>
			<li>기존아이템2</li>
		</ul>
	</div>
</body>

</html>