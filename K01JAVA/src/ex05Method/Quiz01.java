package ex05Method;

import java.util.Scanner;

public class Quiz01 {
/*
 문제) 파일명 : ex05method.Quiz01.java
원의 반지름을 파라메타로 전달하면 원의넓이와 둘레를 계산하여 반환하는 메소드를 각각 정의하자. 이를 호출하는 main 메소드를 정의하라.
메소드명 : circleArea() > 원의넓이, circleRound() > 원의둘레
-넓이공식 : 3.14 * 반지름 * 반지름
-둘레공식 : 2 * 3.14 * 반지름
실행예 :
---------- java ----------
원의 둘레(5.5) : 34.54
원의 넓이(5.5) : 94.985
--------------------------

 */
	
	
static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
	
		
		System.out.println("반지름: ");
		double r = scanner.nextDouble();
		double circleA = circleArea(r);
		
		double circleR = circleRound(r);
				
		
		System.out.printf("원의 둘레: %f, 원의 넓이: %f",circleA, circleR);
		
	}
	
	/*
	static double circleArea(double areaC) {
		double r = areaC;
		areaC = 3.14*r*r;
		
		return areaC;
	}
		
	static double circleRound(double roundC) {
		double r = roundC;
		roundC = 2*3.14*r;
		
		return roundC;
		
		*/
	
		
		static double circleArea(double area) {
			double result = area;
			
			result = 3.14*area*area;
				
			return result;
		}
		
		static double circleRound(double round) {
			double r = round;			
			
			return 2*3.14*r;
		
		
	}
	

}
