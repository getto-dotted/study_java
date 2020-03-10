package ex11Static;

class InstCnt{
	
	//프로그램 시작시 미리 메소드영역에 생성된다
	static int instNum=0;
	//객체생성시 생성된다
	int Num=0;
	public InstCnt() {
		//미리 생성된 변수가 +1증가한다
		
		instNum++;
		
		//객체가 생성되는 시점에 +1증가한가,
		Num++;
		System.out.println("static변수:"+instNum);
		System.out.println("멤버변수:"+Num);
	}
}
public class StaticCount {

	public static void main(String[] args) {
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();
		/*
		객체가 총3번 생성된 후 결과는 
		instNum=>3(메소드 영역에 하나만 있음)
		Num= >1(각각의 객체가가지고 있음) 
		 */

		//일반적인 멤버변수의 접근방법
		cnt1.Num=10;
		
		//static(정적)변수의 접근방법
		cnt1.instNum=100;//방법1: 참조변수를 통해 접근
		InstCnt.instNum=200;//방법2: 클래스를 통해접근
	}

}
