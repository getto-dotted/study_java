package ex10AccessModifier;
class Rectangle
{
	//멤버변수
   private int ulx, uly;//좌상단(upper left x, upper left y)
   private int lrx, lry;//우하단(lower right x, lower right y)
   
   //좌표값이 정상인지 판단하기 위한 변수
   private boolean isTrue = true;
   	//생성자
   	public Rectangle(int ulx, int uly, int lrx, int lry) {
   		/* 
		좌표값이 정상범위안에 있는지 판단하여 초기화한다.
		*/
   		if(isRange(ulx)==false||isRange(uly)==false) {
   			System.out.println("좌상단 좌표오류");
   			isTrue = false;
   		}
   		if(isRange(lrx)==false||isRange(lry)==false) {
   			System.out.println("우하단 좌표오류");
   			isTrue = false;
   		}
   		
   		//우측좌표는 좌측좌표보다 큰 값을 가져야 한다.
   		if(ulx>=lrx || uly>=lry) {
   			System.out.println("좌/우측 좌표지정 오류");
   			isTrue = false;
   		}
   		//멤버변수 초기화
   		this.ulx = ulx;
   		this.uly = uly;
   		this.lrx = lrx;
   		this.lry = lry;
   	}   	   	
   	public boolean isRange(int point) {
   		if(point<0 || point>100) {
   			//0과 100사이의 범위를 벗어나면 잘못된 좌표값
   			return false;
   		}
   		else {
   			//범위내의 정상 좌표값
   			return true;
   		}
   	}
   	public void showArea()
   	{
   		if(isTrue==false) {
   			System.out.println("좌표값 오류로 넓이 계산 불가");
   			//좌표값이 오류일때는 넓이계산없이 함수종료
   			return;
   		}
   		/* 사각형의 넓이를 구하는 메소드 정의 */
   		int xLength = lrx-ulx;
   		int yLength = lry -uly;
   		System.out.println("사각형의 넓이:"+(xLength*yLength));
   	}  	
}

public class QuRectangle {

	public static void main(String[] args) {
		
		/*여기부터
 		Rectangle rec = new Rectangle();
 		rec.ulx=22;
 		rec.uly=22;
 		rec.lrx=10;
 		rec.lry=10;
	여기까지는 정보은닉후 실행되지 않게 해야한다....
*/

	//아래 생성자로만 객체생성후 초기화 되도록 처리한다...
	Rectangle rec1 = new Rectangle(1,1,10,10);
	rec1.showArea();
	
	Rectangle rec2 = new Rectangle(-2,-2,101,101);
	rec2.showArea();
	
	Rectangle rec3 = new Rectangle(10,10,1,1);
	rec3.showArea();


	}

}
