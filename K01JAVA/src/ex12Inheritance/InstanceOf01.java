package ex12Inheritance;
/*
instanceof 연산자
	: 객체변수가 어떤 타입의 변수인지를 판단하는 연산자로 형변환(즉 상속관계가 있으면)이 가능하면 true, 불가능하면 false를 반환한다.
	객체가 형변환이 되려면 반드시 두 클래스간에 상속관계가 있어야 한다.
 */

class Box{
	public void boxWrap() {
		System.out.println("Box로 포장합니다.");
	}
}
class PaperBox extends Box{
	public void paperWrap() {
		System.out.println("PaperBox로 포장합니다.");
	}
}
class GoldPaperBox extends PaperBox {
	public void goldWrap() {
		System.out.println("GoldPaperBox로 포장합니다.");
	}
}
public class InstanceOf01 {
	
	/*
	-해당 함수에서 instanceof 연산자를 통해 형변환 가능여부를 판단하는 이유는 전달된 매개변수를ㄹ 최상위 클래스인 BOx타입으로
	받고있기 때문이다.
	-Box타입으로 매개변수를 전달받게 되면 자동으로 업케스팅(자동형변환)이 되기 때문에 자식객체의 메소드를 호출하기 위해서는
	다운캐스팅(명시적형변환)이 필요하게 된다.
	-따라서 전달된 매개변수가 각 객체타입으로 형변환이 가능한지 판단한 후 다운캐스팅을 진행하고 해당 메소드를 호출한다.
	 */
	static void wrapBox(Box b) {
				
		if(b instanceof GoldPaperBox) {
			((GoldPaperBox)b).goldWrap();
		}
		else if(b instanceof PaperBox) {
			((PaperBox)b).paperWrap();
		}
		else if(b instanceof Box) {
			b.boxWrap();
		}
	}
	public static void main(String[] args) {
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		wrapBox(box1);//Box타입
		wrapBox(box2);//PaperBox타입
		wrapBox(box3);//GoldPaperBox타입
		

		
	}

}
