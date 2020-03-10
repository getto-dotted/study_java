package ex10AccessModifier;
/*
접근지정자(접근제어지시자)
	: 클래스와 클래스 사이의 멤버간의 접근을 제어하는 기능을 가진 키워드를 말한다.
	
접근의 범위
private < default < protected < public
	- private : 클래스 내부에서만 접근가능. 외부에서는 접근불가.
	- default : 동일 패키지 내에서만 접근가능.
	- protected : 상속관계에 있는 클래스에서 접근가능.
	- public : 모든 클래스에서 접근가능.

접근 지정자는 클래스, 멤버변수, 멤버메소드 모두 붙일 수 있다.

Class를 정의할때는 반드시 public과 default(생략형)만 가능하다.
private 클래스는 문법적으로 불가능하므로 오류발생.

private class PrivateClass {
	void notFunc() {
		System.out.println("나는 정의할 수 없는 Class");
	}
}
*/
/*
접근지정자를 생략했으므로 default클래스로 정의됨. 해당 클래스는 동일 패키지 내에서만 접근가능함.
 */
class DefaultClass{
	//몸체가 없는 Default클래스
}

//어디서든 접근이 가능한 클래스
public class AccessModifierOne {

	//멤버변수 : 각각의 접근지정자를 통해 선언함.
	private int privateVar;
	int defaultVar;
	public int publicVar;
	
	private void privateMethod() {
		//클래스 내부이므로 private멤버에 접근 가능함.
		System.out.println("privateVar="+privateVar);
		System.out.println("privateMethod() 메소드 호출");
	}	
	void defaultMethod() {
		privateMethod();
		System.out.println("defaultMethod() 메소드 호출");
	}
	public void publicMethod() {
		privateMethod();
		System.out.println("publicMethod() 메소드 호출");
	}
}
