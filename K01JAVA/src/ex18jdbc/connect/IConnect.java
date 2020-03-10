package ex18jdbc.connect;
/*
JDBC작업을 위해서는 항상 드라이버로드, DB연결(커넥션), 
자원해제와 같은 반복적인 작업들이 필요한데 이 부분을
인터페이스로 정의하여 좀 더 편리하게 작업할 수 있도록 코드를 구성한다.
*/
public interface IConnect {

	/*
	멤버상수 : interface에 선언된 변수는 무조건 public static final로 선언되어 정적상수가 된다.
	 */
	String ORACLE_DRIVER= "oracle.jdbc.OracleDriver";
	String ORACLE_URL="jdbc:oracle:thin://@localhost:1521:orcl";
	
	/*
	멤버메소드 : public abstract가 붙어 추상메소드로 선언된다.
	 */
	void connect(String url, String user, String pass);
	void connect(String user, String pass);
	void execute();
	void close();
	//사용자 입력을 위한 추상메소드 선언
	String scanValue(String title);
	
}
