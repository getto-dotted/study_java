package infoController;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info/Delete")
public class DeleteCtrl extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idx = req.getParameter("idx");
		String nowPage = req.getParameter("nowPage");
		
		req.setAttribute("nowPage", nowPage);
		
		ServletContext application = this.getServletContext();
		InfoDAO dao = new InfoDAO(application);
		int sucOrFail = dao.delete(idx);
		
		req.setAttribute("WHEREIS", "DELETE");
		req.setAttribute("SUC_FAIL", sucOrFail);
		req.getRequestDispatcher("/info/Message.jsp").forward(req, resp);
			
	}
}
