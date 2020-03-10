<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ11Append.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<script>
$(function(){
	/*  
	append() : 선택된 DOM 뒷부분에 새로운 컨텐츠를 추가한다.
		방식) 선택자.append(컨텐츠);
	prependTo() : 앞부분에 컨텐츠를 추가한다.
		방식) $(컨텐츠).prependTo(선택자);
	html() : 기존의 내용을 제거한 후 새로운 내용을 추가한다.
	*/
	$('.btn').click(function(){
		var row = $('#row').val();
		var col = $('#col').val();
		
		var table = "<table border='1'>";
		for(var i=1; i<=row; i++){
			table += "<tr>";
			for(var j=1; j<=col; j++){
				table += "<td>"+ i +"행, "+ j +"열</td>";
			}
			table += "</tr>"
		}
		table +="</table>"
		
		if($(this).text()=='append()'){
			$('#appendDisplay').append(table); 
		}
		else if($(this).text()=='prependTo()'){
			$(table).prependTo('#appendDisplay');
		}
		else if($(this).text()=='html()'){
			$('#appendDisplay').html(table);
		}
		
	});	
	
});



</script>
</head>
<body>
<h2>append() 메소드</h2>
	
	<input type="number" id="row" value="2" />행
	<input type="number" id="col" value="2" />열
	<input type="button" id="btn" value="동적테이블추가" />
	<button type="button" class="btn">append()</button>
	<button type="button" class="btn">prependTo()</button>
	<button type="button" class="btn">html()</button>
	
	<div id="appendDisplay">
		여기에 생성됨
	</div>	
</body>
</html>