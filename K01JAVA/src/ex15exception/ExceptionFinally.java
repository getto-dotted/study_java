package ex15exception;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
finally절
		: 예외발생여부에 상관없이 try문으로 진입했을때 반드시
		실행해야 하는 코드가 있는 경우 기술하는 블럭
		1]try~catch : 예외를 직접 처리할때 사용
		2]try~catch~finally : 예외를 직접 처리한 후 반드시 실행할
		문장이 있을때 사용
		3]try~finally: 예외는 외부로 던지고 예외발생과 상관없이
		실행할 문장이 있을경우 사용
		※단 try문에서 System.exit(0)절을 만나게 되면 이는 프로그램
		자체종료가 되므로 finally절은 실행되지 않는다.
 */
public class ExceptionFinally {
	/*
	호출되었을때 런타임 오류가 무조건 발생하도록생성된 메소드로 
	예외가 발생될때 직접 처리하지 않고 호출된 지점으로 예외객체를 던진다.
	 */

	static void runtime() throws NumberFormatException{
		Integer.parseInt("백");
	}
	static void tryCatchFinally() {
		Scanner scan = new Scanner(System.in);
		System.out.print("나이를 입력하세요:");
		int age = Integer.MAX_VALUE;
		try {
			age = scan.nextInt();//<-30살
			System.out.println("당신은 5년후 "+(age+5)+"살 입니다.");
			//try구문에서 return을 만나도 finally구문은 실행됨.
			//System.exit(0);
			return;
		}
		catch(InputMismatchException e) {
			System.out.println("나이는 숫자만 쓰세요");
			
		}
		finally {
			System.out.println("항상 실행되는 finally절 입니다.");
			//프로그램 자체가 종료된다.
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		try {
			runtime();
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		tryCatchFinally();
		//System.exit(0);을 만나서 실행되지 않음
		System.out.println("메인메소드 끝");
		
	}

}
