package famController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fam/List")
public class ListCtrl extends HttpServlet{
	
	Connection con;// DB연결
	PreparedStatement psmt;// 쿼리문 전송 및 결과반환
	ResultSet rs;// select의 결과를 반환받을때 사용
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//application객체를 서블릿으로 가져옴
		ServletContext application = this.getServletContext();
		FamDAO dao = new FamDAO(application);
		//DAO와 JSP로 전달할 파라미터를 저장하기 위한 컬렉션 객체 선언
		Map param = new HashMap();
		//파라미터를 쿼리스트링으로 만들어 PagingUtil로 전달
		String addQueryString = "";
		
		//request 객체를 통해 파라미터 받아오기
		String searchColumn = req.getParameter("searchColumn");
		String searchWord = req.getParameter("searchWord");		
		
		if(searchColumn!=null) {
			//전달된 파라미터가 있을때만 아래 문장 수행
			addQueryString = String.format("searchColumn=%s&searchWord=%s&", searchColumn, searchWord);
			param.put("Column", searchColumn);
			param.put("Word", searchWord);
		}
		
		//페이지 처리를 위해 전체 레코드수를 카운트한다.
		int totalRecordCount = dao.getTotalRecordCount(param);
		param.put("totalCount", totalRecordCount);
		
		//초기화 파라미터를 가지고 와서 숫자로 변환
		int pageSize = 6;
		int blockPage = 5;
		
		int totalPage=(int)Math.ceil((double)totalRecordCount/pageSize);
		
		//현재 페이지 번호 설정
		int nowPage = (req.getParameter("nowPage")==null || req.getParameter("nowPage").equals(""))?
				1:Integer.parseInt(req.getParameter("nowPage"));
		//리스트에 출력할 레코드의 구간을 결정하기 위한 연산
		int start = (nowPage-1)*pageSize + 1;
		int end = nowPage * pageSize;
		param.put("start", start);
		param.put("end", end);
		
		param.put("totalPage", totalPage);//전체페이지수
		param.put("nowPage", nowPage);//현재 페이지
		param.put("totalCount", totalRecordCount);//전체 레코드 갯수
		param.put("pageSize", pageSize);//페이지크기
		//페이지번호를 생성하기 위한 메소드 호출
		String pagingImg = PagingUtil.pagingImg(totalRecordCount, pageSize, blockPage, nowPage, "../fam/List?"+addQueryString);
		
		param.put("pagingImg", pagingImg);
		//게시판 리스트 출력을 위한 메소드 호출
		List<FamDTO> lists = dao.selectListPage(param);
		dao.close();
		
		//JSP페이지로 전달하기 위한 데이터를 리퀘스트 영역에 저장
		req.setAttribute("lists", lists);
		req.setAttribute("map", param);
		//뷰로 포워드
		req.getRequestDispatcher("/fam/List.jsp").forward(req, resp);
		
	}
	
}
