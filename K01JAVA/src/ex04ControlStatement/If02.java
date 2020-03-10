package ex04ControlStatement;

public class If02 {

	public static void main(String[] args) {

		/*
		 if문
		 	형식2]
		 		if(조건){
		 			조건이 참일때 실행문장;
		 		}
		 		else{
		 			조건이 거짓일때 실행문장;
		 		}
		
		 */
		
		
		int num =100;
		if(num%2==0) {
			System.out.println("짝수입니다.");
		}
		else {
			System.out.println("홀수입니다.");
		}
		
		
		String numberResult = (num%2==0)
				? "짝수" : "홀수";
		System.out.println("숫자"+num+"은 "+numberResult+" 입니다.");
		
		/*
		 시나리오] 숫자를 짝/홀수인지 먼저 판단한 후, 100이상인지를 판단하는 프로그램을 작성하시오.
		 실험결과]
		 	짝수이면서 100이상입니다.
		 	or
		 	홀수이면서 100미만입니다.
		 */
		
		
		int number = 110;
		
		if(number%2==0) {//짝수일때
		
				if(number>=100) {
				//짝수이면서 100이상인경우
				System.out.println(number+"는 "+"짝수이면서 100이상입니다.");
			}
				else {
				//짝수이면서 100미만인경우
				System.out.println(number+"는 "+"짝수이면서 100미만입니다.");
				
			}
		}
		else {
				if(number>=100) {
				//홀수이면서 100이상인경우
				System.out.println(number+"는 "+"홀수이면서 100미만입니다.");
				}
				else {
				//홀수이면서 100미만인경우
				System.out.println(number+"는 "+"홀수이면서 100미만입니다.");
			}
		}
	
		
		
		
		System.out.println("=========");
		int t=100;
		if (t>=1) {
			System.out.println("쓸모없");
		}
		
		else if (t>=2) {
			System.out.println("참");
		}
		
		else 
			System.out.println("참");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
