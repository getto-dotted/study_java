package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public DBConnect(String drv, String url) {
		try {
			Class.forName(drv);
			String id = "hr";
			String pw = "1234";
			Connection con = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle DB 연결성공");
		} catch (Exception e) {
			System.out.println("DB 연결실패");
		}
	}
}
