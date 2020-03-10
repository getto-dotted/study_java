package di;

public class AvengerInfo {

	/*
	멤버변수 : 객체이므로 초기화를 위한 객체가 먼저 생성되어야 함
	 */
	private Avengers avengers;
	//인자생성자
	public AvengerInfo(Avengers avengers) {
		this.avengers = avengers;
	}
	//getter
	public Avengers getAvengers() {
		return avengers;
	}
	/*
	"캡틴" 빈은 XML설정파일에서 생성자를 통해 빈을 생성하므로
	아래 setter가 없어도 무방하지만 "아이언맨" 빈은
	컨트롤러에서 생성하므로 setter가 별도로 필요하다.
	 */
	public void setAvengers(Avengers avengers) {
		this.avengers = avengers;
	}
	//객체정보 출력용 메소드
	public String AvengersView() {
		String returnStr = "";
		if(avengers !=null) {
			returnStr += String.format("본명:%s<br/>", avengers.getName());
			returnStr += String.format("히어로명:%s<br/>", avengers.getHeroName());
			returnStr += String.format("능력:%s<br/>", avengers.getAbility());
			returnStr += String.format("나이:%s<br/>", avengers.getAge());
		}
		
		return returnStr;
	}
}
