<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ03Bind.jsp</title>
<style>
	div{
		width:500px; height:130px;
		text-align:center; font-size:1.5em;
		border:1px dotted black;
	}
	input{ width:200px; height:100px; margin-top:20px;}
</style>
<script src="./js/jquery-3.4.1.js"></script>
<script>
$(function(){
	/*  
	bind() : 선택된 엘리먼트에 이벤트를 여러개 부여하고 싶을 때
		사용하는 함수이다. 단, 물리적으로 존재하는 요소에만
		부여할 수 있다.
	unbind() : 부여된 이벤트를 제거할때 사용한다.
	*/
	$('#click_change')
		.bind("mouseover", function(){
			document.getElementById("click_change")
				.style.backgroundColor="red";			
		})
		.bind("mouseout", function(){
			$(this).get(0).style.backgroundColor="white";/*  
					get(인덱스) : JS의 getElementById()와 동일한 역할을
					하는 함수로 JS의 DOM객체를 가져온다.
			*/
		})	
		.bind("click", function(){
			alert($(this).text());			
		});//text() : JS의 innerText()와 동일한 역할을 하는
		//함수로 태그사이의 텍스트를 읽어온다.
	
	$('#btnClick').click(function(){
		alert('버튼 클릭됨');
	});
	/*  
	click이벤트를 제거한다. 이벤트가 unbind()되고 나면 클릭해도
	아무런 동작을 하지 않는다.
	*/
	$('#btnEventClear').bind('click', function(){
		$('#btnClick').unbind('click');
		alert('#btnClick의 이벤트가 제거됨');
	});	
});

</script>



</head>
<body>
	<h2>bind() 메소드</h2>	
	<div id="click_change">
		마우스를 over하면 red로 변하고 <br />
		마우스를 out하면 white로 변하고 <br />
		마우스를 click하면 여기 내용이
		경고창(alert)으로 뜬데요~
	</div>

	<h2>unbind() 메소드</h2>
	
	<input type="button" id="btnClick" value="난버튼" />
	
	<input type="button" id="btnEventClear" 
		value="이벤트제거버튼" />
	
</body>
</html>