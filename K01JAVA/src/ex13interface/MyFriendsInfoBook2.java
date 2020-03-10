package ex13interface;

import java.util.Scanner;

class Friend2 {
	String name; 
	String phone; 
	String addr;
	public Friend2(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showBasicInfo() {
	
	}
}
class HighFriend2 extends Friend2{
	String nickname;
	public HighFriend2(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		System.out.println("이름 : "+name);
		System.out.println("전번 : "+phone);
		System.out.println("주소 : "+addr);
		System.out.println("별명 : "+nickname);
	}
}
class UnivFriend2 extends Friend2{
	String major;
	public UnivFriend2(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.println("이름 : "+name);
		System.out.println("전번 : "+phone);
		System.out.println("사는곳 : "+addr);
		System.out.println("전공 : "+major);
	}
}
public class MyFriendsInfoBook2 {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		/*
		상속관계에 있어 Friend 클래스는 최상위 클래스이므로 해당 객체배열에
		하위 클래스의 객체를 한꺼번에 저장할 수 있다. 상위 클래스의 객체가
		하위 클래스의 객체를 참조할 수 있다는 "다형성" 개념을 활용한 방법이다.
		 */
		Friend2[] friArr = new Friend2[100];
		//객체배열의 index로 사용할 변수
		int frIndex = 0;		
		String iName, iPhone, iAddr, iNickname, iMajor;
		
		for(int i =0; i<2; i++) {
			System.out.println("==고딩 친구를 입력하세요==");
			System.out.println("이름: "); iName = scan.nextLine();
			System.out.println("전화번호: "); iPhone = scan.nextLine();
			System.out.println("주소: "); iAddr = scan.nextLine();
			System.out.println("별명: "); iNickname = scan.nextLine();
			HighFriend2 high = new HighFriend2(iName, iPhone, iAddr, iNickname);
			//high.showBasicInfo();
			/*
			frIndex의 초기값은 0이므로, 0번 index에 데이터가 저장된 후 
			+1 증가한다.
			 */
			friArr[frIndex++] = high;
		}
		for(int i =0; i<2; i++) {
			System.out.println("==대딩 친구를 입력하세요==");
			System.out.println("이름: "); iName = scan.nextLine();
			System.out.println("전화번호: "); iPhone = scan.nextLine();
			System.out.println("주소: "); iAddr = scan.nextLine();
			System.out.println("전공: "); iMajor = scan.nextLine();
			UnivFriend2 univ = new UnivFriend2(iName, iPhone, iAddr, iMajor);
			//univ.showBasicInfo();
			friArr[frIndex++] = univ;
		}
		/*
		주소록에 저장된 모든 친구정보를 출력한다. 친구의 구분에 상관없이
		showBasicInfo()메소드를 호출하면 오버라이딩 처리된 가장 하위의
		메소드가 호출되므로 별도처리는 필요 없다.
		 */
		for(int i =0; i< frIndex; i++) {
			friArr[i].showBasicInfo();
		}
		
		System.out.println("==친구 정보를 입력하세요==");
		System.out.println("이름: "); iName = scan.nextLine();
		System.out.println("전화번호: "); iPhone = scan.nextLine();
		System.out.println("주소: "); iAddr = scan.nextLine();		
		Friend2 fri = new Friend2(iName, iPhone, iAddr);
		fri.showBasicInfo();
		
	}

}
