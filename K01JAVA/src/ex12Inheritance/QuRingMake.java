package ex12Inheritance;

class Point{
   int xDot, yDot;
   public Point(int x, int y)   {
	   xDot=x;
	   yDot=y;
   }
   //멤버메소드 : 좌표의 정보를 출력
   public void showPointInfo()   {
	   System.out.println("[x좌표:"+xDot+", y좌표"+yDot+"]");
   }
}

class Circle{    
    //멤버변수
    int radian;//반지름
    Point center;
    //생성자
    public Circle(int x, int y, int r) {
    	this.radian = r;
    	center = new Point(x,y);
    }
    //멤버메소드 : 원의 정보를 출력
    public void showRad() {
    	System.out.println("반지름 : "+radian);
    	/*
    	원의 중심좌표 정보출력: 상속관계가 아니므로 객체를 이용해서 멤버메소드 호출
    	 */
    	center.showPointInfo();
    }
}


class Ring{

    Circle innerCircle;//안쪽의 원
    Circle outerCircle;//바깥쪽의 원
    //생성자
    public Ring(int x1, int y1, int r1, int x2, int y2, int r2) {
    	
    	//상속관계가 아니라 복합관계로 표현되었으므로 super()대신 new 키워드로 객체생성
    	
    	innerCircle = new Circle(x1, y1, r1);
    	outerCircle = new Circle(x2, y2, r2);
    	
    	
    }
    
    public void showRingInfo() {
    	/*
    	링의 정보 출력: 링은 2개의 원으로 구성되므로 각각의 정보를 출력하면 된다.
    	 */
    	System.out.println("안쪽원의 정보 : ");
    	innerCircle.showRad();
       	System.out.println("바깥쪽원의 정보 :");
    	outerCircle.showRad();
    	System.out.println();
    	
    }
}

public class QuRingMake {

	public static void main(String[] args) {
/*
Ring클래스의 매개변수
		: 안쪽원의 중심점(1,1)과 반지름(3)
		  바깥쪽원의 중심점(2,2)과 반지름(9)
 */
		Ring c = new Ring(1,1,3,2,2,9);
        c.showRingInfo();
	}

}

//package ex12Inheritance;
//
//class Point{
//	int xDot, yDot;
//	public Point(int x, int y)   {
//		xDot=x;
//		yDot=y;
//	}
//	//멤버메소드 : 좌표의 정보를 출력
//	public void showPointInfo()   {
//		System.out.println("[x좌표:"+xDot+", y좌표"+yDot+"]");
//	}
//}
//
//class Circle{    
//	//멤버변수
//	int radian;//반지름
//	Point center;
//	//생성자
//	public Circle(int x, int y, int r) {
//		this.radian = r;
//		center = new Point(x,y);
//	}
//	//멤버메소드 : 원의 정보를 출력
//	public void showRad() {
//		System.out.print(radian);    	
//	}
//}
//
//
//class Ring{
//	
//	Point inner;
//	Point outer;
//	Circle innerCircle;//안쪽의 원
//	Circle outerCircle;//바깥쪽의 원
//	//생성자
//	public Ring(int x1, int y1, int r1, int x2, int y2, int r2) {
//		
//		//상속관계가 아니라 복합관계로 표현되었으므로 super()대신 new 키워드로 객체생성
//		
//		innerCircle = new Circle(x1, y1, r1);
//		outerCircle = new Circle(x2, y2, r2);
//		inner = new Point(x1, y1);
//		outer = new Point(x2, y2);
//		
//	}
//	
//	public void showRingInfo() {
//		System.out.printf("안쪽원의 정보 :\n반지름 : ");
//		innerCircle.showRad();
//		System.out.println();
//		inner.showPointInfo();
//		System.out.printf("바깥쪽원의 정보 :\n반지름 : ");
//		outerCircle.showRad();
//		System.out.println();
//		outer.showPointInfo();
//	}
//}
//
//public class QuRingMake {
//	
//	public static void main(String[] args) {
//		/*
//Ring클래스의 매개변수
//		: 안쪽원의 중심점(1,1)과 반지름(3)
//		  바깥쪽원의 중심점(2,2)과 반지름(9)
//		 */
//		Ring c = new Ring(1,1,3,2,2,9);
//		c.showRingInfo();
//	}
//	
//}