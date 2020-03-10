package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.MemberDAO;
//web.xml 대신 어노테이션을 통한 매핑 처리
@WebServlet("/10Servlet/SimpleMVC")
public class SimpleMVC extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);		
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);		
	}
	//protected?
	/*	해당 서블릿으로 get방식이든 post방식이든 요청이 들어왔을때
		아래 메소드에서 요청을 한꺼번에 처리하기 위한 방법 */
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		Object resultObj = null;
		/*
		Model(모델)을 사용하여 요청한 기능을 수행하는 비즈니스 로직을 구성한다	*/
		if(type==null) {
			resultObj = "파라미터를 입력해주세요";
		}
		else if(type.equals("greeting")) {
			
			/*
			서블릿에서 application 내장객체를 사용하기 위해 가져온다. */
			ServletContext application = this.getServletContext();
			//컨텍스트 초기화 파라미터를 가져온다.
			String drv = application.getInitParameter("JDBCDriver");
			String url = application.getInitParameter("ConnectionURL");
			
			MemberDAO dao = new MemberDAO(drv, url);
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			//파라미터를 통해 isMember() 메소드를 호출한다.
			boolean isMember = dao.isMember(id, pw);
			
			if(isMember==true) {
				resultObj = "어서오세요 회원님";
			}
			else {
				resultObj = "회원가입 후 이용가능합니다.";
			}
			
		}
		
		else if(type.equals("date")) {
			resultObj = new java.util.Date();
		}
		else {
			resultObj = "파라미터를 제대로 입력하세요";
		}
		/*  결과를 리퀘스트 영역에 저장한다. 회원인증의 경우에는
			세션영역을 사용하기도 한다. */
		req.setAttribute("result", resultObj);
		/*처리결과를 전달할 JSP페이지를 포워딩한다. 
		  업무에 따라 JSP로 전달하지 않고 서블릿에서 바로 출력하는 경우도 있다*/
		RequestDispatcher dis = req.getRequestDispatcher("/10Servlet/SimpleMVC.jsp");
		dis.forward(req, resp);	
		
	}
	
}
