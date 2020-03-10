package ex18jdbc.prepared;

import java.util.Date;
import java.util.Scanner;

import ex18jdbc.connect.IConnectImpl;
/*
PreparedStatement 객체를 이용한 JDBC프로그래밍 순서

1. 쿼리문을 준비한다.
	1-1]인파라미터가 없는 쿼리문
	1-2]인파라미터가 있는 쿼리문
		아래 쿼리문처럼 값(value)이 채워져야 할 부분을
		?(물음표)로 대체 작성한후 setXXX() 계열의 메소드를 통해서
		값을 입력한다.
		"insert into 테이블 values(?,?)";
		
2. 쿼리실험을 위한 PreparedStatement 객체를 생성함
	객체생성시 미리 쿼리를 준비해서 Connection객체의 메소드를 통해
	인자로 전달한다. 이때 전달된 쿼리문은 먼저 parsing(파싱)되고 차후 값을 입력받는다.

3. 인파라미터 설정
	3-1]인파라미터가 없는 쿼리문 : 값 설정없이 바로 실행 가능
	3-2]인파라미터가 있는 쿼리문
		-실행전 반드시 값을 설정한다.
		-?가 있는 부분에 인덱스로 접근해서 설정한다.
		-자료형이 number면 setInt(), 문자형이면 setString()을 사용한다.
 */

public class InsertSQL extends IConnectImpl{

	public InsertSQL() {
		super(ORACLE_URL, "korea", "1234");
	}
	
	@Override
	public void execute() {
		try {
			//1.쿼리문 준비 : 값이 필요한 부분은 ?로 대체한다.
			String query = "INSERT INTO member VALUES (?,?,?,?)";
			
			//2.prepared객체 생성 : 쿼리문을 인자로 생성한다.
			psmt = con.prepareStatement(query);
			//3.DB에 입력할 값을 입력받는다.
			Scanner scan = new Scanner(System.in);
			System.out.print("아이디:");
			String id = scan.nextLine();
			System.out.print("패스워드:");
			String pw = scan.nextLine();
			System.out.print("이름:");
			String name = scan.nextLine();
			//4.인파라미터 설정하기 : ?의 인덱스 순서대로 설정한다.
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			/*
			현재날짜를 JAVA에서 입력하는 경우 먼저 util패키지의 Date객체로
			현재날짜를 가져온후 sql패키지의 Date객체로 변환후
			오라클에 입력해야 한다.
			 */
			Date utilDate = new Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			psmt.setDate(4, sqlDate);
/*			날짜를 문자열 형태로 입력하는 경우에는 JAVA에서 생성한후 그대로 입력한다. 
			psmt.setString(4, "2018-11-20");
*/			
			//5. 쿼리실행
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 입력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new InsertSQL().execute();
	}

}
