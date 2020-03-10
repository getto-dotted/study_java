package crewController;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/crew/Download")
public class DownloadCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idx = req.getParameter("idx");

		FileUtil.download(req, resp, "/Upload");

		ServletContext app = this.getServletContext();				
		CrewDAO dao = new CrewDAO(app);
		dao.downCountPlus(idx);
		dao.close();
		
	}
	
}
