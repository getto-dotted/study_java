//자바파일의 구조
/*
1. 패키지 선언부 : 클래스를 종류별로 묶어서 관리하기 위한 선언으로
 	디렉토리(폴더)의 의미로 이해하면 된다.
 */
package ex01javastart;

/*
2. import 선언부 : 내가 만든 클래스에서 필요한 자바클래스를
	가져다쓰기 위한 선언으로 JDK에서 제공하는 클래스를 사용할 수도 있다.
 */
import java.text.SimpleDateFormat;
import java.util.Date;

/*
주석은 컴파일러가 코드로 인식하지 않는 부분으로 블럭단위 주석과
라인단위 주석이 2가지가 있다.

블럭단위 주석은 / * ~~ * / 형태로 사용한다. 
*/
// 한줄짜리 주석은 슬러쉬 2개를 연속으로 기술한다.


/*
3. 클래스 선언부 : 자바프로그램은 클래스단위로 구성되므로 
	기본적으로 필요한 부분이다. 클래스명은 항상 영대문자로
	시작하고, 파일의 확장자는 .java로 해야한다.
 */
public class JavaStruct {

	public static void main(String[] args) {
		
		System.out.println("자바의 간략한 구조");
		
		Date toDayOfDate = new Date();
		
		System.out.println("오늘날짜:" + toDayOfDate);

		SimpleDateFormat simple = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		String toDayString = simple.format(toDayOfDate);
		System.out.println("변형된날짜:" + toDayString);
		
	}

}


