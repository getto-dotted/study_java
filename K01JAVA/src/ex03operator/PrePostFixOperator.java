package ex03operator;

public class PrePostFixOperator {

	
	
	
	/*
	 증가/감소(증감) 연산자
	 : +1 혹은 -1 한것과 같은 결과를 반환한다. 주로 반복의 횟수를 카운트할 때 사용된다.
	 전위증가(Prefix)
	 연산자가 변수 앞에 있는 경우로 
	 1. 변수의 값이 먼저 증가(감소)한다.
	 2. 변화된 값이 좌측으로 할당된다.
	 
	 후위증가(Postfix)
	 연산자가 변수 뒤에 있는 경우로
	 1. 변수의 값이 좌측으로 먼저 할당된다.
	 2. 할당된 이후에 변수의 값이 증가(감소)한다.
	 */
	public static void main(String[] args) {

		int num1 = 7;
		int num2, num3;
		
		num2 = ++num1;
		
		/*
		 1. num1의 값이 먼저 증가
		 2. num2에 1 증가된 값이 대입됨.
		 결과 : num1=8, num2=8
		 */
		num3 = --num1;
		/*
		 1. num1의 값이 먼저 감소
		 2. 1감소한 num1의 값이 num3에 대입됨
		 결과 : num1=7, num3=7
		 
		 최종결과 : 7, 8, 7
		 */
		
		System.out.println("전위증가/감소시");
		System.out.printf("num1=%d, num2=%d, num3=%d%n", num1, num2, num3);
	
//////////////////////////////////////////		
		
		
		num1 = 7;
		num2 =0; 
		num3= 0;
		
		num2 = num1++;/*
		
		1. num1의 값이 num2에 먼저 할당됨
		2. num1의 값이 증가됨
		*/
				
		num3 = num1--;
		
		/*
		 1.num1의 값이 num3에 먼저 할당됨
		 2. num1의 값이 감소됨
		 
		 최종결과 :7, 7, 8
		 */
		System.out.println();
		System.out.println("후위증가/감소시");
		System.out.printf("num1=%d, num2=%d, num3=%d%n", num1, num2, num3);
		
		
		/////////////////////////////////////
		
		/*
		 삼항연산자 : if문과 비슷한 기능으로 조건이 참일때 거짓일때를 분기하여 실행할 수 있는 연산자이다.
		 */
		
		int x =100;
		String result =(x<=100) ?"참이다" :"거짓이다";
		System.out.println("result=" + result);
		
		
		
		
		
		
		
		
		

	}

}
