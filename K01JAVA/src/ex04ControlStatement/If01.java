package ex04ControlStatement;

public class If01 {
	public static void main(String[] args) {
		
		/*
		 If문(조건문, 분기문)
		 형식1]
		 		if(조건문){ 
		 			실행문장1;
		 			실행문장2;
		 			}
		 			
		 -if문의 조건문은 반드시 비교식 혹은 논리식이어야한다.
		 -즉, 결과값이 boolean타입이 된다.
		 -실행할 문장이 하나일때는 중괄호를 생략할 수 있다.			
		 */
		
		int num=10;
		/*
		 아래 2개의 문장은 boolean이 아닌 산술식이므로 에러가 발생된다.
		if(num%2) {
			System.out.println("잘못된 조건식");
		}
		
		if(num) {
			System.out.println("이것도 잘못된 조건식");
		}
		*/
		
		/*
		 if문의 조건은 반드시 아래와 같이 boolean을 반환해야한다.
		 */
		if(num%2 ==0){
			System.out.printf("%d는 짝수입니다.", num);
		}
		if(num%2==0 && num>=10) {
			System.out.printf("%d는 짝수이고 10보다"+"크거나 같습니다.%n", num);
		}
		
		
		if(true) {
			System.out.println("무조건 실행되는 if문");
			}
		
		
		/*
		 if(조건식); => 조건식이 참일때 실행할 문장이 없음을 의미하는 코드로, 아래{}블럭은 조건에 상관없이 무조건 실행되는 코드이므로
		 작성시 주의해야한다.
		 */
		
		if(num%2 !=0); {
			System.out.printf("%d는 홀수입니다.%n", num);
		}
		
		/*
		 if문에서 실행할 문장이 하나인 경우에는 {}(중괄호)를 생략하는 것이 가능하다.
		 */
		
		
		if(num%2 ==0) 
			System.out.printf(num+"은 짝수입니다.%n");
						
		if(num%2 !=0) {
			System.out.println(num+"은 홀수입니다.");
			System.out.println("num의 값은"+num+"입니다.");
		}
		
		/*
		 시나리오] 입력한 문자가 숫자인지 여부를 판단하는 프로그램을 if문을 이용해서 작성하시오.
		 */
		
		 char ascii = '∑';
		 
		 //아스키코드값을 알고 있을때 구현방법
		 if(ascii>=48 && ascii<=57) {
			 System.out.println("입력한 문자는 숫자임");
		 }
		
		 else {
			 System.out.println("입력한 문자는 숫자가 아님");
		 }
		
		
	//아스키코드값을 모를때 구현방법
		 if(ascii>='0' && ascii<='9') {
			 System.out.println("입력한 문자는 숫자임");
		 }
		 
		 else {
			 System.out.println("입력한 문자는 숫자가 아님");
		 }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
