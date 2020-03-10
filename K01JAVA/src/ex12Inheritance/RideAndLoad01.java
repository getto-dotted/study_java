package ex12Inheritance;

/*
오버로딩
	: 함수명은 같으나 매개변수의 갯수나 타입, 순서가 다른 경우의 함수정의를 말한다.
	즉, 서로 다른 함수이므로 상속받은 클래스에서는 오버로딩된 모든 메소드가 포함된다.
	
	
오버라이딩
	: 함수명, 매개변수의 갯수 등 모두 동일한 함수를 상속관계에서 하위클래스에서 재정의하는 것을 말한다.
	이 경우 하위 클래스에서 정의한 메소드가 상위 클래스의 메소드를 가리게 되므로
	항상 최하위클래스의 메소드가 호출된다.
	
※오버라이딩은 참조변수의 영향을 받지 않는다. 항상 최하위의 메소드가 호출된다.
※오버로딩은 참조변수의 영향을 받는다. 해당 참조변수의 범위까지만 접근이 가능하다.
 */
class A{
	public void rideMethod() {
		System.out.println("A의 rideMethod");
		}
	public void loadMethod() {
		System.out.println("A의 loadMethod");
	}
}

class B extends A{
	@Override
	public void rideMethod() {
		System.out.println("B의 rideMethod");
	}
	public void loadMethod(int num) {
		System.out.println("B의 loadMethod");
	}
	
}

class C extends B{
	@Override
	public void rideMethod() {
		System.out.println("C의 rideMethod");
	}
	public void loadMethod(double num) {
		System.out.println("C의 loadMethod");
	}
	
}

public class RideAndLoad01 {

	public static void main(String[] args) {
		
		A ref1 = new C();
		B ref2 = new C();
		C ref3 = new C();
		
		System.out.println("오버라이딩 처리된 메소드");
		ref1.rideMethod();//c에
		ref2.rideMethod();//정의된
		ref3.rideMethod();//오버라이딩 메소드 호출
		
		System.out.println("오버로딩 처리된 메소드");
		//객체를 c타입이라 간주하고 참조하므로
		ref3.loadMethod();//각각의
		ref3.loadMethod(1);//클래스에 정의된
		ref3.loadMethod(1.1);//메소드가 호출된다
		//객체를 b타입이라고 간주하고 참조하므로
		ref2.loadMethod();//b객체까지만
		ref2.loadMethod(1);//접근가능
		//ref2.loadMethod(1.1); c객체는 접근불가
		//객체를 a타입이라고 간주하고 참조하므로
		ref1.loadMethod();//a객체까지만
		//ref1.loadMethod(1);//접근가능
		//ref1.loadMethod(1.1); b,c객체는 접근불가
		
		

	}

}
