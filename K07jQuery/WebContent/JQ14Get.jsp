<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ14Get.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<script>
/*  
$.get()
	: HTTP Get방식을 통해 서버로부터 데이터를 받을때 사용하는 메소드
	
	사용법
		$.get(url, param, success(data));
		-url : 정보를 요청할 url
		-param : 서버로 전송할 파라미터 (JSON형식)
			필요없을 경우 생략 가능
		-success(data) : 요청이 성공했을때 실행될 callback(콜백)함수.
			콜백함수가 호출될때 전달되는 파라미터를 통해 
			성공 혹은 실패여부를 판단할 수 있다. 
*/
$(function(){
	
	$('#btnXml').click(function(){
		$.get('./common/NameCard.xml'//1.요청url
				//2.파라미터(여기서는 생략함)
				,function(data){//3.콜백메소드
			/* 요청후 서버에서의 응답메세지를 콜백메소드의 파라미터로 받게 된다.
			이때 data는 '소스보기'의 내용을 그대로 콜백받게 된다.*/
			console.log(data);
			/*  
			parsing(파싱)
			-구문분석 이라고 한다.
			-문장이 이루고 있는 구성 성분을 분해하고, 분해된 성분을 원하는 형태로
			조립하여 다시 빼내는 프로그램을 말한다.
			-parsing 기법에는 XML parsing과 JSON parsing이 있다.
			*/	
			$(data).find("명함").each(function(){
				var html = "<div>이름: "+$(this).find("성명").attr("이름")+"</div>";
					html += "<div>주소: "+$(this).find("주소").text()+"</div>";
					html += "<div>직위: "+$(this).find("직위").text()+"</div>";
					html += "<div>이메일: "+$(this).find("e-mail").text()+"</div>";
					html += "<div>핸드폰: "+$(this).find("Mobile").text()+"</div>";
					html += "<div>전화번호: "+$(this).find("TEL").text()+"</div>";
					html += "<div>카피라이트: "+$(this).find("copyrigth").text()+"</div>";
					/*  
					empty() : 선택된 DOM의 내용을 비운다.
					*/
					/* $('#xmlDisplay').empty();
					$('#xmlDisplay').append(html); */
					//위2개의 함수는 html()로 대체할 수 있다.
					$('#xmlDisplay').html(html);
			});			
		});
	});	
	/*  
	파라미터 조립하기
		: $.get()메소드나 $.post()메소드를 통해 서버로 요청시
		파라미터를 넘겨야 할때는 항상 JSON형태로 파라미터를 조립해야 한다.
	*/
	//JSP파일에서 읽어오기
	$('#btnJSP').click(function(){
		$.get('./common/PrintToday.jsp',
				{'msg':$(this).text(),'varStr':'jQuery좋아효'},//버튼에 설정된 Text
				function(data){				
					alert(data);	
					$('#jspDisplay').html(data);
				}
		);
	});
});
//전달된 URL을 새창으로 띄워준다.
function locationGo(link){
	window.open(link, '', 'width=500,height=500');
}

</script>
</head>
<body>
	<h2>$.get() 메소드 사용하기</h2>
	
	<h3>xml파일 읽어오기</h3>
	<button class="btn" 
		onclick="locationGo('./common/NameCard.xml');">
		NameCard.xml바로가기
	</button>
	
	<button class="btn btn-info" id="btnXml">
		XML데이터 읽어오기
	</button>
	
	<div class="displayDiv" id="xmlDisplay">
		XML데이터 정보를 디스플레이합니다.
	</div>
	 
	<h3>jsp파일에서 읽어오기</h3>
	<button class="btn btn-warning" 
		onclick="locationGo('common/PrintToday.jsp?msg=안녕하세요&varStr=jQuery조아효');">
		PrintToday.jsp바로가기
	</button>
	<button class="btn btn-success" id="btnJSP">
		JSP결과 읽어오기
	</button>
	<div class="disDisplay" id="jspDisplay">
		JSP결과를 디스플레이 합니다.
	</div>
	
</body>
</html>