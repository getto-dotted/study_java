package ex16collection;

class Apple{
	int weight;
	public Apple(int w) {
		weight=w;
	}
	public void showInfo() {
		System.out.println("사과의 무게는 "+ weight +" 입니다.");
	}
}

class Banana{
	int sugar;
	public Banana(int s) {
		sugar=s;
	}
	public void showInfo() {
		System.out.println("바나나의 당도는 "+ sugar +" 입니다.");
	}
}
/*
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
기존 Object기반의 FruitBox를 아래와 같이 제네릭 클래스로 변경할 수 있다.
자료형에 해당하는 부분을 대표문자 T(Type)으로 교체하고 객체 생성시 자료형을
결정하기 위해 클래스명<T>형태로 수정한다.
 */

class GenericFruitBox<T>{
	T item;	
	public void store(T item) {
		this.item = item;
	}
	public T pullOut() {
		return item;
	}
	
}
public class GenericClass {

	public static void main(String[] args) {
/*
각 객체생성시 T부분을 해당 객체로 설정하므로 구현의 편의성이 보장된다.
 */
		//제네릭 클래스를 기반으로 Apple박스 생성
		GenericFruitBox<Apple> appleBox = new GenericFruitBox<Apple>();
		appleBox.store(new Apple(10));
		Apple apple = appleBox.pullOut();
		apple.showInfo();
		
		//제네릭 클래스를 기반으로 Banana박스 생성
		GenericFruitBox<Banana> BananaBox = new GenericFruitBox<Banana>();
		BananaBox.store(new Banana(20));
		Banana Banana = BananaBox.pullOut();
		Banana.showInfo();
		
/*
		Orange 박스를 생성하는 경우 T를 Orange 타입으로 결정했으므로 다른 객체는 저장할 수 없다. 
		즉 컴파일 오류가 발생되어 자료형에도 안전한 클래스가 된다.
		GenericFruitBox<Orange> orangeBox = new GenericFruitBox<Orange>();
		orangeBox.store("나는 오렌지"); <-컴파일에러발생
		orangeBox.store(apple); 
		orangeBox.store(Banana); 
*/		
	}

}
