package dataObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import picController.PicDTO;


public class MemberDAO {
	

	Connection con;
	PreparedStatement psmt;
	ResultSet rs;

	public MemberDAO() {}

	public MemberDAO(ServletContext application) {
		try {
			Class.forName(application.getInitParameter("JDBCDriver"));
			String id = "project1";
			String pw = "1234";
			con = DriverManager.getConnection(application.getInitParameter("ConnectionURL"), id, pw);
			System.out.println("DB 연결성공");
		} 
		catch (Exception e) {
			System.out.println("DB 연결실패;");
		}
	}
	
	public MemberDAO(String driver, String url) {
		try {

			Class.forName(driver);
			String id = "project1";
			String pw = "1234";
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("Oracle DB 연결성공");
		} catch (Exception e) {
			System.out.println("DB 연결실패;");
		}
	}

	public MemberDTO joinMember(String id, String pass, String name, String tel, String mobile, String email, String zipcode,
			String addr, String email_open, int grade, String addr2) {

		MemberDTO dto = new MemberDTO();

		String query = " INSERT INTO member(id, pass, name, tel, mobile, email, zipcode, addr, email_open, grade, addr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			psmt.setString(3, name);
			psmt.setString(4, tel);
			psmt.setString(5, mobile);
			psmt.setString(6, email);
			psmt.setString(7, zipcode);
			psmt.setString(8, addr);
			psmt.setString(9, email_open);
			psmt.setInt(10, grade);
			psmt.setString(11, addr2);
			

			rs = psmt.executeQuery();

			System.out.println(query);
		} catch (Exception e) {
			System.out.println("회원가입중 오류발생");
			System.out.println(query);			
			e.printStackTrace();
		}
		return dto;
	}
	
	public MemberDTO getMemberDTO(String id, String pass) {

		MemberDTO dto = new MemberDTO();

		String query = " SELECT id, pass, name FROM member WHERE id=? and pass=? ";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setId(rs.getString(1));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
			} else {
				System.out.println("일치하는 회원정보 없음");
			}
		} catch (Exception e) {
			System.out.println("쿼리 실행중 오류 발생됨");
			e.printStackTrace();
		}
		return dto;
	}
	//자원반납하기
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
	
	public int IDCheck(String id) {		

		String query = " SELECT COUNT(*) FROM member WHERE id = ? ";		
		
		int affected=0;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			rs.next();
			if (rs.getInt("count(*)")==0) {
				affected=0;
				//사용가능 ID
			} else {
				affected=1;
				//중복된 ID
			}
		} catch (Exception e) {
			System.out.println("쿼리 실행중 오류 발생됨");
			e.printStackTrace();
		}	
		
		return affected;
	}
	//회원등급 확인
	public int gradeCheck(String id) {
		
		MemberDTO dto = new MemberDTO();
		
		String query = " SELECT grade FROM member WHERE id=? ";
			
		int grade = 0;
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				grade = rs.getInt("grade");				
			}
		} catch (Exception e) {
			System.out.println("쿼리 실행중 오류 발생됨");
			e.printStackTrace();
		}			
		return grade;
	}
	
	public String findId(String name, String email) {
		
		String query = " SELECT id FROM member WHERE name=? AND email=? ";
		
		String id = "";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, name);
			psmt.setString(2, email);
			rs = psmt.executeQuery();
			if(rs.next()) {
				id=rs.getString(1);
			}
		}	
		catch (Exception e) {
			System.out.println("쿼리 실행중 오류 발생됨");
			e.printStackTrace();
		}	
		
		System.out.println(id);
		return id;
	}
	
	public String findPw(String id, String name, String email) {
		
		String query = " SELECT pass FROM member WHERE name=? AND email=? AND id=? ";
		
		String pw = "";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, name);
			psmt.setString(2, email);
			psmt.setString(3, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				pw=rs.getString(1);
			}
		}	
		catch (Exception e) {
			System.out.println("쿼리 실행중 오류 발생됨");
			e.printStackTrace();
		}			
		return pw;
	}
	
	
	public List<MemberDTO> selectListPage(String id){
		List<MemberDTO> bbs = new Vector<MemberDTO>();
		
		String sql = " SELECT * FROM member WHERE id=? ";
		try {
			
			psmt = con.prepareStatement(sql);			
			psmt.setString(1, id);			

			rs = psmt.executeQuery();
			while (rs.next()) {
			
				//반환된 결과셋의 갯수만큼 반복하면서 DTO객체에 레코드 저장후 컬렉션에 누적 저장
				MemberDTO dto = new MemberDTO();

				dto.setName(rs.getString(3));
				dto.setZipcode(rs.getString(7));
				dto.setAddr(rs.getString(8));
				dto.setAddr2(rs.getString(11));
				dto.setMobile(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setEmail_open(rs.getShort(9));
								
				bbs.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Select시 예외발생");
			e.printStackTrace();
		}
		// 누적 저장된 컬렉션 반환
		return bbs;
	}
}
