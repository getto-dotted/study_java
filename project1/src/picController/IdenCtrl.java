package picController;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pic/Identify")
public class IdenCtrl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mode = req.getParameter("mode");
		String idx = req.getParameter("idx");
		String nowPage = req.getParameter("nowPage");
		
		req.setAttribute("mode", mode);
		req.getRequestDispatcher("/pic/Identify.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idx = req.getParameter("idx");
		String mode = req.getParameter("mode");
		String pass = req.getParameter("pass");
		String id = req.getParameter("id");

		ServletContext app = this.getServletContext();
		PicDAO dao = new PicDAO(app);
		boolean isCorrect = dao.isCorrectPassword(id, pass, idx);
		dao.close();
		
		//결과값을 리퀘스트 영역에 저장
		req.setAttribute("PASS_CORRECT", isCorrect);
		req.getRequestDispatcher("/pic/passMessage.jsp").forward(req, resp);
	}
}
