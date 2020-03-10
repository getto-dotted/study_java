package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeCtrl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("m1", "서블릿으로 웹어플리케이션을 구현합니다.");
		req.setAttribute("m2", "web.xml을 통해 매핑을 처리합니다.");
		req.getRequestDispatcher("ex2HomeView.jsp").forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
