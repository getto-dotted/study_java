package ex08Class;
/*
시나리오]
다음에 주어진 조건으로 '사람'을 추상화 하시오.
-속성 : 이름, 나이, 에너지
-행동 : 걷는다, 생각한다, 먹는다, 현재상태
	4가지를 표현한다.
-행동의 조건
	먹으면 에너지가 2 증가한다.
	걸으면 에너지가 1 감소한다.
	생각하면 에너지가 2감소한다.
	단, 에너지의 최소, 최대범위는 0~10이다.(사람은 무한히 먹을 수 없으며 에너지가 마이너스가 되면 죽은 것과 같다.)
 */

public class Human {
	/*
	멤버변수 생성 : 이름, 나이, 에너지
		객체의 속성을 표현한다.
	 */
	String name;
	int age;
	int energy;
	
	/*
	멤버메소드 : 걷다, 생각하다, 먹다, 현재상태표현
		객체의 행동을 표현한다.
	 */
	void walk() {
		/*
		에너지를 1 차감한 후 음수인지 확인하여 만약 음수라면 0으로 고정한다.
		 */
		energy--;
		if(energy<0) {
			energy = 0;
			System.out.println("[walk]에너지는 0이 최소입니다.");
			System.out.println("0으로 고정됩니다.");
		}
		else {
			System.out.println("[walk]에너지가 1 감소하였습니다.");
		}
	}
	void thinking() {
		energy -=2;
		if(energy<0) {
			energy = 0;
			System.out.println("[thinking]에너지는 0이 최소입니다.");
			System.out.println("0으로 고정됩니다.");
		}
		else {
			System.out.println("[thinking]에너지가 2 감소하였습니다.");
		}
	}
	
	void eat() {
		//2증가후 10을 초과하면 에너지를 10으로 고정시킴
		energy +=2;
		if(energy>10) {
			energy=10;
			System.out.println("[eat]에너지는 10이 "+"최대치입니다.");
		}
		else {
			System.out.println("[eat]에너지가 2 증가하였습니다.");
		}
	}
	//현재 상태 출력용 멤버메소드
	void showState() {
		System.out.println("===님의 현재상태는===");
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		System.out.println("에너지:"+energy);
		System.out.println("=================");
	}
	
	
	
	
	
	
	
	
	
	
	

}
