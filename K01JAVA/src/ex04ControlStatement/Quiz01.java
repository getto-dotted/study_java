package ex04ControlStatement;

public class Quiz01 {
/*
 문제) 파일명 : ex04controlstatement.Quiz01.java
아래 코드를 삼항연산자를 사용하지 말고 if~else문으로 변경해보자.


   public static void main(String[] args)
   {
         	int num1=50, num2=100;
         	int big, diff;
         	
         	big = (num1>num2)? num1:num2; //조건?참:거짓;
         	System.out.println(big);
         	
         	diff = (num1>num2)? num1-num2: num2-num1;
         	System.out.println(diff); 
   }
실행결과]
---------- java ----------
100
50 


 */
	public static void main(String[] args) {
	/*
		int num1=50, num2=100;
		int big, diff;
		
		big=(num1>num2)? num1:num2; //조건? 참:거짓;
		System.out.println(big);
		
		diff=(num1>num2)? num1-num2: num2-num1;
		System.out.println(diff);
		*/
		
		int num3=50, num4=100;
		int big2, diff2;
		
		if(num3>num4) {
			System.out.println(num3);
		}
		else {
			System.out.println(num4);
		}
		
		if(num3>num4) {
			System.out.println(num3-num4);
		}
		else {
			System.out.println(num4-num3);
		}
		
		/*
		 int num1=50, num2=100;
		int big, diff;
		
		if(num1>num2){
		big=num1;
		
		}
		else{
		big = num2;
		}
		 
		 
		 
		 
		 
		 
		 
		 
		 */

	}
	

}
