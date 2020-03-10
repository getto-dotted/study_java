package ex10AccessModifier;

//시나리오] 감기환자는 아래 1,2,3 순서대로 약을 복용해야 한다고 가정

class SnuffleCap{
	public void take() {
		System.out.println("3.코막힘이 치료됩니다.");
	}
}

class SneezeCap{
	public void take() {
		System.out.println("2.기침이 멈춥니다.");
	}
}

class SinivelCap{
	public void take() {
		System.out.println("1.콧물이 멈춥니다.");
	}
}
//감기환자를 추상화한 클래스
class ColdPatient{
	//멤버변수
	SneezeCap sneeze = new SneezeCap();
	SinivelCap sinnivel = new SinivelCap();
	SnuffleCap snuffle = new SnuffleCap();
	
	//멤버메소드
	/*
	증상에 따라 약의 복용순서가 중요하다고 가정할때 현재는
	환자마음대로 복용순서를 정하는 것이 가능한 상태이다. 즉 캡슐화가 되지
	않아 순서없이 복용하는 것이 문법적으로 가능한 상황이다.
	 */
	public void take() {
		snuffle.take();
		sinnivel.take();
		sneeze.take();
	}
}
//캡슐화 이후의 코드
class ColdPatientCapsule{
	/*
	캡슐화 이전에는 환자가 세가지 증상에 대한 약을 마음대로
	복용했다면, 캡슐화 이후에는 처방이 완료된 Contack600을
	한번만 복용하면 되는 상황으로 변경되었따.
	즉 캡슐화는 여러가지 비즈니스로직을 하나로 묶는다는 의미외에도
	업무의 순서까지 고려한 형태의 로직을 구성한다는 의미도 함께 가지고 있다.
	 */
	Contack600 contack600=new Contack600();
	public void take() {
		contack600.take();
	}
}

public class ColdPatientMain {

	public static void main(String[] args) {
		//감기환자가 약을 복용하는 것을 표현
		System.out.println("캡슐화 이전 복용");
		ColdPatient patient = new ColdPatient();
		patient.take();
		
		System.out.println();
		System.out.println("캡슐화 이후 복용");
		ColdPatientCapsule patient2 = new ColdPatientCapsule();
		patient2.take();
	}

}
