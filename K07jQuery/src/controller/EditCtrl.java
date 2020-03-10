package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import util.FileUtil;

public class EditCtrl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idx = req.getParameter("idx");
		
		ServletContext application = this.getServletContext();
		DataRoomDAO dao = new DataRoomDAO(application);
		
		DataRoomDTO dto = dao.selectView(idx);
		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("/11ServletBoard/DataEdit.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String saveDirectory = req.getServletContext().getRealPath("/Upload");
		MultipartRequest mr = FileUtil.upload(req, saveDirectory);
		
		int sucOrFail;
		
		if(mr != null) {
		String idx = mr.getParameter("idx");
		String nowPage = mr.getParameter("nowPage");
		//수정처리후 상세보기로 이동하므로 영역에 속성을 저장한다.
		req.setAttribute("idx", idx);
		req.setAttribute("nowPage", nowPage);
		String name = mr.getParameter("name");
		String title =mr.getParameter("title");
		String content = mr.getParameter("content");
		String pass = mr.getParameter("pass");
		
		//dto객체에 수정할 내용 세팅
		DataRoomDTO dto = new DataRoomDTO();
		dto.setContent(content);
		dto.setTitle(title);
		dto.setName(name);
		dto.setPass(pass);
		//게시물 수정을 위한 idx세팅
		dto.setIdx(idx);
		
		ServletContext app = this.getServletContext();
		DataRoomDAO dao = new DataRoomDAO(app);
		sucOrFail = dao.update(dto);
		
		dao.close();
		}
		else {
			sucOrFail = -1;
		}
		
		//리퀘스트영역에 메세지 출력을 위한 저장
		req.setAttribute("SUC_FAIL", sucOrFail);
		req.setAttribute("WHEREIS", "UPDATE");
		
		req.getRequestDispatcher("/11ServletBoard/Message.jsp").forward(req, resp);
		
	}
	
}
