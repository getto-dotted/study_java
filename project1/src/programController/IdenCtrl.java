package programController;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/program/sub01_Iden")
public class IdenCtrl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mode = req.getParameter("mode");
		String idx = req.getParameter("idx");
		String nowPage = req.getParameter("nowPage");
		
		req.setAttribute("mode", mode);
		req.getRequestDispatcher("/program/DataPassword.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idx = req.getParameter("idx");
		String mode = req.getParameter("mode");
		String pass = req.getParameter("pass");
		String id = req.getParameter("id");

		ServletContext app = this.getServletContext();
		ProgramDAO dao = new ProgramDAO(app);
		boolean isCorrect = dao.isCorrectPassword(id, pass, idx);
		dao.close();
		
		//결과값을 리퀘스트 영역에 저장
		req.setAttribute("PASS_CORRECT", isCorrect);
		req.getRequestDispatcher("/program/passMessage.jsp").forward(req, resp);
	}
}
