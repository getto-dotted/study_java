package ex12Inheritance;

/*
베이스 스피커 Is A 스피커
	: 위와 같은 관계가 성립하므로 상속관계로 표현이 적합
	
오버라이딩(Overriding)
	: 클래스가 상속관계에 있을때 하위클래스에서 상위클래스의 멤버메소드를
	동일한 이름으로 메소드를 재정의하는 것을 말한다.
		오버로딩(Overloading)과 다른점이라면 매개변수의 갯수, 타입,
	반환형이 완전히 동일한 형태로 정의된다.
		하위클래스에서 오버라이딩한 메소드는 상위클래스의 메소드를 가리게 된다.
	즉 하위클래스에서 재정의한 메소드가 호출되게 된다.
 */
class Speaker{
	private int volumnRate;
	public void setVolumn(int vol) {
		volumnRate = vol;
	}
	/*
	상속관계에서 오버라이딩을 목적으로 정의된 메소드
	 */
	public void showState(){
		System.out.println("스피커의 볼륨크기:"+ volumnRate);
	}
}

class BaseSpeaker extends Speaker{
	private int baseRate;
	public void setBase(int bas) {
		baseRate = bas;
	}
	/*
	@Override
		: 어노테이션이라 부르고 
		오버라이딩 된 메소드에 붙어서 컴파일러에게 알려주는 역할을 한다.
	
	 */
	@Override
	public void showState() {
		//부모클래스의 멤버메소드를 호출할때 사용
		super.showState();
		System.out.println("베이스의 볼륨크기"+ baseRate);
	}
	
}

public class Overriding {

	public static void main(String[] args) {
		BaseSpeaker baseSpeaker = new BaseSpeaker();
		//부모클래스의 멤버메소드 호출
		baseSpeaker.setVolumn(10);
		//자기 클래스의 멤버메소드 호출
		baseSpeaker.setBase(20);
		/*
		하위클래스에 오버라이딩하여 정의된 메소드가 호출된다.
		오버라이딩은 상위클래스의 메소드를 가리게 된다.
		 */
		baseSpeaker.showState();
		
		System.out.println();
		Speaker speaker = new BaseSpeaker();
		speaker.setVolumn(30);
		//speaker.setBase(50); -> 에러발생
		/*
		Speaker의 참조변수로 BaseSpeaker 객체를 참조하게되면
		접근범위는 Speaker 객체로 제한된다. 따라서 하위클래스에 정의된
		setBase()메소드는 호출할 수 없다.
		단, 오버라이딩 된 메소드가 있다면 하위클래스의 메소드가 호출되게 된다.
		 */
		speaker.showState();
		
		
	}


}