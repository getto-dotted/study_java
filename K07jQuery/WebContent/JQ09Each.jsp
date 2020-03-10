<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ09Each.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<script>
$(function(){
	/*  
	each() : 선택자를 통해 가져온 DOM객체수만큼 반복해주는
		함수로 매개변수로 index를 사용할 수 있다. index는 0부터
		자동증가하며, 필요 없을경우 생략이 가능하다.
	*/
	$('#btn1').click(function(){
		$('div').each(function(index){			
			$(this).attr({'id':'div'+index, 
				style:'border:1px solid red;width:100px;height:100px'
			})
		});
	});

	$('#btn2').click(function(){
		alert($('#div1').text());
	});
});

</script>
</head>
<body>
	<h2>each() 메소드</h2>
	
	<div>index:0 -> div1</div>
	<div>index:1 -> div2</div>
	<div>index:2 -> div3</div>
	
	<button id="btn1">div에 style적용하기</button>
	<button id="btn2">index1의 text() 읽어오기</button>
	
</body>
</html>