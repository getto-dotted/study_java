package ex13interface;

//추상클래스1 : 추상메소드가 없는 추상클래스
abstract class NoHavingAbsMethod{
	//static타입의 상수선언
	public static final int MSX_INT = Integer.MAX_VALUE;
	//멤버변수
	int instanceVar;
	static int staticVar;
	//멤버메소드
	void instanceMethod() {}
	static void staticMethod() {System.out.println("==");}
}

class NoHavingChild extends NoHavingAbsMethod{
	int newVar;
	/*
	추상메소드를 포함하지 않은 추상클래스를 상속받는 경우 오버라이딩은 강제사항이 아니므로 필요에 따라 처리.
	 */
	@Override
	void instanceMethod() {
		//↑↑↑↑강제사항아님
	}
}
//추상클래스2 : 추상메소드를 포함한 클래스
abstract class HavingAbsMethod{
	/*
	추상메소드를 멤버로 포함한 클래스는 반드시 abstract로 정의해야한다. 그렇지 않으면 에러가 발생된다.(규칙)
	 */
	abstract void absMethod(int number);
}
class HavingChild extends HavingAbsMethod{
	/*
	의무적으로 오버라이딩한 메소드
	이경우 오버라이딩 하지 않으려면 해당 클래스를 abstract로 정의해야 한다.
	그럴경우 해당 클래스로는 객체를 생성할 수 없게 되므로 오버라이딩은 필수적이다.
	 */
	@Override
	void absMethod(int number) {
		System.out.println("부모클래스에서 오버라이딩한 메소드");
		
	}
	void newMethod() {
		System.out.println("새롭게 확장한 메소드");
	}
}
public class AbstractBasic {

	public static void main(String[] args) {
		
		//추상클래스는 인스턴스를 생성할 수 없다.
		//NoHavingAbsMethod nham = new NoHavingAbsMethod();//에러발생
		//추상클래스를 상속한 하위클래스는 객체생성이 가능하다.
		NoHavingChild nhc = new NoHavingChild();
		/*
		추상클래스로 객체생성은 할 수 없지만 , 참조변수로 사용하는 것은 가능하다. 부모객체로 자식객체를 참조하게 되면
		관리의 일관성을 유지할 수 있다.
		 */
		HavingAbsMethod ham = new HavingChild();
		ham.absMethod(100);
		/*
		부모객체로 자식객체를 참조하게 되면 업캐스팅(자동형변환)이 되므로, 다운캐스팅(명시적 형변환)을 통해 자식객체에 접근해야 한다.
		 */
		((HavingChild)ham).newMethod();
		/*
		추상클래스에 선언된 정적 멤버는 오버라이딩의 대상이 될 수 없으므로 static이 가진 기본규칙을 따른다.
		클래스명으로 접근이 가능하다.
		 */
		NoHavingAbsMethod.staticMethod();
		NoHavingChild.staticMethod();

	}

}
