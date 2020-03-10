package ex05Method;

import java.util.Scanner;

public class Quiz02 {
	
	/*
	 섭씨(Celsius)를 입력받아서 화씨(Fahrenheit)로 변환하여 리턴하는 함수와
화씨를 입력받아서 섭씨로 변환하여 리턴하는 함수를 만들어라.
공식]
  화씨 = 1.8 * 섭씨 + 32
  섭씨 = (화씨 - 32) / 1.8
메소드명]
  섭씨를 화씨로변환 : CelsiusToFahrenheit()
  화씨를 섭씨로 변환 : FahrenheitToCelsius()

	 */

	static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
	
		
		System.out.println("섭씨: ");
		double a = scanner.nextDouble();
		double cTof = returnFahrenheit(a);
		System.out.println("화씨: "+cTof);
		
		

		System.out.println("화씨: ");
		double b = scanner.nextDouble();
		double fToc = returnCelsius(b);
		System.out.println("섭씨: "+fToc);
		
	}
	
	static double returnFahrenheit(double temperC) {
		double c = temperC;
		double result = 1.8*c+32;
		
		return result;
		
	}
		
	static double returnCelsius(double temperF) {
		double f = temperF;
		double result2 = (f-32)/1.8;
		
		return result2;
		
		/*
		 
		static double returnFahrenheit(double temperC) {
			return 1.8*temperC+32;
		}
		
		static double returnCelsius(double temperF) {
			return (temperF-32)/1.8;
		*/
	}
	

}
