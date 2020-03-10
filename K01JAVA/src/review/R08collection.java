package review;

import java.util.Scanner;

import review.myfriend.Friend;
import review.myfriend.HighFriend;
import review.myfriend.UnivFriend;
/*
Friend객체를 생성후 저장하는 기능을 가지고 있는 클래스로
프로그램에서 매니져 역할을 하는 클래스이다. 주로 핸들러클래스
혹은 매니져 클래스라고 부른다.
 */
class FriendInfoHandler {
	/*
	멤버변수 
		:Friend타입의 객체배열과 객체갯수를 카운트할 변수를 정의함.
	 */
	private Friend[] myFriends;
	private int numOfFriends;
	Scanner scan = new Scanner(System.in);

	public FriendInfoHandler(int num) {
//		생성자 : 객체배열을 num크기로 초기화
		myFriends = new Friend[num];
		numOfFriends = 0;
	}
	//친구 객체를 추가할때 사용하는 메소드
	public void addFriend(int choice) {
		//매개변수 choice는 친구를 구분하는 용도로  사용됨.
		
		//입력받을 항목
		String iName,iPhone,iAddr,iNickname,iMajor;
		
		//입력받기(공통사항)
		System.out.print("이름:"); iName = scan.nextLine();
		System.out.print("전화번호:"); iPhone = scan.nextLine();
		System.out.print("주소:"); iAddr = scan.nextLine();
		
		if(choice==1) {
			//고등학교 친구의 정보를입력
			System.out.print("별명:"); iNickname = scan.nextLine();
			//친구 객체를 생성한후 객체배열에 추가한다. 이때 카운트 변수를 +1(후위증가) 해준다.
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);			
			myFriends[numOfFriends++] = high;
		}
		else if(choice==2) {
			System.out.print("전공:"); iMajor = scan.nextLine();
			
			myFriends[numOfFriends++] = new UnivFriend(iName, iPhone, iAddr, iMajor);
		}
				
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	
	//친구정보 간략보기
	public void showSimpleData() {
		//객체배열에 저장된 친구의 수만큼 반복하면서 멤버메소드를 통해 정보를 출력한다.
		for(int i=0 ; i<numOfFriends ; i++) {
			myFriends[i].showBasicInfo();
		}
		
		System.out.println("==주소록 정보가 출력되었습니다==");
	}
	
	//주소록 검색
	public void searchInfo() {
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		/*
		객체배열에 저장된 친구의 갯수만큼 반복하면서 검색할 이름이 있는지 
		compareTo()메소드를 통해 찾은 후 있다면 해당 정보를 출력한다.
		 */
		for(int i=0 ; i<numOfFriends ; i++) {
			if(searchName.compareTo(myFriends[i].name)==0) {
				myFriends[i].showBasicInfo();				
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
			}
		}
	}
}//FriendInfoHandler끝


public class R08collection {

	public static void menuShow() {
		
		System.out.println("***메뉴를 선택하세요***");
		System.out.println("1.고딩친구입력");
		System.out.println("2.대딩친구입력");		
		System.out.println("3.친구정보출력");
		System.out.println("4.검색");
		System.out.println("5.프로그램종료");
		System.out.print("메뉴선택>>>");
	}
	
	public static void main(String[] args) {
		/*
		핸들러 클래스의 객체를 생성한다. 
		이때 정보를 저장할 객체배열의 크기는 100으로 지정한다.
		 */
		FriendInfoHandler handler = new FriendInfoHandler(100);
			
		while(true) {			
			//메뉴출력을 위한 메소드호출
			menuShow();
			
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:case 2: //친구정보입력
				handler.addFriend(choice);
				break;
			case 3:	//출력
				handler.showSimpleData();
				break;
			case 4:	//검색
				handler.searchInfo();
				break;
			case 5://종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}

