package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/10Servlet/AnnoWebServlet.do")
public class AnnoWebServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", "어노테이션을 이용한 서블릿" + " 작성완료");
		req.setAttribute("HELLO", "Hi 어노테이션 완전편해~");
		req.getRequestDispatcher("/10Servlet/HelloServlet.jsp").forward(req, resp);
	}	
}
