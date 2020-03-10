package ex13interface;

/*
추상메소드를 포함한 추상클래스 정의. 해당 프로그램에서는 설계도의 역할을 한다.(교안 시나리오 참조)
 */
//abstract class PersonalNumberStorage{
//	public abstract void addPersonalInfo(String juminNum, String name);
//	public abstract String searchPersonalInfo(String juminNum);
//}
interface PersonalNumberStorage{
	void addPersonalInfo(String juminNum, String name);
	String searchPersonalInfo(String juminNum);
}
/*
위 추상클래스를 인터페이스로 변경하려면 
	클래스의 경우 abstract class => interface로 변경
	메소드의 경우 public abstract를 삭제
	변수의 경우 public static final을 삭제하면 된다.
 */
class PersonalNumInfo{
	//멤버변수
	private String name;
	private String juminNum;
	//생성자
	public PersonalNumInfo(String name, String juminNum) {
		this.name = name;
		this.juminNum = juminNum;
	}
	//getter메소드
	String getName() {return name;}
	String getJuminNum() {return juminNum;}
}
/*
 추상클래스를 상속하여 클래스를 정의한다.
 클래스가 클래스를 상속할때는 extends를 사용한다.
 */

//class PersonalNumberStorageImpl extends PersonalNumberStorage{

class PersonalNumberStorageImpl implements PersonalNumberStorage{
//클래스가 인터페이스를 상속할때는 implements를 사용하고, "구현"이라고 표현한다.
	PersonalNumInfo[] personalArr;//정보저장용 객체배열
	int numOfPerInfo;//입력정보 카운트용 변수
	//생성자
	public PersonalNumberStorageImpl(int arrSize) {
		//객체배열을 생성
		personalArr = new PersonalNumInfo[arrSize];
		numOfPerInfo = 0;
	}
	
	@Override
	public void addPersonalInfo(String juminNum, String name) {
//이름과 주민번호를 전달받아 객체생성후 객체배열에 정보를 저장한다		
		personalArr[numOfPerInfo] = new PersonalNumInfo(name, juminNum);
		numOfPerInfo++;
	}
	/*
	부모클래스에 정의된 추상메소드를 오버라이딩 처리하여 재정의함.
	 */
	@Override
	public String searchPersonalInfo(String juminNum) {
//		주민등록번호를 매개변수로 받아서 정보를 검색한 후 일치하는 경우 이름을 반환한다. 루프는 현재 입력된 정보의 갯수만큼 반복한다.
		for (int i = 0; i < numOfPerInfo; i++) {
			if(juminNum.compareTo(personalArr[i].getJuminNum())==0)
			{
				return personalArr[i].getName();
			}
		}
		return null;
	}
}
public class AbstractToInterface {

	public static void main(String[] args) {
		
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(10);
		
		//정보저장
		storage.addPersonalInfo("901234-2222222", "김태희");
		storage.addPersonalInfo("901234-1111111", "정지훈");
		
		//검색
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		System.out.println(storage.searchPersonalInfo("001024-1090333"));
		
		
		
	}

}
