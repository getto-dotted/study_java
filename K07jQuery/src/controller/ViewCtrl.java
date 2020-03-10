package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCtrl extends HttpServlet{

	/*	서블릿이 요청을 받을때 doGet() 혹은 doPost()로 받아서 처리하는데,
		이 두가지 방식 모두를 처리할 수 있는 메소드가 service()이다. */
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idx = req.getParameter("idx");
		
		ServletContext application = this.getServletContext();
		DataRoomDAO dao = new DataRoomDAO(application);
		DataRoomDTO dto = dao.selectView(idx);
		//조회수 증가
		dao.updateVisitCount(idx);
		//내용 부분을 줄바꿈 처리를 하기 위해 <br/>태그로 변경
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		dao.close();
		
		//리퀘스트영역에 dto객체 저장 및 포워드
		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("/11ServletBoard/DataView.jsp").forward(req, resp);
		
	}
}
