package ex07String;
/*
 JAVA의 전제조건1
 : 자바의 모든 프로그램은 java.lang 패키지에 포함되게 된다. 
 즉, 아래 import문은 생략이 가능하며, 해당 패키지의 모든 클래스를 사용할 수 있다.
 ※와일드카드(*) : '모든것'을 의미하는 문자로 아래 import문은 java.lang패키지의 모든 클래스를 해당 파일에 포함시키겠다는 의미이다.
 */

import java.lang.*;

/*
 JAVA의 전제조건2:
 자바에서 제공되는 혹은 생성하는 모든 클래스는 Object 클래스를 자동으로 상속받는다. 
 따라서 Object클래스에 정의된 모든 메소드를 사용할 수 있다.
 */
public class StringBasic extends Object {

	public static void main(String[] args) {
		//기본자료형의 데이터를 비교연산자로 비교
		int num1=10, num2=20;
		String numResult = (num1==num2) ?
				"데이터가 같다" : "데이터가 다르다";
		System.out.println("비교결과:"+numResult);
		
		/*
		 String클래스의 객체생성방법1 : new를 사용한다.
		 */
		
		String str1 = new String("Hello JAVA");
		String str2 = new String("Hello JAVA");
		/*
		 str1, str2는 String객체의 참조값(주소값)을 가지고 잇으므로 단순히 참조값에 대한 비교를 하고 있다.
		 */
		if(str1==str2) {
			System.out.println("str1과 str2는 참조주소 같음");
		}
		else {
			System.out.println("str1과 str2는 참조주소 다름");
		}
		/*
		 equals()메소드
		 	: Object클래스로부터 상속받은 메소드로 실제 객체에 대한 비교를 할 수 있도록 정의되어 있다.
		 	즉 아래는 객체에 저장된 문자열에 대한 비교가 이루어진다.
		 */
		if(str1.contentEquals(str2)) {
			System.out.println("두 문자열은 동일하다");
		}
		else {
			System.out.println("두 문자열은 다르다");
		}
		
		/*
		 자바에서 문자열 객체를 생성할때 new를 사용하지 않고 "(더블)을 사용하게 되면, 동일한 문자열인 경우
		 같은 메모리를 사용하게 되어 공유된다. new를 사용하면 무조건 새로운 메모리가 생성된다.
		 */
		String str3 = "한국직업전문학교";
		String str4 = "한국직업전문학교";
		System.out.println("equals()메소드로 문자열비교:"+str3.contentEquals(str4));
		
		if(str3==str4) {
			System.out.println("주소가 같다");
			
		}
		else {
			System.out.println("주소가 다르다");
		}
		
		
		
		
	}

}
