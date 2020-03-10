package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoJSPServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8;");
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html>");
			writer.print("<head><title>안뇽</title></head>");
			writer.print("<body>");
			writer.print("<h2>jsp파일없이 화면에 출력하기~~</h2>");
			writer.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
