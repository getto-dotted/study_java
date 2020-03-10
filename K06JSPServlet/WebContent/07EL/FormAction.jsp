<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormAction.jsp</title>
<script>
	function frmCheck() {
		var f = document.frm;
		//폼의 전송방식과 action경로를 JS에서 설정함
		f.action = "FormResult.jsp";
		f.method = "post";
	}
</script>

</head>
<body>
	<h2>폼값 전송하기</h2>
	<form name="frm" onsubmit="return frmCheck();">
	<ul>
		<li>
			이름 : <input type="text" name="name" />		
		</li>
		<li>
			성별 : 
				<input type="radio" name="gender" value="Man" />남자
				<input type="radio" name="gender" value="Woman" />여자		
		</li>
		<li>
			관심사항 : 
				<input type="checkbox" name="inter" value="pol" />정치
				<input type="checkbox" name="inter" value="eco" />경제
				<input type="checkbox" name="inter" value="ent" />연예
				<input type="checkbox" name="inter" value="spo" />운동
		</li>
		<li>
			학력 : 
				<select name="grade">
					<option value="ele">초딩</option>
					<option value="mid">중딩</option>
					<option value="high">고딩</option>
					<option value="uni">대딩</option>
				</select>
		</li>
		<li>
			<input type="submit" value="전송하기" />
		</li>
	</ul>	
	</form>

</body>
</html>