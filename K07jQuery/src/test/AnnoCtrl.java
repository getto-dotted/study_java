package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/anno.do")
public class AnnoCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("m1", "서블릿으로 웹 어플리케이션을 구현합니다.");
		req.setAttribute("m2", "어노테이션을 통해 매핑을 처리합니다.");
		req.setAttribute("a", req.getParameter("param1"));
		req.setAttribute("b", req.getParameter("param2"));
		req.getRequestDispatcher("ex3AnnoView.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("m1", "서블릿으로 웹 어플리케이션을 구현합니다.");
		req.setAttribute("m2", "어노테이션을 통해 매핑을 처리합니다.");
		req.setAttribute("a", req.getParameter("param1"));
		req.setAttribute("b", req.getParameter("param2"));
		req.getRequestDispatcher("ex3AnnoView.jsp").forward(req, resp);
	}
}
