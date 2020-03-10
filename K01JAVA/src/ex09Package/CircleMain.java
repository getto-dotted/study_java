package ex09Package;
/*
메인 클래스에서 다른 패키지의 클래스를 import하여 사용하려면
해당 클래스는 반드시 public으로 선언해야 한다. 그렇지 않으면
not visible 에러가 발생하게 된다.
 */
import ex09Package.korea.perimeter.Circle;

public class CircleMain {

	public static void main(String[] args) {
		
		//원의 넓이 : 풀패키지 경로를 이용했음
		ex09Package.korea.area.Circle circle1 =
				new ex09Package.korea.area.Circle(6.5);
		System.out.println("반지름이 6.5인 원의 넓이: "+ circle1.getArea());

		//원의 둘레 : import를 이용하여 파일을 포함시킴
		Circle circle2 = new Circle(4.5);
		System.out.println("반지름이 4.5인 원의 둘레 : "+ circle2.getPerimeter());
	}

}
