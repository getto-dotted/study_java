package ex05Method;

/*
 [메소드형태2] 매개변수는 없고 반환값은 있는 경우 : 사용자로부터 입력값을 받은후 연산을 진행하고 결과를 반환할 때 혹은 난수생성시 주로 사용된다.
 */

public class MethodType02_1 {

	static int noParamYesReturn() {
		int sum =0;
		for(int i=1; i<=10; i++) {
			sum+=i;
		}
		//반환타입이 있으므로 반드시 return문이 잇어야 한다.
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		//출력문에서 바로 함수호출
		System.out.println("1~10까지 합:"+noParamYesReturn());
		
		//함수호출후 반환값을 변수에 저장한 후 출력
		int sum10 = noParamYesReturn();
		System.out.println("1~10까지의 합은: "+sum10);
		
		
		
		
	}

}
