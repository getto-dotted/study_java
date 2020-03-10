package ex14useBasicClass;

//와일드카드: 패키지를 임포트할때 보통은 클래스명을 명시하지만 특정패키지의 모든 클래스를 임포트할때는 *를 사용한다. *는 "모든것"을 뜻한다.

import java.lang.*;

/*
Object클래스
-자바에서의 최상위 클래스
- 별도의 선언없이 Object클래스에 정의된 메소드를 사용할 수 있다.
-개발자가 정의한 모든 클래스를 Object객체로 참조할 수 있다. 
 */

class Friends extends Object {
	String myName;
	public Friends(String name) {
		myName = name;
	}
	
	@Override
	public String toString() {
		return "제 이름은 "+ myName +" 입니다.";
	}
}

/*
toString()메소드
-Object클래스에 정의된 메소드로 println()이 문자열을 출력하기 전에 자동으로 호출한다.
-객체를 문자열 형태로 변환해서 반환해준다.
-필요한 경우 클래스를 정의할때 적절히 오버라이딩해서 사용한다.
 */
public class ToStringObject {

	public static void main(String[] args) {
		
		Friends fnd1 = new Friends("이순신");
		Friends fnd2 = new Friends("김유신");
		
		System.out.println(fnd1);
		System.out.println(fnd2);
		

	}

}
