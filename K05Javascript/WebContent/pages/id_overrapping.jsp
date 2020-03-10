<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>id_overrapping.jsp</title>
<script>
	function idUse() {
		/* 
		자식창에서 입력된 데이터를 부모창으로 전달하기 위해 opener 속성을 사용한다.
		 */
		opener.document.registFrm.id.value = document.overlapFrm.retype_id.value;
		self.close();
	}
</script>
</head>
<body>
	<h2>아이디 중복확인 하기</h2>

	<h3>
		부모창에서 입력한 아이디 :
		<%=request.getParameter("id")%></h3>

	<h3>아이디가 중복되었을때 재입력한 아이디</h3>
	<form name="overlapFrm">
		<input type="text" name="retype_id" size="20" /> <input type="button"
			value="아이디사용하기" onclick="idUse();" />
	</form>

</body>
</html>