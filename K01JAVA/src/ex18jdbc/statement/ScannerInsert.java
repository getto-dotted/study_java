package ex18jdbc.statement;

import java.sql.SQLException;

import ex18jdbc.connect.IConnectImpl;

public class ScannerInsert extends IConnectImpl{

	
	public ScannerInsert() {
		super("korea", "1234");		
	}

	@Override
	public void execute() {
	
		try {
			stmt = con.createStatement();
			
			String id = scanValue("아이디");
			String pass = scanValue("패스워드");
			String name = scanValue("이름");
			
			String sql = "INSERT INTO member VALUES "
					+" ('"+id+"','"+pass+"','"+name+"',SYSDATE)";
			int affected = stmt.executeUpdate(sql);
			System.out.println(affected+"행이 입력되었습니다.");
		}
		catch(SQLException e) {
			System.out.println("쿼리실행에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
		finally{
			close();
		}
	}
	
	public static void main(String[] args) {
		new ScannerInsert().execute();

	}

}
