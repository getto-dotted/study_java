package review;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import review.myfriend.Friend;
import review.myfriend.HighFriend;
import review.myfriend.UnivFriend;
/*
Friend객체를 생성후 저장하는 기능을 가지고 있는 클래스로
프로그램에서 매니져 역할을 하는 클래스이다. 주로 핸들러클래스
혹은 매니져 클래스라고 부른다.
 */
class FriendInfoHandler2 {
	//컬렉션으로 구현하기 : Friend객체를 저장할 List객체 생성
	ArrayList<Friend> myFriends;
	Scanner scan = new Scanner(System.in);
	
	public FriendInfoHandler2(int num) {
		//멤버변수를 생성자에서 객체생성함. 
		myFriends = new ArrayList<Friend>();
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
			//List컬렉션에 high객체 저장
			myFriends.add(high);
		}
		else if(choice==2) {
			System.out.print("전공:"); iMajor = scan.nextLine();
			//List컬렉션에 univ객체 저장
			myFriends.add(new UnivFriend(iName, iPhone, iAddr, iMajor));
		}
				
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	
	//친구정보 간략보기
	public void showSimpleData() {
//		일반 for문으로 구현
//		for (int i = 0; i < myFriends.size(); i++) {
//			myFriends.get(i).showBasicInfo();
//		}
//		foreach(개선된 for문)문으로 구현
		for(Friend f: myFriends) {
			f.showBasicInfo();
		}
		System.out.println("==주소록 정보가 출력되었습니다==");
	}
	
	//주소록 검색
	public void searchInfo() {
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		//foreach문으로 구현
//		for(Friend f : myFriends) {
//			if(searchName.compareTo(f.name)==0) {
//				f.showBasicInfo();
//				System.out.println("요청한 이름을 찾았습니다.");
//			}
//		}
		Iterator<Friend> itr = myFriends.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
			System.out.println("Iterator사용");
		}
	}
	public void deleteInfo() {
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		boolean isDelete = false;
		Iterator<Friend> itr = myFriends.iterator();//반복자 생성
		while(itr.hasNext()) {//반복자에 내용이 남아있는 동안
			Friend currentInfo = itr.next();//프랜드타입의 커렌트 인포 객체 = [반복자의 내용]
			if(deleteName.compareTo(currentInfo.name)==0) {//입력받은 이름이 [반복자의 내용]과 같을경우
				itr.remove();//지운다
				isDelete = true;
			}
		}
		if(isDelete==true) {
			System.out.println("==삭제가 완료되었습니다==");
		}
		else {
			System.out.println("==삭제된 데이터가 없습니다=");
		}
		
		
		
//		foreach문으로 구현
//		try {
//			for(Friend d : myFriends) {
//				if(deleteName.compareTo(d.name)==0) {
//					myFriends.remove(d);
//					System.out.println("삭제되었습니다.");
//				}
//			}			
//		}
//		catch(Exception e) {}
/*
컬렉션은 remove()를 통해 객체를 삭제하면 자동으로 인덱스를
재부여하게 되어있어서 foreach문을 통한 삭제시 예외가 발생한다.
 */
	}
}//FriendInfoHandler끝


public class R08collection2 {

	public static void menuShow() {
		
		System.out.println("***메뉴를 선택하세요***");
		System.out.println("1.고딩친구입력");
		System.out.println("2.대딩친구입력");		
		System.out.println("3.친구정보출력");
		System.out.println("4.검색");
		System.out.println("5.삭제");//iterator로 구현
		System.out.println("6.프로그램종료");
		System.out.print("메뉴선택>>>");
	}
	
	public static void main(String[] args) {
		/*
		핸들러 클래스의 객체를 생성한다. 
		이때 정보를 저장할 객체배열의 크기는 100으로 지정한다.
		 */
		FriendInfoHandler2 handler = new FriendInfoHandler2(100);
			
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
			case 5:	//삭제
				handler.deleteInfo();
				break;
			case 6://종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}