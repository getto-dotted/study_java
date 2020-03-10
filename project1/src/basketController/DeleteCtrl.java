package basketController;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basket/Delete")
public class DeleteCtrl extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nowPage = req.getParameter("nowPage");
		String pid = req.getParameter("pid");
		System.out.println(pid);
		req.setAttribute("nowPage", nowPage);
		
		ServletContext application = this.getServletContext();
		BasketDAO dao = new BasketDAO(application);
		int sucOrFail = dao.delete(pid);
		
		req.setAttribute("WHEREIS", "DELETE");
		req.setAttribute("SUC_FAIL", sucOrFail);
		req.getRequestDispatcher("/basket/Message.jsp").forward(req, resp);
			
	}
}
