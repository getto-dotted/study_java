package ex16collection;

//오렌지를 표현하는 클래스
class Orange{
	int sugar;//오렌지의 당도를 표현
	public Orange(int sugar) {
		this.sugar=sugar;
	}
	public void showInfo() {
		System.out.println("오렌지의 당도는 "+ sugar +" 입니다.");
	}
}
//오렌지 객체만 저장할 수 있는 오렌지 전용박스를 표현한 클래스
class OrangeBox{
	Orange item;
	public void store(Orange item) {//저장
		this.item = item;

	}
	public Orange pullOut() {//출고
		return item;
	}
}
//과일상자 : Object를 기반으로 하므로 모든 객체를 저장할 수 있는 클래스
class FruitBox{
	Object item;
	public FruitBox(Object item) {
		this.item = item;
	}
	public void store(Object item) {
		this.item = item;
	}
	public Object pullOut() {
		return item;
	}
	
}
public class GenericBasic {

	public static void main(String[] args) {
		
		OrangeBox oBox1 = new OrangeBox();//오렌지박스 생성
		Orange orange1 = new Orange(10);//오렌지 생성
		oBox1.store(orange1);//상자1에 오렌지1을 저장
		orange1 = oBox1.pullOut();
		orange1.showInfo();//오렌지1의 정보확인
		
/*		
상자1은 오렌지 전용 박스이므로 다른 과일(즉 다른객체)를 저장할 수 없다. 컴파일 에러가 발생하므로 실행자체가 불가능하다		
		oBox1.store("당도가 20인 오렌지"); -> 컴파일 오류 발생
		Orange orange2 = oBox1.pullOut();
		orange2.showInfo();
-> 상자 1은 Orange객체만 저장할 수 있으므로 자료형에는 안전하지만 구현에는 불편함이 있다. 
즉 추가로 사과를 저장해야 한다면 그에 해당하는 클래스를 계속 해서 정의해야한다.		
	*/	
		FruitBox fBox1= new FruitBox(new Orange(20));
		Orange orange3 = (Orange)fBox1.pullOut();
		orange3.showInfo();
/*
		FruitBox fBox2 = new FruitBox("당도가 30인 오렌지");
		Orange orange4 = (Orange)fBox2.pullOut(); -> 형변환 예외 발생
		orange4.showInfo();
-> Object기반의 FruitBox 는 자료형에 대해서는 편리함이 있있고 코드레벨에서 오류가 발생하지 않지만, 실행시 예외가 발생하게 된다.
실행상의 오류는 컴파일 오류보다 문제해결이 어렵다는 특징이 있다.	
*/
	}

}
