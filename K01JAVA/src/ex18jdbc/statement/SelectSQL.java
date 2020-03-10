package ex18jdbc.statement;

import java.sql.SQLException;

import ex18jdbc.connect.IConnectImpl;

public class SelectSQL extends IConnectImpl{
	//생성자메소드	
	public SelectSQL(String url, String user, String pass) {
		//부모클래스의 인자 3개인 생성자메소드 호출
		super(url, user, pass);
	}
	
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			String query = " SELECT id, pass, name, "
//					+" to_char(regidate, 'yyyy.mm.dd hh24:mi') date_format1 "
					+" regidate "
					+" FROM member "
					+" ORDER BY regidate DESC";
/*executeUpdate() : 쿼리문이 insert/delete/update와 같이 기존 레코드에 영향을 미치는 쿼리를
	실행할 때 사용한다. 실행후 영향을 받은 행의 갯수가 반환된다.
	
executeQuery() : 쿼리문이 select일때 호출하는 메소드로 레코드에 영향을 미치지 않는 쿼리를
	실행한다. 즉, 조회만 진행한다. */
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString("pass");
				String name = rs.getString("name");
//				String regidate = rs.getString("date_format1");
				/*
				date형 자료를 getString메소드로 받아와서 출력하면
				2019-11-20 15:23:41 형태로 출력된다.
				 */
//				String regidate = rs.getString(4);
				/*
				date형 자료를 getDate() 메소드로 받아와서 출력하면 
				2019-11-04 형태로 출력된다. 단 반환타입은 java.sql.Date형이므로 주의해야한다.
				 */
				java.sql.Date regidate = rs.getDate(4);
				
				System.out.printf("%s %s %s %s\n", id, pw, name, regidate);
			}
					
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close();//DB자원반납
		}
	}

/*
ResultSet 클래스
	: select 문 실행시 쿼리의 실행결과가 ResultSet객체에 저장된다.
	결과로 반환된 레코드의 처음부터 마지막까지 next()메소드를 통해 확인후
	반복하면서 추출하게 된다.
	
	-getXXX()계열의 메소드
		Oracle의 자료형이
			number타입 : getInt()
			char/varchar2타입 : getString()
			date타입 : getDate()메소드로 각 컬럼을 추출한다.
		인자는 select절의 컬럼순서대로 인덱스값을 사용하거나
		컬럼명, 별칭(알리아스AS)을 사용할 수 있다.
		단, 자료형에 상관없이 모두 getString()으로 추출할 수 있다.
 */
	public static void main(String[] args) {

		SelectSQL selectSQL = new SelectSQL(ORACLE_URL, "korea", "1234");
		selectSQL.execute();

	}

	
}
