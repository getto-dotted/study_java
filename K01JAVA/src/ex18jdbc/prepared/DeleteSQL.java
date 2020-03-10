package ex18jdbc.prepared;

import ex18jdbc.connect.IConnectImpl;

public class DeleteSQL extends IConnectImpl{

	@Override
	public void execute() {
		try {
			//1.DB연결
			connect(ORACLE_URL, "korea", "1234");
			//2.쿼리문 작성
			String query = "DELETE FROM member WHERE id=?";
			//3. 쿼리를 인자로 prepared 객체 생성
			psmt = con.prepareStatement(query);
			//4. 인파라미터 설정
			psmt.setString(1, scanValue("삭제할아이디"));
			//5. 쿼리실행 및 결과값 반환/출력
			System.out.println(psmt.executeUpdate()
					+"행이 삭제되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		
		new DeleteSQL().execute();	
	}

}
