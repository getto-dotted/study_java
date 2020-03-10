package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

public class BbsDAO {
	// 멤버변수
	Connection con;// DB연결
	PreparedStatement psmt;// 쿼리문 전송 및 결과반환
	ResultSet rs;// select의 결과를 반환받을때 사용

	// 생성자1 : 드라이버와 URL을 매개변수로 전달받아 DB연결
	public BbsDAO(String driver, String url) {
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

	/*
	 * 생성자2 : JAVA영역에서는 JSP의 내장객체를 바로 사용하는 것이 불가능하므로, JSP에서 내장객체를 매개변수로 전달받아 사용해야
	 * 한다. application내장객체는 ServletContext 타입을 가지므로 아래와 같이 전달받을 수 있다.
	 */
	public BbsDAO(ServletContext application) {
		try {

			Class.forName(application.getInitParameter("JDBCDriver"));
			String id = "korea";
			String pw = "1234";
			con = DriverManager.getConnection(application.getInitParameter("ConnectionURL"), id, pw);
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

	// 게시판 리스트 가져오기(간단버전: 페이지처리X,검색X)
	public List<BbsDTO> selectList() {
		// select한 결과셋을 저장하기 위한 리스트 컬렉션 생성
		List<BbsDTO> bbs = new Vector<BbsDTO>();
		// ArrayList<BbsDTO> bbs = new ArrayList<BbsDTO>();

		// 게시물 전체를 가져오기 위한 쿼리문 작성
		String query = "SELECT * FROM board ORDER BY num DESC";

		try {
			// 쿼리실행을 위한 prepare객체 생성 및 쿼리전송
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while (rs.next()) {
				/*
				 * 반환된 결과셋의 갯수만큼 반복하면서 DTO객체에 레코드 저장후 컬렉션에 누적 저장
				 */
				BbsDTO dto = new BbsDTO();

				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString(3));
				dto.setpostdate(rs.getDate(4));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));

				bbs.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Select시 예외발생");
			e.printStackTrace();
		}
		// 누적 저장된 컬렉션 반환
		return bbs;
	}

	// 게시판리스트(검색o, 페이지x)
	public List<BbsDTO> selectList(Map<String, Object> param) {
		// select한 결과셋을 저장하기 위한 리스트 컬렉션 생성
		List<BbsDTO> bbs = new Vector<BbsDTO>();
		// ArrayList<BbsDTO> bbs = new ArrayList<BbsDTO>();

		// 게시물 전체를 가져오기 위한 쿼리문 작성
		String query = "SELECT * FROM board ";
		if (param.get("Word") != null) {
			query += " WHERE " + param.get("Column") + "" + " LIKE '%" + param.get("Word") + "%'";
		}
		query += " ORDER BY num DESC";
		System.out.println("query=" + query);
		try {
			// 쿼리실행을 위한 prepare객체 생성 및 쿼리전송
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while (rs.next()) {
				/*
				 * 반환된 결과셋의 갯수만큼 반복하면서 DTO객체에 레코드 저장후 컬렉션에 누적 저장
				 */
				BbsDTO dto = new BbsDTO();

				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString(3));
				dto.setpostdate(rs.getDate(4));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));

				bbs.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Select시 예외발생");
			e.printStackTrace();
		}
		// 누적 저장된 컬렉션 반환
		return bbs;
	}

	public int insertWrite(BbsDTO dto) {
		int affected = 0;
		try {
			String query = "INSERT INTO board (num, title, content, id, visitcount) "
					+ " VALUES ( seq_board.NEXTVAL, ?, ?, ?, 0) ";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());

			affected = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert중 예외발생");
			e.printStackTrace();
		}

		return affected;
	}

	public BbsDTO selectView(String num) {
		BbsDTO dto = new BbsDTO();
		String query = "SELECT*FROM board WHERE num=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString("content"));
				dto.setpostdate(rs.getDate(4));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));
			}

		} catch (Exception e) {
			System.out.println("상세보기시 예외발생");
			e.printStackTrace();
		}
		return dto;
	}

	public void updateVisitCount(String num) {
		String query = " UPDATE board SET visitcount=visitcount+1 WHERE num=? ";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeQuery();
		} catch (Exception e) {
			System.out.println("조회수 증가시 예외발생");
			e.printStackTrace();
		}
	}

	public int updateEdit(BbsDTO dto) {
		int affected = 0;
		try {
			String query = "UPDATE board SET title=?, content=? WHERE num=? ";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());

			affected = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("update중 예외발생");
			e.printStackTrace();
		}
		return affected;
	}

	public int delete(BbsDTO dto) {
		int affected = 0;
		try {
			String query = " DELETE FROM board WHERE num=? ";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getNum());

			affected = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("delete중 예외발생");
			e.printStackTrace();
		}
		return affected;
	}

	// 전체 레코드수를 카운트해서 반환하는 메소드
	public int getTotalRecordCount(Map<String, Object> map) {
		int totalCount = 0;
		String query = " SELECT COUNT(*) FROM board ";
		// 검색이 있는경우 where절을 추가한다.
		if (map.get("Word") != null) {
			query += " WHERE " + map.get("Column") + " " + " LIKE '%" + map.get("Word") + "%'";
		}
		System.out.println("query=" + query);

		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			rs.next();
			totalCount = rs.getInt(1);

		} catch (Exception e) {
		}
		return totalCount;
	}
	
	
	
	// 게시판 리스트 가져오기(페이징버전: 페이지처리o,검색o)
	public List<BbsDTO> selectListPaging(Map<String, Object> param) {

		List<BbsDTO> bbs = new Vector<BbsDTO>();

		String query = "" + "SELECT * FROM ( SELECT Tb. *, rownum rNum FROM (SELECT*FROM board ";

		if (param.get("Word") != null) {
			query += " WHERE " + param.get("Column")+ " LIKE '%" + param.get("Word") + "%'";
		}

		query += "  ORDER BY num DESC ) Tb )  WHERE rNum BETWEEN ? AND ?  ";

		try {
			// 쿼리실행을 위한 prepare객체 생성 및 쿼리전송
			psmt = con.prepareStatement(query);

			// JSP에서 계산한 페이지 범위값을 이용해 인파라미터를 설정한다.
			psmt.setString(1, param.get("start").toString());
			psmt.setString(2, param.get("end").toString());

			rs = psmt.executeQuery();
			while (rs.next()) {
				/*
				 * 반환된 결과셋의 갯수만큼 반복하면서 DTO객체에 레코드 저장후 컬렉션에 누적 저장
				 */
				BbsDTO dto = new BbsDTO();

				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString(3));
				dto.setpostdate(rs.getDate(4));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));

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
