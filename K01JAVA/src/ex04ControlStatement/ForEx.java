package ex04ControlStatement;

public class ForEx {

	public static void main(String[] args) {
		
		/*
		 for문 : while문과 같은 반복문으로 초기값, 조건식, 증감식이 한 라인에 있어 반복의 횟수를 명확히 알 수 있는 반복문.
		 		사용빈도가 가장 높음.
		 		형식] 
		 			for(초기값; 조건식; 증감식){
		 				실행문장;
	 				}
 				실행순서]
 					초기값-> 조건식(확인) -> 실행문장 -> 증감식 -> 조건식....반복실행됨		 				
		 */
		
		
		for(int i=1 ; i<=5 ; i++) {
			System.out.println("i= "+i);			
		}
		
		/*
		 시나리오] 1~10까지의 합을 구하는 프로그램을 for문을 이용해서 작성하시오
		 */
		
		int sum=0;
		//for(초기값;조건식;증감식)
		for(int j=1; j<=10; j++) {
			sum +=j;
		}
		System.out.println("1~10 까지의 합= "+sum);
		
		
		/*
		 시나리오]
		 1~10까지의 정수중 2의 배수의 합을 구하는 프로그램을 for문을 이용해 작성하시오.
		 */
			
		//방법1 if문 사용
		int total=0;
		for(int a=1;a<=10;a++) {
			if(a%2==0) {
				total+=a;
			}
					
		}
		System.out.println("10까지의 정수중 2의 배수의 합(if문 사용): "+total);
		

		//방법2 2씩 상승
		
		total=0;
		for(int a=0;a<=10;a+=2) {
				total+=a;
					
		}
		System.out.println("10까지의 정수중 2의 배수의 합(if없이): "+total);
		
		
		/*
		 for문의 초기식에서 선언된 변수j는 for문의 지역을 벗어나는 순간 메모리에서 소멸된다. 여기서 사용된 변수 j를 for문의 '지역변수'라고 한다.
		 
		 변수i는 main메소드의 지역변수로 for문보다 더 큰 지역이므로 for문 안에서 사용하는것이 가능하다.
		 */
		
		int i=0;
		for(; i<=5;i++) {
			System.out.println("for문 안에서의 i값"+i);
		}
		
		System.out.println("for문 밖에서의 i값:"+i);
		
		for(int j=0; j<=5;j++) {
			System.out.println("for문 안에서의 j값: "+j);
		}
		
		/*
		 변수 j는 for문의 지역변수이므로 for문 밖에서 쓸 수 없다.
		 
		//System.out.println("for문 밖에서의 j값: "+j);
	
		 for문의 초기값을 외부(넓은지역)에서 선언하게 되면 해당 변수는 for문 안쪽(좁은지역)에서 사용가능하다.
		 */
		
		/*
		 for문으로 무한루프 조건을 만들때는 아래와 같이 쓸 수 있다.
		 단, 무한루프는 while문을 주로 사용한다.
		 
		for(;;) {
			System.out.println("난 무한루프");
		}
		*/
		
		/*
		 시나리오] 다음의 출력결과를 보이는 for문을 작성하시오
		 	출력결과
		 		1 0 0 0
		 		0 1 0 0
		 		0 0 1 0
		 		0 0 0 1
		 		
		 		0 0 0 1
		 		0 0 1 0 
		 		0 1 0 0
		 		1 0 0 0
		 */
		
		
		for(int a=1; a<=4; a++) {
			
			for(int b=1; b<=4; b++) {
				if(a==b) 
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		/*
		 시나리오] 다음의 출력결과를 보이는 for문을 작성하시오
		 	출력결과
		 		
		 		0 0 0 1
		 		0 0 1 0 
		 		0 1 0 0
		 		1 0 0 0
		 */
		
		
		for(int a=1; a<=4; a++) {
			
			for(int b=1; b<=4; b++) {
				if(a+b==5) 
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
