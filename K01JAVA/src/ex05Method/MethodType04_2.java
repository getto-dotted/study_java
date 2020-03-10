package ex05Method;

import java.util.Scanner;

public class MethodType04_2 {
	
	
	/*
	 해당 클래스의 지역에 변수를 생성하였으므로 아래변수를 전역변수 혹은 클래스변수라고 한다.
	 해당 변수는 클래스 전체에서 사용할 수 있다. 
	 */
static Scanner scanner = new Scanner(System.in);
	
public static void main(String[] args) {
	//인원수도 입력받도록 수정	
		System.out.print("인원수를 입력하세요. : ");
		int ag = scanner.nextInt();
		int sumOfAge = getTotalAge(ag);
		
		System.out.println("입력받은 나이의 합은?"+sumOfAge);


	}
	
	static int getTotalAge(int personCnt) {
		
		
		int sumAge =0;
		
		for(int i=1; i<=personCnt; i++) {
			System.out.print(i+"번째 사람의 나이:");
			int age = scanner.nextInt();
			sumAge +=age;
		}
		
		return sumAge;
	}
	
	
	
	

}
