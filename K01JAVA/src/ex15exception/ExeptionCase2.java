package ex15exception;

import java.io.IOException;
/*
예외처리방법2
		: 예외가 발생한 지점ㅇ에서 직접 try~catch로 처리한다.
 */
public class ExeptionCase2 {

	static void compileFunc() {
		System.out.print("하나의 문자를 입력하세요: ");
		
		try {
			int userChar = System.in.read();
			System.out.println("입력된 문자는: "+(char)userChar);
		}
		catch(IOException e) {
			System.out.println("IO예외가 발생하였습니다.");
		}
	}
	public static void main(String[] args) {
		compileFunc();
		
	}

}
