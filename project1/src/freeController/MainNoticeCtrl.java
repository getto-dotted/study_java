package freeController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainNoticeCtrl extends HttpServlet{
	Connection con;// DB연결
	PreparedStatement psmt;// 쿼리문 전송 및 결과반환
	ResultSet rs;// select의 결과를 반환받을때 사용
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//application객체를 서블릿으로 가져옴
		ServletContext application = this.getServletContext();
		NoticeDAO dao = new NoticeDAO(application);
		//DAO와 JSP로 전달할 파라미터를 저장하기 위한 컬렉션 객체 선언
		Map param = new HashMap();		
		
		int start = 1;
		int end = 4;
		param.put("start", start);
		param.put("end", end);		
		
		//게시판 리스트 출력을 위한 메소드 호출
		List<NoticeDTO> lists = dao.selectListPage(param);
		dao.close();
		
		//JSP페이지로 전달하기 위한 데이터를 리퀘스트 영역에 저장
		req.setAttribute("lists", lists);
		req.setAttribute("map", param);
		//뷰로 포워드
		req.getRequestDispatcher("/main/main.jsp").forward(req, resp);
		
	}	
	
	
}
