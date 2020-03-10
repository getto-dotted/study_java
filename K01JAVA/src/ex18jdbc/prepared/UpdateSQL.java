package ex18jdbc.prepared;

import java.sql.SQLException;

import ex18jdbc.connect.IConnectImpl;

public class UpdateSQL extends IConnectImpl{

	public UpdateSQL() {
		super(ORACLE_URL, "korea", "1234");
	}
	
	@Override
	public void execute() {
		//1.쿼리문 준비
		String sql = " UPDATE member SET name = ?, pass=? WHERE id=?";
		try {
			//2.쿼리문을 기반으로 prepared 객체생성
			psmt = con.prepareStatement(sql);
			//3.exit를 입력받기 전까지 무한반복 됨
			while(true) {
				//4.인파라미터값 입력 및 설정
				psmt.setString(3, scanValue("아이디"));
				psmt.setString(1, scanValue("이름"));
				psmt.setString(2, scanValue("패스워드"));
				//5.쿼리문 실행 및 반환
				int affected = psmt.executeUpdate();
				System.out.println(affected+"행이 업데이트 되었습니다.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new UpdateSQL().execute();

	}

}
