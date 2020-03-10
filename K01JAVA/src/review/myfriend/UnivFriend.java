package review.myfriend;

public class UnivFriend extends Friend	{
	public String major;//전공과목
	public UnivFriend(String name, String phone, String addr,
			String major) {
		super(name, phone, addr);
		this.major = major;
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
		System.out.println("사는곳:"+ addr);
		System.out.println("전공:"+ major);
	}
}