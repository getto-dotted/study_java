package ex12Inheritance;

class MyFriendInfo
{
	private String name;
	int age;
	
	//생성자
	public MyFriendInfo(String _name, int _age) {
		this.name = _name;
		this.age = _age;
	}

	public void ShowMyFriendInfo() {
		
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
	}

}

class MyFriendDetailInfo extends MyFriendInfo
{
	private String addr;
    private String phone;
    //생성자정의: 부모의 멤버변수2개, 자신의 멤버변수2개를 초기화 할 수 있도록 정의
    public MyFriendDetailInfo(String name, int age, String addr, String phone) {
    	//부모의 생성자 호출
    	super(name, age);
    	//자신의 멤버변수 초기화
		this.addr = addr;
		this.phone = phone;
    }
    public void ShowMyFriendDetailInfo()	{
    	ShowMyFriendInfo();
    	System.out.println("주소: "+ addr);
    	System.out.println("전화: "+ phone);
    }
	
}


public class QuMyFriendDetailInfo {

	public static void main(String[] args) {
		
		MyFriendDetailInfo myFriend = new MyFriendDetailInfo("이순신", 100, "성균관", "010-1000-8888");
		
		myFriend.ShowMyFriendDetailInfo();

	}

}
