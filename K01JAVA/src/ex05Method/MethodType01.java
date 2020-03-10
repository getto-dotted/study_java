package ex05Method;

public class MethodType01 {

	/*
	 Method(메소드): 객체지향 프로그램에서 행동 또는 동작을 의미한다. 즉 어떤 일을 처리하는 하나의 모듈(부속품)이라 정의할 수 있다.
	 -메소드는 반드시 class안에 정의해야 한다.
	 -메소드 안에 또다른 메소드를 정의할 수 없다.
	 -정의할 때 반드시 반환타입이 있어야 한다. 만약 반환값이 없다면 void로 정의한다.
	 -이름의 규칙은 변수와 동일하다.(소문자로 시작하는 변형된 Camel Case => simpleFunc, addCal()등)
	 */
	/*
	 [메소드 형식1] 매개변수(Parameter)도 없고 반환값도 없는 경우 : 해당 형식은 주로 출력을 담당하는 경우에 사용된다. 반환값이 없으므로 반드시 void로 명시해야 한다.
	 */
	
	
	/*
	 동일한 클래스 내에서 메소드명의 중복은 불가능하다.
	 ※메소드 오버로딩(Overloading): 메소드명은 동일하나 매개변수의 갯수 혹은 타입을 다르게하여 정의하는 문법으로 뒤에서 설명합니다.
	 즉 아래와 같이 완전히 똑같이 정의하는 것은 허용되지 않는다.
	 */
	static void noParamNoReturn() {
		System.out.println("==메뉴를 선택하세요==");
		System.out.println("1. 열기, 2. 계속, 3. 종료");
		System.out.println("========================");
	}
	
	//static void noParamNoReturn() {
		//System.out.println("동일한 함수명은 사용불가");
	
	
	static void noParamNoReturn2() {
		int returnValue=9;
		System.out.println("[return 문 이전]");

		/*
		 함수의 중간에 return문장을 쓰게되면 함수가 종료되므로 그 아래 문장은 실행될 수 없는 코드가 된다. 이경우 unreachable code라는 에러가 발생된다.
		
		return;
		System.out.println("[return문이전]");
		*/
		/*
		 아래의 경우에는 조건에 따라 결과가 달라질 수 있으므로 허용된다.
		 */
		if(returnValue%2==0) {
			System.out.println(returnValue+"는 짝수");
			return;
		}
		System.out.println(returnValue+"는 홀수");
		System.out.println("[return 문 이후]");
		
				
		
		
	}
	/*
	 규칙] java에서 MAIN메소드는 무조건 PUBLIC STATIC VOID로 선언하기로 약속되어있다. 그리고 STATIC으로 선언된 메소드에서 다른 메소드를 호출하기 위해서는 호출되는 메소드도
	 반드시 STATIC으로 선언해야 한다.
	 */
	
	public static void main(String[] args) {
	
		
		
		/*
		 규칙] 메소드 호출후 반환값은 항상 호출한 위치로 돌려준다. 만약 반환값이 없다고 하더라도 호출한 위치로 실행의 흐름이 돌아온다.
		 */
		noParamNoReturn();
		noParamNoReturn2();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
