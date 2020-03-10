package ex08Class;

class Triangle {
	
	private int bottom;
	private int height;
	
	public double getArea() {
		return bottom*height/2;
	}
		
	public void init(int _bottom, int  _height) {
		bottom = _bottom;
		height = _height;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	/*
	public void setBottom(int _bottom) {
		bottom = _bottom;
	}
	
	public void setHeight(int _height) {
		height = _height;
	}
	setter()메소드 자동생성 순서
	멤버변수 선언 -> 우클릭 -> source -> getter and setter -> 선택후 만들기
	*/
	
	
}

public class QuTriangle {

	public static void main(String[] args) {
	
		Triangle t = new Triangle();
	    t.init(10, 17); //밑변10, 높이17로 초기화
	    System.out.println("삼각형의 넓이 : " + t.getArea());
	    t.setBottom(50);//밑변 50으로 변경
	    t.setHeight(14);//높이 14로 변경
	    System.out.println("삼각형의 넓이 : " + t.getArea());


	}

}
