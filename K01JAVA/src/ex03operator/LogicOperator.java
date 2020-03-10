package ex03operator;

public class LogicOperator {

	
	/*
	 논리 연산자
	 && : 논리AND. 양쪽 모두가 true일때만 true를 반환하고, 나머지는 false를 반환한다.
	 || : 논리OR. 한쪽만 true이면 true를 반환하고, 양쪽모두 false 일때만 false를 반환한다.
	 ! : 논리 NOT. 반대의 논리를 반환한다.
	 */
	public static void main(String[] args) {


		int num1 = 10, num2 =20;
		
		boolean result1 =(num1==100 && num2==20);
		boolean result2 = (num1<12 || num2>=30);
		
		System.out.println("result1=>"+result1);
		System.out.println("result2=>"+result2);
		
		if(!(num1==num2)) {
			System.out.println("num1과 num2는 다르다");
		}
		
		else {
			System.out.println("num1과 num2는 같다");
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
