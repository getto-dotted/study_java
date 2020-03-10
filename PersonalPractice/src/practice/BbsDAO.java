package practice;

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

	/*
	생성자 : JAVA영역에서는 JSP의 내장객체를 바로 사용하는 것이 불가능하므로, JSP에서 내장객체를 매개변수로 전달받아 사용해야 한다.
	application내장객체는 ServletContext 타입을 가지므로 아래와 같이 전달받을 수 있다. 설정에서 아파치 톰캣을 연결
	시켜야 ServletContext를 임포트할 수 있다.
	*/

	public BbsDAO(ServletContext ctx) {

		try {
			
			Class.forName(ctx.getInitParameter("JDBCDriver"));
			String url = ctx.getInitParameter("ConnectionURL");
			String id = "kang";
			String pw = "1234";

			con = DriverManager.getConnection(url, id, pw);
			
		} catch (Exception e) {
			System.out.println("DB연결실패");
			e.printStackTrace();
		}
	}
	
	// 자원반납하기
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
			e.printStackTrace();
		}
	}

	/*
	  // 게시판 리스트 가져오기(간단버전 : 페이지처리없음) public List<BbsDTO> selectList() {
	  
	  // 1.결과 레코드셋을 담기위한 리스트계열 컬렉션생성 List<BbsDTO> bbs = new Vector<BbsDTO>();
	  
	  // 2.게시물 전체를 가져오기 위한 쿼리작성 String query = "SELECT "" FROM bbs " + " WHERE 1=1 "
	  + " ORDER BY num DESC";
	  
	  try { // 3.prepare객체생성 및 실행 psmt = con.prepareStatement(query);
	  
	  // 4.쿼리실행후 결과셋 돌려받음 rs = psmt.executeQuery();
	  
	  // 5.결과셋의 갯수만큼 반복 while (rs.next()) {
	  
	  // 6.결과셋을 하나씩 DTO객체에 저장 BbsDTO dto = new BbsDTO();
	  
	  dto.setNum(rs.getString(1)); dto.setTitle(rs.getString("title"));
	  dto.setContent(rs.getString(3)); dto.setPostDate(rs.getDate(4));
	  dto.setId(rs.getString("id")); dto.setVisitcount(rs.getString(6));
	  
	  // 7.DTO객체를 컬렉션에 추가 bbs.add(dto); } } catch (Exception e) {
	  System.out.println("Select시 예외발생"); e.printStackTrace(); }
	  
	  return bbs; }

	  //게시판 리스트 가져오기(검색처리o, 페이지처리x) public List<BbsDTO>
	  selectList(Map<String,Object> map){
	  
	  //1.결과 레코드셋을 담기위한 리스트계열 컬렉션생성 List<BbsDTO> bbs = new Vector<BbsDTO>();
	  
	  //2.게시물 전체를 가져오기 위한 쿼리작성 String query = " " +" SELECT * FROM bbs ";
	  
	  if(map.get("Word")!=null) { if(map.get("Column").equals("both")) { query
	  +=" WHERE " + "title LIKE '%"+ map.get("Word") +"%' " +" OR "
	  +" content LIKE '%"+ map.get("Word") +"%' "; } else { query +=" WHERE "+
	  map.get("Column") +" " +" LIKE '%"+ map.get("Word") +"%' "; } }
	  
	  query += " " +"        ORDER BY num DESC ";
	  
	  System.out.println("쿼리문:"+ query);
	  
	  try { //3.prepare객체생성 및 실행 psmt = con.prepareStatement(query);
	  
	  
	  //4.쿼리실행후 결과셋 돌려받음 rs = psmt.executeQuery();
	  
	  //5.결과셋의 갯수만큼 반복 while(rs.next()) {
	  
	  //6.결과셋을 하나씩 DTO객체에 저장 BbsDTO dto = new BbsDTO();
	  
	  dto.setNum(rs.getString(1)); dto.setTitle(rs.getString("title"));
	  dto.setContent(rs.getString(3)); dto.setPostDate(rs.getDate(4));
	  dto.setId(rs.getString("id")); dto.setVisitcount(rs.getString(6)); //join에 의한
	  필드추가 dto.setName(rs.getString(7));
	  
	  //7.DTO객체를 컬렉션에 추가 bbs.add(dto); } } catch(Exception e) {
	  System.out.println("Select시 예외발생"); e.printStackTrace(); }
	  
	  return bbs; }
	 */
	
	// 게시판 상세보기
	public BbsDTO selectView(String num) {

		BbsDTO dto = new BbsDTO();

		String query = " " + "SELECT bbs.*, memberShip.name FROM " + " bbs INNER JOIN memberShip "
				+ " ON bbs.id=memberShip.id " + " WHERE num=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString("content"));
				dto.setPostDate(rs.getDate(4));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));

				// member테이블과 join된 결과추가
				dto.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			System.out.println("상세보기시 예외발생");
			e.printStackTrace();
		}
	

		return dto;
	}

	// 조회수 증가 처리
	public void updateVisitCount(String num) {
		String query = " UPDATE bbs SET visitcount=visitcount+1 WHERE num=? ";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeQuery();
		} catch (Exception e) {
			System.out.println("조회수 증가시 예외발생");
			e.printStackTrace();
		}
		
	}

	// 게시판 글쓰기 처리
	public int insertWrite(BbsDTO dto) {
		// 적용된 행의 갯수확인을 위한 변수
		int affected = 0;
		try {
			String query = "INSERT INTO bbs ( " + " num,title,content,id,visitcount) " + " VALUES ( "
					+ " seq_bbs.NEXTVAL, ?, ?, ?, 0)";

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

	// 게시물 수정하기
	public int updateEdit(BbsDTO dto) {

		int affected = 0;
		try {
			String query = "UPDATE bbs SET" + " title=?, content=? " + " WHERE num=?";

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

	// 게시물 삭제하기
	public int delete(BbsDTO dto) {
		int affected = 0;
		try {
			String query = "DELETE FROM bbs " + " WHERE num=?";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getNum());

			affected = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete중 예외발생");
			e.printStackTrace();
		}
		

		return affected;
	}

	// 게시물 갯수를 카운트하기 위한 메소드
	public int getTotalRecordCount(Map<String, Object> map) {
		int totalCount = 0;

		String query = "select count(*) from bbs ";
		if (map.get("Word") != null) {
			if (map.get("Column").equals("both")) {
				query += " WHERE " + "title LIKE '%" + map.get("Word") + "%' " + " OR " + " content LIKE '%"
						+ map.get("Word") + "%' ";
			} else {
				query += " WHERE " + map.get("Column") + " " + " LIKE '%" + map.get("Word") + "%' ";
			}
		}

		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {}
		

		return totalCount;
	}

	// 게시판 리스트 가져오기(검색처리, 페이지처리)
	public List<BbsDTO> selectList(Map<String, Object> map) {

		// 1.결과 레코드셋을 담기위한 리스트계열 컬렉션생성
		List<BbsDTO> bbs = new Vector<BbsDTO>();

		// 2.게시물 전체를 가져오기 위한 쿼리작성
		String query = " " + " SELECT * FROM ( " + "     SELECT Tb.*, ROWNUM rNum FROM ( "
				+ "        SELECT B.*, M.name FROM bbs B " + "          INNER JOIN memberShip M"
				+ "            ON M.id=B.id ";

		if (map.get("Word") != null) {
			if (map.get("Column").equals("both")) {
				query += " WHERE " + "title LIKE '%" + map.get("Word") + "%' " + " OR " + " content LIKE '%"
						+ map.get("Word") + "%' ";
			} else {
				query += " WHERE " + map.get("Column") + " " + " LIKE '%" + map.get("Word") + "%' ";
			}
		}
		query += " " + "        ORDER BY num DESC " + "    ) Tb " + " ) " + " WHERE rNum BETWEEN ? AND ?";

		System.out.println("쿼리문:" + query);

		try {
			// 3.prepare객체생성 및 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());

			// 4.쿼리실행후 결과셋 돌려받음
			rs = psmt.executeQuery();

			// 5.결과셋의 갯수만큼 반복
			while (rs.next()) {

				// 6.결과셋을 하나씩 DTO객체에 저장
				BbsDTO dto = new BbsDTO();

				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString(3));
				dto.setPostDate(rs.getDate(4));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));
				// join에 의한 필드추가
				dto.setName(rs.getString(7));

				// 7.DTO객체를 컬렉션에 추가
				bbs.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Select시 예외발생");
			e.printStackTrace();
		}
		return bbs;
	}

}
