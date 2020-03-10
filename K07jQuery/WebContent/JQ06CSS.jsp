<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ06CSS.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<script>
$(function(){
	/*  
	css() : 선택된 요소에 스타일을 부여한다.
		사용법1 : 매개변수 1,2를 통해 속성과 속성값을 부여하고.
			여러개인 경우 메소드체인을 활용해서 연결할 수 있다.
			$(선택자).css("속성","속성값")
		사용법2 : JSON형태로 속성을 부여한다.
			$(선택자).css({'속성1':'값1',....})
	*/
	$('#article1').css(
		{'width':'500px', 'height':'200px', 'border':'solid red 2px'}		
	);
	/*  
	css('속성','속성값') => 해당엘리먼트에 속성값을 부여한다.
	css('속성') => 부여된 속성값을 얻어온다.
	*/
	
	$('button').click(function(){
		var size = parseInt($("#article1").css("fontSize"));
		if($(this).text()=="폰트+"){
			size+= 2;
			$('div').css("fontSize", size+"px").css('color', 'red');
		}
		else{
			size-= 2;
			$('div').css("fontSize", size+"px").css('color', 'blue');			
		}
	});	
});
</script>
</head>

<body>
	<h2>css() 메소드</h2>
	
	<h3>뉴스기사 폰트크기 조절</h3>
	
	<button id="big">폰트+</button>
	<button id="small">폰트-</button>
	
	<div id="article1" style="font-size:12px;">
		여기는 뉴스기사가 나와요 <br />
		여기는 뉴스기사가 나와요 <br />
		여기는 뉴스기사가 나와요 <br />
	</div>	
 	
</body>

</html>