package review;

import java.util.Scanner;

public class R01if_shitch {

	public static void main(String[] args) {

		/*
		제어문1 : if문
			
			형식1) 
				if(조건){
					조건이 참일때 실행문;
				}
				
				
			형식2)
				if(조건){
					조건이 참일때 실행문;
				}
				else{
					조건이 거짓일때 실행문;
				}
				
			형식3)
				if(조건1){
					조건1이 참일때 실행문;
				}
				else if(조건2){
					조건2가 참일때 실행문;
				}
				else {
					조건 1,2가 모두 거짓일때 실행문;
				}
		 */
		
		int num1=10;
		int num2=20;
		if(num1<num2) {
			System.out.println("num1이 num2보다 작다.");
		}
		
		//위 문장을 if~else문으로 수정하시오.
		
		if(num1>num2) {
			System.out.println("num1이 num2보다 크다.");
		}
		else {
			System.out.println("num1이 num2보다 작다.");
		}
		/*
		주의] 조건은 항상 if문 뒤에 나오게 된다. else문 뒤에는 조건이 들어가지 않는다.
		 */
		
		//학점구하기를 if ~ else if ~ else 구문으로 표현하시오.
		/*
		90점이상 : A학점
		80점이상~90점미만 : B학점
		나머지는 : F학점
		 */

		int jumsu = 85;
		
		if(jumsu>=90) {
			System.out.println("A학점");
		}
		else if (jumsu>=80 && jumsu<90) {
			System.out.println("B학점");
		}
		else {
			System.out.println("F학점");
		}
		/*
		if문의 조건을 통해 구간을 정할때는 반드시 논리AND(&&)를 사용해야 한다.
		 */
		
		/*
		다음와 같은 모양을 출력하시오. 단 숫자는 홀수만 입력받는걸로 한다. 
		*
		**
		***
		****
		*****
		****
		***
		**
		*
		*/	

		final int FLOOR = 9;//9층으로 탑을 쌓는다.(상수)
		//9번 반복하는 for문
		for(int i=1; i<=FLOOR; i++) {
			
			//증가하는 부분을 알기 위해 2로 나눈값을 무조건 올림
			int half = (int) (Math.ceil(FLOOR)/2);/*
				ceil()함수는 반환타입이 double이므로 int형으로 형변환 해야함.
			*/
			if(i<=half) {
				//half보다 작거나 같을때까지는 *증가
				for(int j=1; j<=i; j++) {
					System.out.print("*");
				}
			}
			else {
				/*감소
				FLOOR-i+1
					6층일때 : 9-6+1 =4
					7층일때 : 9-7+1 =3
					형태로 계산되는 일반식
				 */
				for(int j=1; j<=FLOOR-i+1; j++) {
					System.out.print("*");
				}
			}
			System.out.println();//하나의 층을 출력한 후 줄바꿈 처리
		}
		
		
		/*
		switch문
			형식1)
				switch(산술식or정수식){
					case 값1 :
						실행문1;
					case 값2 :
						실행문2;
					default :
						나머지 실행문;
					}
			형식2)
				switch(산술식or정수식){
					case 값1 :
						실행문1;	break;
					case 값2 :
						실행문2;
						break;
					default :
						나머지 실행문;
					}
			
		 */
		/*
		연습문제] 월을 입력받은후 해당 월이 몇일까지 있는지 출력하는 프로그램을 작성하시오.
		  	예) 7월 -> 31일
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("일수를 알고 싶은 달을 입력하시오 : ");		
		int month = scan.nextInt();
		int days = 0;
		boolean isTrue = true;//잘못된 입력값 처리용

		switch(month) {
		case 1 : case 3: case 5: case 7: case 8: case 10: case 12:
			days = 31; 
			break;
		case 4: case 6: case 9: case 11:
			days = 30; 			
			break;
		case 2 :
			days = 28; 			
			break;
		default:
			System.out.println("그런 달은 없습니다.");
			isTrue=false;
		}
		if(isTrue==true) {
		System.out.println(month+"월의 날짜 수는 "+days+"일 입니다.");
		}
		
		
	}

}
