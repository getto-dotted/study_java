package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import model.BbsDTO;

public class DataRoomDAO {

	Connection con;// DB연결
	PreparedStatement psmt;// 쿼리문 전송 및 결과반환
	ResultSet rs;// select의 결과를 반환받을때 사용
	
	public DataRoomDAO(ServletContext application) {
		try {
			Class.forName(application.getInitParameter("JDBCDriver"));
			String id = "korea";
			String pw = "1234";
			con = DriverManager.getConnection(application.getInitParameter("ConnectionURL"), id, pw);
			System.out.println("DB 연결성공");
		} 
		catch (Exception e) {
			System.out.println("DB 연결실패;");
		}
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
	public List<DataRoomDTO> selectListPage(Map map){
		List<DataRoomDTO> bbs = new Vector<DataRoomDTO>();
		
		String sql = "" + "SELECT * FROM ( SELECT Tb. *, rownum rNum FROM (SELECT*FROM dataroom ";

		if (map.get("Word") != null) {
			sql += " WHERE " + map.get("Column")+ " LIKE '%" + map.get("Word") + "%'";
		}

		sql += "  ORDER BY idx DESC ) Tb )  WHERE rNum BETWEEN ? AND ?  ";
		
		try {
			// 쿼리실행을 위한 prepare객체 생성 및 쿼리전송
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, Integer.parseInt(map.get("start").toString()));
			psmt.setInt(2, Integer.parseInt(map.get("end").toString()));

			rs = psmt.executeQuery();
			while (rs.next()) {
			
				//반환된 결과셋의 갯수만큼 반복하면서 DTO객체에 레코드 저장후 컬렉션에 누적 저장
				DataRoomDTO dto = new DataRoomDTO();

				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setpostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));
				
				bbs.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Select시 예외발생");
			e.printStackTrace();
		}
		// 누적 저장된 컬렉션 반환
		return bbs;
	}
	//조회수 증가 메소드
	public void updateVisitCount(String idx) {
		String query = " UPDATE dataroom SET visitcount=visitcount+1 WHERE idx=? ";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeQuery();
		} catch (Exception e) {
			System.out.println("조회수 증가시 예외발생");
			e.printStackTrace();
		}
	}
	//게시판 상세보기 메소드
	public DataRoomDTO selectView(String idx) {
		DataRoomDTO dto = null;
		String query = "SELECT*FROM dataroom WHERE idx=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new DataRoomDTO();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setpostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));//조회수추가
				
			}

		} catch (Exception e) {
			System.out.println("상세보기시 예외발생");
			e.printStackTrace();
		}
		return dto;
		
	}
	// 전체 레코드수를 카운트해서 반환하는 메소드
	public int getTotalRecordCount(Map map) {
		int totalCount = 0;
		try {
			String query = " SELECT COUNT(*) FROM dataroom ";
			// 검색이 있는경우 where절을 추가한다.
			if (map.get("Word") != null) {
				query += " WHERE " + map.get("Column") + " " + " LIKE '%" + map.get("Word") + "%'";
			}
		

			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			rs.next();
			totalCount = rs.getInt(1);

		} catch (Exception e) {}
		return totalCount;
	}
	//글쓰기 처리
	public int insert(DataRoomDTO dto) {
		int affected = 0;
		try {
			String sql = "INSERT INTO dataroom (idx, title, name, content, pass) "
					+ " VALUES ( dataroom_seq.NEXTVAL, ?, ?, ?, ?) ";

			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getPass());

			affected = psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insert중 예외발생");
			e.printStackTrace();
		}
		return affected;
	}
	//패스워드 검증
	public boolean isCorrectPassword(String pass, String idx) {
		boolean isCorr= true;
		try {
			String sql = "select count(*) from dataroom where pass=? and idx=?";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, pass);
			psmt.setString(2, idx);
			rs = psmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==0) {
				//만약 만족하는 레코드가 없다면 false반환
				isCorr = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			isCorr = false;			
		}		
		return isCorr;
	}
	//삭제처리
	public int delete(String idx) {
		DataRoomDTO dto = new DataRoomDTO();
		int affected = 0;
		try {
			String query = " DELETE FROM dataroom WHERE idx=? ";

			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);

			affected = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("delete중 예외발생");
			e.printStackTrace();
		}
		return affected;
	}
	
	//글 수정하기
	public int update(DataRoomDTO dto) {
		int affected = 0;
		try {
			String query = "UPDATE dataroom SET title=?, name=?, content=? WHERE idx=? and pass=? ";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getContent());

			//게시물수정을 위한 추가부분
			psmt.setString(4, dto.getIdx());
			psmt.setString(5, dto.getPass());
			
			affected = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("update중 예외발생");
			e.printStackTrace();
		}
		return affected;
	}
	//답변형게시판 글쓰기 처리(컬럼3개 추가됨)
	public int insertReply(DataRoomDTO dto)	{
		
		int affected = 0;//적용된 행의갯수
		try{
			/*
			답변글 처리를 위한 컬럼 추가
			:  답변형 게시판에서 원글의 경우에는 일련번호와 동일한 
				그룹번호를 부여하게 된다. 즉 idx에 입력될 값과 동일한
				값을 bgroup에 입력한다. bstep, bindent는 0을 입력한다. 
				
			※NextVal의 경우 현재 시퀀스에 +1 처리한 값을 반환하지만, 
			하나의 문장내에서 실행하게되면 동일한 값을 반환한다. 
			 */
			String sql = "INSERT INTO dataroom ("
				+ " idx,title,name,content,ofile,sfile,pass,downcount) "
				+ " VALUES ("
				+ " dataroom_seq.NEXTVAL,?,?,?,?,?,?,0)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			psmt.setString(6, dto.getPass());

			affected = psmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return affected;
	}		
	//파일 다운로드 수 증가
	public void downCountPlus(String idx){
		String sql = "UPDATE dataroom SET "
			+ " downcount=downcount+1 "
			+ " WHERE idx=? ";
		try{
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			psmt.executeUpdate();
		}
		catch(Exception e){}
	}	
	
}
