package ex04ControlStatement;

import java.util.Scanner;

public class Quiz03 {
	
	/*
	 문제] 파일명 : ex04controlstatement.Quiz03.java
다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.

출력]	
* * * * *
* * * *
* * *
* *
*

	 */

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("출력할 층수:");
		final int F = scanner.nextInt();
		
		for(int a =F; a>0; a--) {
			
			for(int b=1; b<=F; b++) {
				if(b<=a) {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	/*
	 
	 
	 
	 x가 증가할때 y가 감소하는 일반식 정의
	 FLOOR -x +1
	 x가 1일때 y=5
	 x가 2일때 y=4
	 ...
	 x가 5일때 y=1
	 
	 
	 출력할 층을 사용자로부터 입력받아 출력하시오
	 
	 Scanner scanner = new Scanner(System.in);
	 System.out.print("출력할 층수:');
	 final int FLOOR = scanner.nextInt();
	 
	 final int FLOOR =6;
	 
	 
	 for(int x=1; x<=5; x++){
	 	for(int y=1; y<=(FLOOR-x+1); y++){
	 		System.out.print("*");
	 		}
	 		System.out.println();
	 		}
	 
	 
	 
	 
	 */
	
	
	
	
	
	
	
	}
}
