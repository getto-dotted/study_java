package review.myfriend;

public class HighFriend extends Friend {
	public String nickname;//별명
	public HighFriend(String name, String phone, String addr,
			String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	/*
	Friend클래스를 상속하게 되면 abstract 메소드를 그대로
	내려받는 꼴이 되기때문에 해당 HighFriend클래스도 abstract
	로 선언해야 된다. 
	해당 클래스를 abstract로 선언하지 않기 위해서는 아래와같이
	오버라이딩 해서 abstract로 선언된 메소드를 가린다. 
	 */
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		System.out.println("이름"+ name);
		System.out.println("전번:"+ phone);
		System.out.println("주소:"+ addr);
		System.out.println("별명:"+ nickname);
	}
}