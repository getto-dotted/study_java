package ex15exception;

import java.io.IOException;
/*
예외처리방법1
		: 예외가 발생한 함수, 그리고 main함수에서도 예외객체를 외부로 던지는 방법.
		즉 예외를 처리하지 않고 무시하겠다는 의미임. 외부자원 사용시 기본적으로 발생되는
		예외는 이처럼 무시하는 것이 가능함.
 */
public class ExeptionCase1 {

	static void compileFunc() throws IOException{
		System.out.print("하나의 문자를 입력하세요: ");
		int userChar = System.in.read();
		System.out.println("입력된 문자는: "+(char)userChar);
	}
	public static void main(String[] args) throws IOException{
		compileFunc();
		
	}

}
