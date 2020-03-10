package basketController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataObject.MemberDAO;
import noticeController.NoticeDAO;

@WebServlet("/basket/Identify")
public class IdenCtrl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");	
		//--------------------------------------------------
		ServletContext application = this.getServletContext();		
		HttpSession ses = req.getSession();
		
		String id1 = "";
		try {
			id1 = ses.getAttribute("USER_ID").toString();				
		} catch (Exception e) {
		}
		if(id1==null) {
			System.out.println("로그인필요");			
		}
		
		int rs=0;
		
		MemberDAO daoG = new MemberDAO(application);
		rs = daoG.gradeCheck(id1);
		
		
		if (rs == 0) {
			PrintWriter out=resp.getWriter();
			
			System.out.println(rs);			
			out.println("<script>location.href='../main/main';</script>");	
			out.close();
			
		}
		//----------------------------------------------------
		String mode = req.getParameter("mode");
		String idx = req.getParameter("idx");
		String nowPage = req.getParameter("nowPage");
		
		req.setAttribute("mode", mode);
		req.getRequestDispatcher("/basket/Identify.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");	
		//--------------------------------------------------
		ServletContext application = this.getServletContext();				
		String id1 = req.getParameter("id");	
				
		ServletContext app = this.getServletContext();
		MemberDAO dao = new MemberDAO(application);
		int isCorrect = dao.gradeCheck(id1);
		dao.close();		
		
		boolean isCorr;
		
		if(isCorrect==0) {
			isCorr = false;
		}
		else {
			isCorr = true;
		}
		
		//결과값을 리퀘스트 영역에 저장
		req.setAttribute("PASS_CORRECT", isCorr);
		req.getRequestDispatcher("/basket/passMessage.jsp").forward(req, resp);
	}
}
