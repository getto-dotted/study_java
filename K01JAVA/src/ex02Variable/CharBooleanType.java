package ex02Variable;

public class CharBooleanType {
	
	/*
	 아스키코드 : 1byte로 표현할 수 있는 문자(영문, 숫자)를 십진수코드로 정의한 것을 말한다.
	 예) A의 아스키코드 : 65(이진수 : 1000001) a의 아스키코드 : 97
	 
	 유니코드 : 1byte로 표현할 수 없는 문자(한글, 한자 등)는 2byte가 필요하고 이를 16진수로 정의한 값을 말한다.
	 */

	public static void main(String[] args) {
		
		
		
		/*
		 char형 : 하나의 문자를 저장할 수 있는 자료형으로 '(Single Quotation)으로 문자를 감싼다.
		 "로 감싸게 되면 무조건 문자열로 인식하므로 String형으로 선언해야 한다.
		 */
		
		
		char ch1 = '가';
		//char ch2 ='가나다라';
		System.out.println("ch1="+ch1);
		
		
		
		char ch2 = 'A';//A는 내부적으로 65라는 아스키코드값을 가진다
		int num1 =2;
		int num2 =ch2 + num1;//A의 코드값인 65에 2를 더하면 c의 아스키코드값인 67이 나온다.
		System.out.println("num2="+num2);//출력 : 67
		
		
		
		char ch3 = (char)(ch2 +num1);
		System.out.println("ch3(문자출력)=>"+ch3);
		System.out.println("ch3아스키코드 출력=>"+(int)ch3);
		
		//문자 1의 아스키코드값= 49		
		char ch4= '1';
		char ch4_1 = 49;
		System.out.println("ch4="+ch4+", ch4_1="+ch4_1);

		/*
		 boolean형 : true 혹은 false 두가지의 값만 가질 수 있는 데이터형으로 산술연산(+,-,*,/)이나 비교연산(>,<,≤,≥)에서는 사용이 불가능하다.
		 단, 논리연산은 가능하다(다음 챕터에서 학습)
		 */
		
		boolean bn1 =true;
		boolean bn2 = false;
		System.out.println("bn1="+bn1+", bn2="+bn2);
		
				
		/*
		 && : 논리 And연산으로 둘다 참일때만 참을 반환한다.
		 
		 || : 논리Or 연산으로 둘중 하나만 참이어도 참을 반환한다.
		 */
		
		boolean bn3=bn1 && bn2;
		System.out.println("bn3="+bn3);//false출력
		boolean bn4 = bn1 || bn2;
		System.out.println("bn4="+bn4);//true출력
		
		
		bn3 = '가' > 30000;//유니코드 44032 > 30000
		System.out.println("bn3="+bn3);
		
		System.out.println((char)44032);
		
		System.out.println((int)'뿱');
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
