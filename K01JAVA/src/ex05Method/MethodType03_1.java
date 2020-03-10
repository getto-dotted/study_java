package ex05Method;

import java.util.Scanner;

/*
 [메소드 형식3]
 	매개변수는 있으나 반환값이 없는 경우.
 	메소드 실행을 위해 값을 전달한 후 연산의 결과를 콘솔창에 즉시 출력하는 형태의 프로그램에 주로 사용된다.
 */
public class MethodType03_1 {

	/*
	 시나리오] 사용자가 입력한 2개의 시작값과 끝값사이에 있는 수를 모두 더하여 출력하는 프로그램을 작성하시오.
	 	출력결과]
	 		시작값 :4
	 		종료값 :6
	 		결과 : 4+5+6=???
	 */
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("시작값:");
		int s = scanner.nextInt();
		System.out.print("종료값:");
		int e = scanner.nextInt();
		yesParamNoReturn(s, e);
	}
	
		
		static void yesParamNoReturn(int sNum, int eNum){
			
			int sum =0;
			for(int i=sNum; i<=eNum; i++) {
				sum+=i;
			}
			
		System.out.printf("%d~%d까지의 합은 : %d", sNum, eNum, sum);
	}
			
	}