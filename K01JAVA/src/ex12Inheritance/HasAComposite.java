package ex12Inheritance;
/*
복합관계로 표현하기에 적합한 Has-A관계
	: X has A Y -> X가 Y를 소유하고 있다.
	
	위와 같은 소유의 관계를 상속으로 표현하면 클래스간의 강한 연결고리가 형성되어
	권총이 없는 경찰 등을 표현하기 힘들어지기때문에 이런 경우에는 
	복합관계로 표현하는 것이 적합하다.
	복합관계란 클래스의 멤버로 또다른 객체가 정의되는 것을 말한다.
 */
class Gun{
	int bullet;//총알의 갯수
	public Gun(int bNum) {
	bullet = bNum;
	}
	//총을 쏘는 행위 표현
	public void shotGun() {
		System.out.println("빵야~~!");
		bullet--;
	}
}
//경찰을 표현한 클래스
class Police{
	int handCuffs;//수갑의 보유갯수
	Gun pistol;//보유한 권총
	
	public Police(int bNum, int hCuff) {
		handCuffs = hCuff;
		
		/*
		권총보유여부 초기화
		 	: 만약 총알이 0 이라면 보유한 권총이 없는 것을 표현하고
		 	참조변수는 null값을 가지게 된다. 참조변수가 null이라는 것은
		 	참조할 객체가 없다는 의미이다.
		 */
		if(bNum<=0) {
			pistol = null;
		}
		else {
			pistol = new Gun(bNum);
		}
	}
	//수갑을 채우는 행위
	public void putHandcuff() {
		System.out.println("수갑채움~! 넌 콩밥~!");
		handCuffs--;
	}
	//권총을 발사하는 행위표현
	public void shot() {
		if (pistol==null) {
			//총이 없는 경우 발사할 수 없음
			System.out.println("보유한 권총없음. 헛빵~!");
		}
		else {
			//보유한 경우에만 발사가능
			pistol.shotGun();
		}
	}
}

public class HasAComposite {

	public static void main(String[] args) {
		
		//권총을 보유한 경찰
		System.out.println("==경찰1==");
		Police police1 = new Police(5, 3);
		police1.shot();
		police1.putHandcuff();
		
		///권총을 보유하지 않은 경찰
		System.out.println("==경찰2==");
		Police police2 = new Police(0, 3);
		police2.shot();
		police2.putHandcuff();
		

	}

}
