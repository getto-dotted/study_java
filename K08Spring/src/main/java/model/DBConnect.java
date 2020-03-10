package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {

	// 멤버변수
	Connection con;// DB연결
	PreparedStatement psmt;// 쿼리문 전송 및 결과반환
	ResultSet rs;// select의 결과를 반환받을때 사용

	// 생성자1 : 드라이버와 URL을 매개변수로 전달받아 DB연결
	public DBConnect(String driver, String url) {
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
	// 자원반납
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println("자원반납시 예외발생");
		}
	}
}
