package ex14useBasicClass;

public class WrapperClass2 {

	public static void main(String[] args) {
		
		//Wrapper클래스의 주요 메소드
		/*
		1] static int parseInt(String s)
		   static Integer valueOf(String s)
		   : 숫자형식의 문자열을 숫자로 변경해서 반환한다.
		 */
		String strNumber= "1000";
		System.out.println("10+strNumber=" + (10+strNumber));//결과 : 101000
		System.out.println("10+strNumber를 숫자로 변경:"+(10+Integer.parseInt(strNumber)));//결과 : 1010
		System.out.println("10+strNumber를 숫자로 변경:"+(10+Integer.valueOf(strNumber)));//결과 : 1010
		//valueOf()메소드의 반환타입은 Integer타입이지만 오토언박싱이 지원되기 때문에 별도의 처리없이 연산이 가능하다.
		
//		String money="120원";
//		System.out.println("120원:"+Integer.parseInt(money));
		//숫자형태의 문자열이 아닌경우에는 예외가 발생하게 된다. 여기서 "원"은 숫자가 아니므로 제거후 숫자로 변경해야 한다.
		
		String floatString = "3.14";
		//System.out.println(Integer.parseInt(floatString));[오류발생] parseInt는 정수형태밖에 처리할 수 없다.
		//실수형태의 문자열을 실수로 변경할 때는 parseInt()를 사용할 수 없다.
		System.out.println("실수형(float)형으로 변경:"+Float.parseFloat(floatString));
		System.out.println("실수형(Double)형으로 변경:"+Double.parseDouble(floatString));
		
		//Character클래스의 주요메소드
		/*
		2] static int codePointAt(문자열, 인덱스)
			:문자열에서 특정 index에 해당하는 문자의 아스키코드값을 반환해준다.
			index는 0부터 시작이다.
		 */
		System.out.println("ABCD에서 3번째 인덱스 D의 아스키코드");
		System.out.println(Character.codePointAt("ABCD", 3));//결과 68
		
		/*
		3] static boolean isDigit(문자)
			: 인자로 전달된 문자가 숫자인지를 판단하는 메소드.
			단 주어진 문자가 숫자 혹은 숫자형문자일때만 숫자로 판단한다.
		 */
		
		System.out.println("isDigit()를 통한 숫자판단");
		System.out.println(Character.isDigit('A')?"숫자임":"숫자아님");
		System.out.println(Character.isDigit(50)?"숫자임":"숫자아님");
		System.out.println(Character.isDigit('7')?"숫자임":"숫자아님");
	
		/*
		4] static boolean isLetter(문자)
			:문자 여부를 판단하는 메소드로 특수기호나 숫자형은 false를 반환한다.
		 */
		
		System.out.println("isLetter()메소드를 통한 문자판단");
		System.out.println(Character.isLetter('가'));//true
		System.out.println(Character.isLetter('A'));//true
		System.out.println(Character.isLetter('#'));//false
		System.out.println(Character.isLetter('9'));//false

		// 5] static boolean isWhietspace(문자)
		//			:공백문자인지 판단하는 메소드
		
		System.out.println("isWhietspace() 메소드로 공백문자 판단");
		System.out.println(Character.isWhitespace('A'));
		System.out.println(Character.isWhitespace(' '));
		
		// 6] 대소문자를 판단하는 메소드
		//		:영문자에만 적용되며 알파벳이 아닌 문자에 적용시 false를 반환한다.
		
		System.out.println("알파벳 대소문자 판단");
		System.out.println(Character.isLowerCase('A'));
		System.out.println(Character.isUpperCase('z'));
		System.out.println(Character.isLowerCase('a'));//true
		System.out.println(Character.isUpperCase('Z'));//true
		System.out.println(Character.isLowerCase('가'));//무조건false
		
		//toCharArray() : 문자열을 char형 배열로 반환해주는 메소드. 아래는 문자열안에 몇개의 공백문자가 포함되었는지 확인하는 프로그램이다.
		
		String whiteString = " H E    L       L  O ";
		int whiteCount=0;
		char[] chArr = whiteString.toCharArray();
		for (int i = 0; i < chArr.length; i++) {
			if(Character.isWhitespace(chArr[i])) {
				whiteCount++;
			}
		}
		System.out.println("총공백수 : "+whiteCount);
		
		
		
		
	}

}
