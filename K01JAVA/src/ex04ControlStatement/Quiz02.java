package ex04ControlStatement;

public class Quiz02 {
	/*
	 문제] 파일명 : ex04controlstatement.Quiz02.java
	다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.

	출력]
		*
		* *
		* * *
		* * * *
		* * * * *

	 */
	public static void main(String[] args) {
		
		int a=1;
		while(a<=5) {
			
			int b=1;
			while(b<=5) {
				//b는 a의 갯수만큼만 출력한다.
				if(b<=a) {
				System.out.print("* ");
				}
				
				b++;
			}
			System.out.println();
			a++;
			
		}
		System.out.println();
		
		
		
		
		
		
	}

}
