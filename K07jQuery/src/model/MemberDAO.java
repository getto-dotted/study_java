package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*
DAO(Data Access Object) : 주로 DB에 접근해서 작업하기 위한 객체
	DB접속, 쿼리 전송 및 결과 반환 등의 업무를 처리한다.
 */
public class MemberDAO {

	Connection con;
	PreparedStatement psmt;
	ResultSet rs;

	public MemberDAO(String driver, String url) {
		try {
			
			Class.forName(driver);			
			String id = "korea";
			String pw = "1234";
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle DB 연결성공");
		} catch (Exception e) {
			System.out.println("DB 연결실패;");
		}
	}	

	public boolean isMember(String id, String pass) {
		/*
		매개변수로 아이디와 패스워드를 받아서 select문을 실행후
		회원이 존재하면 1, 존재하지 않으면 0을 반환한다.
		즉 회원의 존재유무만 판단할 수 있다.
		 */
		String sql = " SELECT COUNT(*) FROM member WHERE id=? AND pass=? ";
		int isMember = 0;
		boolean isFlag = false;
		try {
			//쿼리문을 매개변수로 prepare객체생성
			psmt = con.prepareStatement(sql);
			//인파라미터설정
			psmt.setString(1, id);
			psmt.setString(2, pass);
			//쿼리실행
			rs = psmt.executeQuery();
			//반환된 결과 읽기
			rs.next();
			//결과가 숫자이므로 getInt()로 값 얻어옴
			isMember = rs.getInt(1);
			System.out.println("affected:" + isMember);
			if (isMember == 0)
				isFlag = false;
			else
				isFlag = true;

		} catch (Exception e) {
			//예외가 발생되면 정상적으로 실행이 된 것이 아니므로 false반환
			isFlag = false;
			e.printStackTrace();
		}
		return isFlag;
	}
	
	public MemberDTO getMemberDTO(String id, String pwd) {
		
		MemberDTO dto = new MemberDTO();
		
		String query = " SELECT id, pass, name FROM member WHERE id=? and pass=? ";
				
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString(1));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
			}
			else {
				System.out.println("일치하는 회원정보 없음");
			}
		} catch (Exception e) {
			System.out.println("쿼리 실행중 오류 발생됨");
			e.printStackTrace();
		}
		return dto;
	}

}
