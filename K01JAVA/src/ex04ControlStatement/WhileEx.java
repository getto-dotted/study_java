package ex04ControlStatement;

public class WhileEx {
	
	/*
	 while문 : 반복의 횟수가 정해져있지 않을때 주로 사용하는 반복문이다. 반복의 횟수가 명확할때는 for문을 주로 사용한다.
	 형식]
	 	while(반복의 조건) {
	 		조건이 참일때 실행될 문장;
	 		증감식; <- 탈출의 조건을 만들기 위해 ++혹은 --와 같은 연산을 주로 수행한다.
	 		}
	 */

	public static void main(String[] args) {
		//누적합을 구하기 위한 변수. 증가하는 i를 누적해서 더함.
		int sum =0;
		//반복을 위한 조건에 사용될 변수
		int i=1;
		//반복의 조건식
		while(i<=10) {
			//증가하는 i를 누적해서 sum에 더함(1+2+3...)
			sum+= i;
			//증가식. while문을 탈출하기 위한 조건을 만듦
			i++;
		}
		System.out.println("1~10까지의 합은:"+sum);
		System.out.println("==================");
		
		
		/*
		 시나리오] 1부터 100까지의 정수중 3의 배수이거나 5의 배수인 정수의 합을 구하여 출력하는 프로그램을 작성하시오. 단 while문을 사용한다.
		 */
		
		/*
		 Step1 : 1~100까지 반복하는 반복문을 만든다.
		 Step2 : 반복문 안에서 3의 배수 or 5의 배수를 찾는다.
		 Step3 : 위에서 찾은 숫자를 변수 total에 누적해서 더한다.
		 Step4 : 결과를 출력한다.
		 */
		
		int total =0;//누적합을 구하기 위한 변수
		int j =1;//반복을 위한 변수
		while(j<=100) {
			//3의 배수이거나 5의 배수가 되는 조건
			if(j%3==0 || j%5==0) {
				//조건을 만족할때만 누적
				total += j;
			}
			j++;
		}
		System.out.println("1~100사이 3or5의 배수합:"+total);

		/*
		 시나리오] 아래와 같은 모양을 출력하는 while문을 작성하시오.
		 	출력결과 
		 	1 0 0 0
		 	0 1 0 0
		 	0 0 1 0
		 	0 0 0 1
		 */
		
		
		int m=1;
		while(m<=5) {
			
			int n=1;
			while(n<=5) {
				
				if(m==n)
					System.out.print("★ ");
				else
					System.out.print("☆ ");
				
				
				n++;
			}
			
			System.out.println();
			m++;
		}
			
		
		
		/*
		 시나리오] 구구단을 출력하는 프로그램을 작성하시오.
		 */
		
		int dan =2;
		while(dan<=9) {
			
			int su = 1;
			while(su<=9) {
				System.out.printf(" %d*%d=%d", dan, su, (su*dan));
				
				su++;
			}
					
			System.out.println();
			dan++;
		}
		
		
		
		
		

		
		int syu =1;
		while(syu<=9) {
			
			int tan =2;
			while(tan<=9) {
				System.out.printf(" %3d*%3d=%3d", tan, syu, (syu*tan));
				tan++;
			}
			System.out.println();
			syu++;
		}
		
		
		
		
		
		
		
		
		
		

	}

}
