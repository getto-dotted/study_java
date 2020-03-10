package ex12Inheritance;

class Rectangle{
	private int horizon;
	private int vertical;
	
	public Rectangle(int x, int y) {
		horizon = x;
		vertical = y;				
	}
	public void ShowAreaInfo() {
		System.out.println("직사각형 면적: "+(horizon*vertical));
	}
	public int getHorizon() {
		return horizon;
	}
	public int getVertical() {
		return vertical;
	}
	
} 

class Square extends Rectangle{
	//멤버변수 : 여기서는 필요 없음.
	//부모클래스에 이미 정의되어 있는 멤버변수를 사용하므로 추가적인 정의불필요

	/*
	생성자 : 정사각형은 가로, 세로의 길이가 동일하므로 매개변수 1개로 2개를 초기화 할 수 있다.
	 */
	public Square(int squareSide) {
    	super (squareSide, squareSide);    	
    }
    
	//멤버메소드 : 오버라이딩 정의(자동완성)
	@Override
	public void ShowAreaInfo() {
		System.out.println("정사각형 면적: "+(getHorizon()*getVertical()));
	}//부모클래스의 멤버변수가 private이므로 직접 접근할 수 없고,
	//getter()를 통해 간접적으로 접근한다.
	
} 

public class QuRectangleMain {

	public static void main(String[] args) {

       	Rectangle rec = new Rectangle(4, 3);
       	rec.ShowAreaInfo();
 
       	Square sqr = new Square(7);
       	sqr.ShowAreaInfo();
	   	
	}

}

//package ex12Inheritance;
///*
//편의성과 관리 목적으로 멤버변수를 모아서 상속용의 메소드만 제공하는 클래스 정의
//for문을 통한 데이터의 배열입력
//abstract문을 이용한 객체 차단과 사용규칙/추상클래스
//
//interface = abstract class/public abstract/public static final
//
//interface와 static을 이용한 날짜정의
//
//Wrapper클래스의 사용례/ 오토박싱+언박싱
// */
////직사각형을 표현한 클래스
//
//class Rectangle{
//	int horizon;
//	int vertical;
//	
//	public Rectangle(int horizon, int vertical) {
//		this.horizon = horizon;
//		this.vertical = vertical;				
//	}
//	
//	public int getArea() {
//		return horizon*vertical;
//	}
//	
//	public void ShowAreaInfo() {
//		System.out.println("직사각형 면적: "+getArea());
//	}
//	
//} 
////정사각형을 표현한 클래스(정사각형은 직사각형의 일종)
//class Square extends Rectangle{
//	int squareSide;
//	
//	public Square(int squareSide) {
//		super (squareSide, squareSide);
//		this.squareSide = squareSide;
//		
//	}
//	
//	public int getSquareArea() {
//		return squareSide*squareSide;
//	}
//	
//	public void ShowAreaInfo() {
//		System.out.println("정사각형 면적: "+getSquareArea());
//	}
//} 
//
//public class QuRectangleMain {
//	
//	public static void main(String[] args) {
//		
//		Rectangle rec = new Rectangle(4, 3);
//		rec.ShowAreaInfo();
//		
//		Square sqr = new Square(7);
//		sqr.ShowAreaInfo();
//		
//	}
//	
//}