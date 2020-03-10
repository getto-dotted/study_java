package ex18jdbc.connect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IConnectImpl implements IConnect{

	//멤버변수
	public Connection con;//DB연결을 위한 객체
	public Statement stmt;//정적쿼리 처리를 위한 객체
	public ResultSet rs;//select의 결과를 처리하기 위한 객체
	public PreparedStatement psmt;//동적쿼리 처리를 위한 객체
	
	//기본생성자 : 하는 일 없음
	public IConnectImpl() {
		System.out.println("기본생성자");
	}
	//인자생성자
	public IConnectImpl(String url, String user, String pass) {
		System.out.println("인자생성자 호출");
		try {		
			//1.오라클 드라이버 로드
			Class.forName(ORACLE_DRIVER);
			//2.DB연결
			connect(url, user, pass);
			
			System.out.println("Oracle DB 연결성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}		
		catch(Exception e) {
			System.out.println("알 수 없는 예외발생");
		}		
	}
	public IConnectImpl(String user, String pass) {
		System.out.println("인자생성자 호출");
		try {		
			//1.오라클 드라이버 로드
			Class.forName(ORACLE_DRIVER);
			//2.DB연결
			connect(user, pass);
			
			System.out.println("Oracle DB 연결성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}		
		catch(Exception e) {
			System.out.println("알 수 없는 예외발생");
		}		
	}
	//실제 DB연결을 처리하는 멤버메소드
	@Override
	public void connect(String url, String user, String pass) {
		try {			
			con = DriverManager.getConnection(ORACLE_URL,user,pass);
			System.out.println("오라클 DB연결성공");
		}
		catch(SQLException e) {
			System.out.println("DB연결실패");
			e.printStackTrace();
		}
		
	}

	@Override
	public void connect(String user, String pass) {
		try {
			//2.커넥션 객체를 통해 연결
			con = DriverManager.getConnection(
					ORACLE_URL, user,pass);
		}
		catch(SQLException e) {
			System.out.println("DB연결실패");
			e.printStackTrace();
		}
		
	}
	/*
	오버라이딩의 목적으로만 정의한 메소드로 실제 쿼리에 대한 처리는
	해당 업무를 진행하는 클래스에서 진행한다.
	 */
	@Override
	public void execute() {
		//몸체없음
		
	}

	//DB작업을 모두 마친 후 사용했던 자원을 반납하는 메소드
	@Override
	public void close() {
		try {
			//Statement객체 자원반납
			if(stmt!=null) stmt.close();
			//Connection객체 자원반납
			if(con!=null) con.close();
			//ResultSet객체 자원반납
			if(rs!=null) rs.close();
			//Prepared객체 자원반납
			if(psmt!=null) psmt.close();
			System.out.println("DB자원반납완료");
		}
		catch(SQLException e) {
			System.out.println("자원반납시 오류가 발생하였습니다.");
		}
		
	}
	@Override
	public String scanValue(String title) {
		Scanner scan = new Scanner(System.in);
		System.out.print(title+"을(를) 입력(exit -> 종료):");
		String inputStr =scan.nextLine();
		/*
		equalsIgnoreCase() : 대소문자 구분없이 문자열을 비교하는 함수.
		equals()는 대소문자 구분함.
		 */
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			close();//자원반납
			System.exit(0);//프로그램 자체가 즉시 종료됨
		}
		
		return inputStr;
	}

	
}
