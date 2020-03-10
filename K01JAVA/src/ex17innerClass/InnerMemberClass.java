package ex17innerClass;

/*
내부클래스(내부멤버클래스)
	: 클래스 안에 정의된 클래스로 static으로 선언되지 않은 클래스를 말한다.
	-외부클래스의 모든 멤버를 사용할 수 있다.
	-정적멤버를 가질 수 없다. 단 상수는 가능하다.
	-컴파일시 외부클래스명$내부클래스명.class파일이 생성된다.
	-안드로이드와 같은 이벤트기반의 프로그래밍에서 많이 사용된다.
 */
class OuterMember{
	
	//멤버변수
	int outerInstanceVar;
	int sameVar = 1000;
	InnerMember inner;
	private int pVar;
	//생성자
	public OuterMember() {
	//내부멤버클래스의 객체를 생성한 후 할당
		inner = new InnerMember();
	}
	//정적멤버변수
	static int outerStaticVar;
	//멤버메소드
	void outerInstanceMethod() {
		//외부클래스의 멤버변수 접근(가능)
		System.out.println("외부의 sameVar:"+sameVar);
		//내부클래스의 정적변수 접근(static은 클래스명으로 접근)
		System.out.println("내부클래스의 상수:"+InnerMember.MAX_INT);
		//내부클래스의 멤버변수 접근(참조변수를 통해 접근)
		System.out.println("내부의 sameVar:"+inner.sameVar);
	}
	//정적멤버메소드
	static void outerStaticMethod() {
		//외부클래스의 정적메소드에서 내부클래스의 정적상수에 접근
		System.out.println(InnerMember.MAX_INT);
//		System.out.println("내부의  sameVar접근 : "+ inner.sameVar);
//		-> 정적메소드에서는 정적멤버만 접근가능함
		
	}
	//내부클래스(내부멤버클래스)
	class InnerMember{
		//내부클래스의 멤버변수
		int innerInstanceVar;
		int sameVar= 100;
		//내부클래스의 멤버메소드
		void innerInstanceMethod() {
			//외부클래스의 private멤버도 접근가능.
			OuterMember.this.pVar=10;
			/*
			외부클래스는 내부클래스보다 큰 지역이므로 
			내부클래스에서는 외부클래스의 모든 멤버를 사용할 수 있다.
			 */
			outerInstanceMethod();//[o]
			outerStaticMethod();//[o]
			
			//내부클래스의 멤버변수
			this.sameVar = sameVar;
			
			//외부클래스의 멤버변수
			OuterMember.this.sameVar = sameVar;
		}
		/*
		내부클래스는 정적멤버를 가질 수 없으나 상수인 경우에는 허용된다.
		 */
		static final int MAX_INT = Integer.MAX_VALUE;
	}
}

public class InnerMemberClass {

	public static void main(String[] args) {

//		외부클래스가 아닌 다른 클래스에서 내부멤버클래스의 객체를 생성하려면 
//		외부클래스의 객체를 통해서만 생성이 가능하다.
//		InnerMember innerClass = new InnerMember(); <-에러발생
		
		OuterMember outerClass = new OuterMember();
		
		//내부클래스의 멤버메소드를 접근할때는 외부클래스의 멤버변수를 통해서 접근 가능하다.
		outerClass.inner.innerInstanceMethod();
		
		
		/*
		내부클래스의 객체를 생성하는 방법1, 방법2
		 */
		OuterMember.InnerMember in = outerClass.new InnerMember();
		
		OuterMember.InnerMember in2 = new OuterMember().new InnerMember();
		
		
	}

}
