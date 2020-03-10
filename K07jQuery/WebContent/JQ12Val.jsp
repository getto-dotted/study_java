<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ12Val.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<script>
$(function(){
	
	$('input:text').val('홍길동');
	$('input:radio').val(['남자']);
	$("#sel").val(['pol','ent']);
	$('input:checkbox').val(['트와이스','블랙핑크']);
	
	$('input:button').click(function(){
		var msg = "";
		msg += $('#txt').val() + "\n";
		/* 만약 체크된 항목이 없다면 undefined가 출력된다. */
		msg += $('input:radio[name=gender]:checked').val()+"\n";
		msg += $('#sel').val()+"\n";
		$('input:checkbox[name=favo]:checked').each(function(){
			msg += $(this).val();
		});
	
		alert(msg);	
		
	});	
});

</script>
</head>
<body>
	<h2>val()메소드</h2>
	
	텍스트박스 : <input type="text" id="txt" />
	<br />
	라디오박스 :
	<input type="radio" name="gender" value="남자" />Man
	<input type="radio" name="gender" value="여자" />Woman
	<br />
	셀렉트리스트:
	<select id="sel" multiple="multiple" size="3">
		<option value="pol">정치</option>
		<option value="eco">경제</option>
		<option value="ent">연예</option>
	</select>	
	<br />
	체크박스 :
	<input type="checkbox" name="favo" value="트와이스" />트와이스
	<input type="checkbox" name="favo" value="모모랜드" />모모랜드
	<input type="checkbox" name="favo" value="블랙핑크" />블랙핑크
	<input type="checkbox" name="favo" value="레드밸벳" />레드밸벳
	<br />
	<input type="button" value="확인" />
	
</body>
</html>