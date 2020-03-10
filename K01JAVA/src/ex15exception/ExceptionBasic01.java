package ex15exception;

import java.io.IOException;

public class ExceptionBasic01 {

//	public static void main(String[] args) throws IOException{
	public static void main(String[] args) {
		/*
		1] Syntax에러(구문에러)
			:실행자체가 되지 않는 코드로 오류를 수정해야만 정상적으로 
			실행할 수 있다. 즉 코드의 문법오류를 말한다.
		Int number = 10; <- int를 Int로 표기했음
		if(true); <- if문에 ;을 작성하여  if문이 종료됨
		{}
		else	<- 그러므로 의미없는 else문이 됨
		{}
		*/
		//위 문장에서 구문오류가 있는 부분을 수정한 코드
		int number = 10;
		if(true) {
			System.out.println("참이다");
		}
		else {
			System.out.println("거짓이다");
		}
		/*
		예외가 발생될때 처리방법
		방법1] read()와 같이 호출시 기본적인 예외를 가지고 있는 메소드는 
				"예외던지기:와 같이 main()밖으로 예외를 던져서 처리한다. 이 방법은 예외를 내부에서 처리하지 않고
				무시하겠다는 의미이다. 
				
				public static void main(String[] args) throws IOException
				
				main()함수 뒷부분에 throws 하여 예외를 함수 밖으로 던지는 처리를 한다.
				
		방법2] 예외가 발생된 지점에서 try~catch문으로 직접 처리한다.		
		 */
		try {
			System.out.println("문자하나를 입력하세요:");
			int iChar = System.in.read();
					
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
