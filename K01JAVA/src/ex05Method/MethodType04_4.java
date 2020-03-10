package ex05Method;

import java.util.Scanner;

public class MethodType04_4 {
static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		
		System.out.print("숫자를 입력하세요: ");
		int a = scanner.nextInt();
		int maxValue1 = returnMaxNumber(a);
		System.out.println("최대값1: "+maxValue1);
		
	}
	
	static int returnMaxNumber(int numberCnt) {
		int maxVal=0;
		for(int i=1; i<=numberCnt; i++) {
			System.out.print("정수를 입력하세요: ");
			int inputNum = scanner.nextInt();
			
			if(i==1) {
				maxVal = inputNum;
			}
			else {
				if(maxVal < inputNum) {
					maxVal = inputNum;
				}
			}
		}
		return maxVal;
	}
	
	

}
