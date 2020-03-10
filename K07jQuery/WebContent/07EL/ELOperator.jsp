<%-- <%@page import="java.util.Vector"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ELOperator.jsp</title>
</head>
<body>
	<h2>EL의 연산자들</h2>
	<!-- JAVA(JSP)에서는 null을 통한 산술연산은 에러가 발생되지만
	EL식에서는 null은 0으로 취급되어 연산가능 -->
	<h3>EL에서의 null 연산</h3>
	<ul>
		<li>\${null+10 } : ${null+10 }</li>
		<!-- 파라미터 자체가 없을때는 0으로 취급되고,
		파라미터를 붙였을때는 해당 값을 가져와서 연산함-->
		<li>\${param.myNumber+10 } : ${param.myNumber+10 }</li>
		<!-- null값과 비교연산을 할때는 무조건 false값 반환 -->
		<li>\${param.myNum>10 } : ${param.myNum>10 }</li>
	</ul>
	
	<h3>JSTL로 EL에서 사용할 변수선언</h3>
	<!-- 
		EL은 영역에 저장된 속성을 변수로 사용하므로 스크립트렛에서 
		선언한 변수는 사용이 불가능
		아래는 0으로 인식되어 100이 출력
	 -->
	<%
	String varScriptLet = "스크립트렛 안에서 변수선언";
	%>
	<ul>
		<li>
			\${varScriptLet+100 } : ${varScriptLet+100 }
		</li>
		<!-- 
			스크립트렛에서 선언한 변수를 EL에서 사용하고 싶다면
			JSTL의 set태그를 사용하여 변수를 선언한 후 사용한다.
		 -->
		<li>
			<c:set var = "elVar" value = "<%=varScriptLet %>"></c:set>
			\${elVar } : ${elVar }
		</li>
	</ul>
	
	<h3>EL변수에 값 할당하기</h3>
	<!-- 
		톰캣8.0부터는 EL에서 변수할당이 가능해졌다. 하지만 EL은
		전통적으로 값의 표현(출력)용도로 만들어졌기때문에 할당을
		사용하기 위해서는 반드시 서버의 버전을 확인해야 한다.
	 -->
	<c:set var="fnum" value="9"/>
	<c:set var="snum" value="5"/>	
	<li>
		\${fnum=99 } : ${fnum=99 } 
	</li>
	<!-- EL을 통한 산술연산시 정수와 정수를 연산할때 실수의 결과가
	나올때는 자동으로 "형변환" 해준다.
	-나눗셈 연산자 / 대신 div, % 대신 mod와 같은 산술연산자를 사용할 수 있다. 
	-EL에서는 숫자형식의 문자열을 자동으로 숫자로 형변환 해준다.
	-EL은 무조건 문자열을 숫자로 변경해준다고 생각하자. 즉 + 연산자는
	덧셈 연산에만 사용할 수 있다.-->
	<h3>EL의 산술연산자</h3>
	<ul>
		<li>\${fnum+snum } : ${fnum+snum }</li>
		<li>\${fnum/snum } : ${fnum/snum }</li>
		<li>\${fnum div snum } : ${fnum div snum }</li>
		<li>\${fnum%snum } : ${fnum%snum }</li>
		<li>\${fnum mod snum } : ${fnum mod snum }</li>
		<li>\${"100"+100 } : ${"100"+100 }</li>
		<!-- 아래 부분은 예외발생됨. 숫자로 변경할 수 없기때문. -->
		<li>\${"Hello"+"EL" } : \${"Hello"+"EL" }</li>
		<li>\${"일"+2 } : \${"일"+2 }</li>
	</ul>
	<!-- 항상 좌측항이 기준
		> : Greater Then => gt
		>= : Greater Then Equal => ge
		< : Less Then => lt
		<= : Less Then Equal => le
		== : EQual => eq
		!= : Not Equal => ne
		&& : and
		|| : or
	 -->
	<h3>EL의 논리연산자</h3>
	<ul>
		<li>
			\${5>=5 && 10!=10 } : ${5 ge 5 and 10 ne 10 }
			false
		</li>
		<li>
			\${5>6 || 10<100 } : ${5 gt 6 or 10 lt 00 }
			true					
		</li>
	</ul>
	<h3>EL의 삼항연산자</h3>
	\${10 gt 9 ? "참" : "거짓" } : ${10 gt 9 ? "참" : "거짓" }
	
	<!-- 
	EL에서는 비교연산자를 이용한 비교연산시 EL변수에 저장된 값을
	모두 문자열로 인식하여 String 클래스의 compareTo()메소드를 통한
	비교방식으로 비교한다.
	즉 첫번째 문자부터 하나씩 비교한다. 단 순수한 숫자를 비교할 때는
	숫자비교가 이루어진다.
	 -->
	<h3>EL의 비교연산자</h3>
	<c:set var="fnum" value="100" />
	<c:set var="snum" value="90" />
	<ul>
		<!-- EL변수를 통한 비교이므로 문자1이 문자0보다는 작다.
		따라서 아래는 false가 반환된다. -->
		<li>\${fnum>snum } : ${fnum>snum }</li>
		<!-- 숫자에 대한 비교이므로 100이 큰것으로 반단하여
		true가 반환된다. -->
		<li>\${100>90 } : ${100>90 }</li>
		<li>
			<!-- java에서는 equals()를 통해 문자열을 비교하지만
			EL에서는 ==으로 비교한다. -->
			\${"JAVA"=='JAVA' } : ${"JAVA"=='JAVA'}
			<br />
			\${"Java"=='JAVA' } : ${"Java"=='JAVA' }
		</li>
	</ul> 
	<!-- 
		String인 경우 null, ""(빈문자열) 일때
		배열은 길이가 0일때, 컬렉션은 size가 0일때
			=> true를 반환하는 연산자
	 -->
	<h3>EL의 empty연산자</h3>
	<%
		String nullStr = null;
		String emptyStr = "";
		Integer[] lenZero = new Integer[0];
		Collection sizeZero = new Vector();	
	%>
	<c:set var ="elNullStr" value ="<%=nullStr %>" />
	<c:set var ="elEmptyStr" value="<%=emptyStr %>" />
	<c:set var ="elLenZero" value="<%=lenZero %>" />
	<c:set var ="elSizeZero" value="<%=sizeZero %>" />
	<ul>
		<li>null일때 : ${empty elNullStr }</li>
		<li>빈값일때 : ${not empty elEmptyStr }</li>
		<li>배열크기가0일때 : ${empty elLenZero ? "크기0" : "크기0아님" }</li>
		<li>컬렉션크기가 0일때 : ${not empty elSizeZero ? "객체있음" : "객체없음" }</li>
	</ul>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html> --%>