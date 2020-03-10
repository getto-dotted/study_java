package ex18jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQL {

	//멤버변수
	Connection con;//DB연결을 위한 객체
	Statement stmt;//쿼리전송 및 실행을 위한 객체
	
	//생성자 : DB연결을 처리함
	public DeleteSQL() {
		try {		
			//1. 오라클 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			System.out.println("Oracle DB 연결성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}
		
		catch(Exception e) {
			System.out.println("알 수 없는 예외발생");
		}		
	}//end of InsertSQL
	private void connect() {
		try {
			//2.커넥션 객체를 통해 연결
			con = DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:orcl",
					"korea",
					"1234");
		}
		catch(SQLException e) {
			System.out.println("DB연결실패");
			e.printStackTrace();
		}
	}
	
	//실제 쿼리작성 및 실행을 위한 메소드
	private void execute() {
		//데이터베이스 연결
		connect();
		try {
			//3.Statement 계열의 객체를 생성하여 쿼리실행준비
			stmt = con.createStatement();
			//4.delete쿼리 작성
			String sql = "delete from member "
					+" where id='test2' ";			
			//5.쿼리실행 및 반환값받기
			int affected = stmt.executeUpdate(sql);
			System.out.println(affected +"행이 삭제되었습니다.");
		}
		catch(SQLException e) {
			System.out.println("쿼리실행에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
		finally {
			//6.연결된 자원 반납
			close();
		}
	}//end of execute
	//자원반납을 위한 메소드
	private void close() {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("DB자원반납완료");
		}
		catch(SQLException e) {
			System.out.println("자원반납시 오류가 발생하였습니다.");
		}
	}//end of close
	
	public static void main(String[] args) {
		//실행방법1 : 참조변수 없이 객체생성과 동시에 메소드 호출
		//new InsertSQL().execute();
		
		//실행방법2: 객체생성후 참조변수에 대입후 메소드 호출
		DeleteSQL insertSQL = new DeleteSQL();
		insertSQL.execute();
	}//main end

}
