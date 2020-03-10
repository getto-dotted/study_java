package ex18jdbc.statement;

import java.sql.SQLException;

import ex18jdbc.connect.IConnectImpl;

public class UpdateSQL extends IConnectImpl {

	public UpdateSQL(String user, String pass) {
		super(user, pass);
	}
	
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			
			String sql = "UPDATE member "
					+ " SET "
					+ " pass='999', "
					+" name='수정됨', "
					+" regidate=sysdate "
					+" WHERE id='test1' ";
			//디버깅을 위한 쿼리문 출력
			System.out.println("sql="+sql);
			
			int affected = stmt.executeUpdate(sql);
			System.out.println(affected +"행이 업데이트 됨");					
		}
		catch(SQLException e) {
			System.out.println("쿼리오류");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("알 수 없는 예외발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
	
		new UpdateSQL("korea", "1234").execute();

	}

}
