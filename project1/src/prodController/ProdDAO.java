package prodController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

public class ProdDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	public ProdDAO(ServletContext application) {
		try {
			Class.forName(application.getInitParameter("JDBCDriver"));
			String id = "project1";
			String pw = "1234";
			con = DriverManager.getConnection(application.getInitParameter("ConnectionURL"), id, pw);
			System.out.println("상품관리 DB 연결성공");
		} 
		catch (Exception e) {
			System.out.println("상품관리 DB 연결실패;");
		}
	}	
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
	public List<ProdDTO> selectListPage(Map map){
		List<ProdDTO> bbs = new Vector<ProdDTO>();
		
		String sql = "" + "SELECT * FROM ( SELECT Tb. *, rownum rNum FROM (SELECT * FROM prod ";

		if (map.get("Word") != null) {
			sql += " WHERE " + map.get("Column")+ " LIKE '%" + map.get("Word") + "%'";
		}

		sql += "  ORDER BY idx DESC ) Tb )  WHERE rNum BETWEEN ? AND ?  ";
		try {
			
			psmt = con.prepareStatement(sql);			
			psmt.setInt(1, Integer.parseInt(map.get("start").toString()));
			psmt.setInt(2, Integer.parseInt(map.get("end").toString()));

			rs = psmt.executeQuery();
			while (rs.next()) {			
				
				ProdDTO dto = new ProdDTO();

				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setInfo(rs.getString(3));
				dto.setOfile(rs.getString(4));
				dto.setSfile(rs.getString(5));
				dto.setPrice(rs.getString(6));
				dto.setDispoint(rs.getString(7));
				dto.setStock(rs.getString(8));
				dto.setCstock(rs.getString(9));
				dto.setDeliv(rs.getString(10));
				dto.setDprice(rs.getString(11));
				dto.setPostdate(rs.getDate(12));
				dto.setSellcnt(rs.getString(13));
				dto.setEtc(rs.getString(14));			
				
				bbs.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("Select시 예외발생");
			e.printStackTrace();
		}
		
		return bbs;
	}
	//판매수 증가 메소드
	public void updateSellCount(String idx) {
		String query = " UPDATE prod SET sellcnt=sellcnt+1 WHERE idx=? ";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeQuery();
		} catch (Exception e) {
			System.out.println("판매수 증가시 예외발생");
			e.printStackTrace();
		}
	}
	//게시판 상세보기 메소드
	public ProdDTO selectView(String idx) {
		ProdDTO dto = null;
		String query = "SELECT*FROM prod WHERE idx=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new ProdDTO();
				
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setInfo(rs.getString(3));
				dto.setOfile(rs.getString(4));
				dto.setSfile(rs.getString(5));
				dto.setPrice(rs.getString(6));
				dto.setDispoint(rs.getString(7));
				dto.setStock(rs.getString(8));
				dto.setCstock(rs.getString(9));
				dto.setDeliv(rs.getString(10));
				dto.setDprice(rs.getString(11));
				dto.setPostdate(rs.getDate(12));
				dto.setSellcnt(rs.getString(13));
				dto.setEtc(rs.getString(14));	
				
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
			String query = " SELECT COUNT(*) FROM prod ";
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
	//삭제처리
	public int delete(String idx) {
		ProdDTO dto = new ProdDTO();
		int affected = 0;
		try {
			String query = " DELETE FROM prod WHERE idx=? ";

			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);

			affected = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("delete중 예외발생");
			e.printStackTrace();
		}
		return affected;
	}
	
	//파일업로드 및 글쓰기
	public int insertReply(ProdDTO dto)	{
		
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
			String sql = "INSERT INTO prod "
					+ "(idx, name, info, ofile, sfile, price, dispoint, stock, deliv, dprice, etc) "
					+ " VALUES (prod_seqn.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getInfo());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
			psmt.setString(5, dto.getPrice());
			psmt.setString(6, dto.getDispoint());
			psmt.setString(7, dto.getStock());	
			psmt.setString(8, dto.getDeliv());			
			psmt.setString(9, dto.getDprice());						
			psmt.setString(10, dto.getEtc());
			
			affected = psmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return affected;
	}		
	//파일 및 게시글 수정
	public int updateReply(ProdDTO dto)	{
		
		int affected = 0;//적용된 행의갯수
		
		try{	
			
			String sql = "UPDATE prod SET "
						+ "name=?, info=?, ofile=?, sfile=?, price=?, dispoint=?, stock=?, deliv=?, dprice=?, etc=? WHERE idx=? ";
			
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getInfo());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
			psmt.setString(5, dto.getPrice());
			psmt.setString(6, dto.getDispoint());
			psmt.setString(7, dto.getStock());		
			psmt.setString(8, dto.getDeliv());
			psmt.setString(9, dto.getDprice());	
			psmt.setString(10, dto.getEtc());
			
			//수정할 게시물을 특정할 Idx
			psmt.setString(11, dto.getIdx());
			
			affected = psmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return affected;
	}			

	public boolean isManager(String id) {
		boolean isCorr= true;
		try {
			String sql = "SELECT COUNT(*) FROM member WHERE id=? ";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);			
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
}
