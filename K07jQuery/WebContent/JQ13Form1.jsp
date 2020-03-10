<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ13Form1.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<script>
$(function(){
	/*  
		태그선택자 input과 :input의 차이점
			input = > input태그만 선택한다.
			:input = >input태그를 포함하여 문서내의 모든 폼 엘리먼트를
				선택한다. textarea, select, button가 포함된다.
	*/
	$('#btn1').click(function(){
		alert("input의 갯수는:"+ $('input').length);
		alert("문서내 모든 폼요소의 갯수는:"+ $(':input').length);
			
	});
	/* 
	태그명과 속성값 가져오기
	-태그명 : 선택자.get(0).tagName 혹은 선택자.tagName으로 가져올 수 있다.
	-속성값 : 선택자.attr(속성명)으로 가져온다.
	※this의 사용법 : this 혹은 $(this) 둘다 가능함.
	*/
	$('#btn2').click(function(){
		var str = "";
		$(':input').each(function(index){
			str += "index:" + index;
			str += "\n";
			str += "태그명: "+ this.tagName;
			str += "\n";
			str += "Typed의 속성값: "+ $(this).attr('type');
			str += "\n";
		});
		console.log(str);
	});
	
	$('#btn3').click(function(){
		$(':text').css('backgroundColor','silver');
		alert('#text1의 value값'+ $('#text1').val());
		
		var txtVal = $('#text2').val($('#text1').val());
		alert("txt1의 내용이 txt2로 복사됨");
	});
});

</script>
</head>
<body>
	<h2>form요소와 jQuery</h2>
	
	1.<input type="text" name="text1" id="text1" 
		value="노트북" />
	<br/>
	2.<input type="text" name="text2" id="text2" value="" />
	<br/>
	3.<input type="password" name="passwd" />
	<br/>
	4(t).<textarea name="textarea" cols="50" rows="10">나는개발자다</textarea>
	<br/>
	5(s).<select name="select">
		<option value="A">에이</option>
		<option value="B">비이</option>
		<option value="C">씨이</option>
	</select>
	<br/>
	6.<input type="checkbox" name="checkbox" />나는체크박스다
	<br/>
	7.<input type="hidden" value="hidden" />여긴hidden박스
	<br/>
	8.<input type="submit" value="submit버튼" />
	<br/>
	
	<div style="margin-top:50px;">
		9.<button id="btn1">버튼1</button>
		10.<button id="btn2">버튼2</button>
		11.<button id="btn3">버튼3</button>
	</div>
	
</body>
</html>