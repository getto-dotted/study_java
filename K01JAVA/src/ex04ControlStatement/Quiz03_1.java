package ex04ControlStatement;

public class Quiz03_1 {
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
		
		int c=5;
		while(c>0) {
			
			int d=1;
			while(d<=5) {
				if(d<=c) {
					System.out.print("*");
				}
				d++;
			}
			c--;
			System.out.println();
		}
	}
}
