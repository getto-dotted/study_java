package ex13interface;

import java.util.Scanner;
//상속을 목적으로 정의한 클래스로 해당 클래스로는 객체를 생성하지 않는다.
class Friend {
	String name; //이름
	String phone; //전번
	String addr; //주소
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showBasicInfo() {
	//오버라이딩의 목적으로 정의된 메소드
	//(그래서 실행부가 없음)
	}
}
class HighFriend extends Friend{
	String nickname;
	public HighFriend(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	//부모에서 생성된 메소드를 오버라이딩(재정의) 선언
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		System.out.println("이름 : "+name);
		System.out.println("전번 : "+phone);
		System.out.println("주소 : "+addr);
		System.out.println("별명 : "+nickname);
	}
}
class UnivFriend extends Friend{
	String major;
	public UnivFriend(String name, String phone, String addr, String major) {
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
public class MyFriendsInfoBook {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String iName, iPhone, iAddr, iNickname, iMajor;
		
		System.out.println("==고딩 친구를 입력하세요==");
		System.out.println("이름: "); iName = scan.nextLine();
		System.out.println("전화번호: "); iPhone = scan.nextLine();
		System.out.println("주소: "); iAddr = scan.nextLine();
		System.out.println("별명: "); iNickname = scan.nextLine();
		HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
		high.showBasicInfo();
		/*
		HighFriend[] highArr = new HighFriend[100];
		highArr[0] = high;
		객체배열
		*/
		System.out.println("==대딩 친구를 입력하세요==");
		System.out.println("이름: "); iName = scan.nextLine();
		System.out.println("전화번호: "); iPhone = scan.nextLine();
		System.out.println("주소: "); iAddr = scan.nextLine();
		System.out.println("전공: "); iMajor = scan.nextLine();
		UnivFriend univ = new UnivFriend(iName, iPhone, iAddr, iMajor);
		univ.showBasicInfo();
		
		/*Friend클래스의 showBasicInfo()메소드에는 아무런 기능이 정의되어
		있지 않으므로 아래에서는 정보가 전혀 출력되지 않는다.
		즉 상속의 목적으로만 정의한 클래스를 통해 객체를 생성한 것은
		논리적 오류(실수)가 발생된 것이다.
		*/
		System.out.println("==친구 정보를 입력하세요==");
		System.out.println("이름: "); iName = scan.nextLine();
		System.out.println("전화번호: "); iPhone = scan.nextLine();
		System.out.println("주소: "); iAddr = scan.nextLine();		
		Friend fri = new Friend(iName, iPhone, iAddr);
		fri.showBasicInfo();
		/*
		Friend[] friArr = new Friend[100];
		friArr[0] = univ;
		friArr[1] = high;

		friArr[0].showBasicInfo();
		friArr[1].showBasicInfo();
		Friend 객체로 모두 저장 가능
		*/
	}

}
