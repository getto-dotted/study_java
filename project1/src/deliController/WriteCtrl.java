package deliController;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dataObject.MemberDAO;


/*
글쓰기 페이지의 경우 
	doGet() : 글쓰기 페이지로 진입할때의 요청을 처리
	doPost() : 글작성후 submit()했을때의 요청을 처리
 */
@WebServlet("/deli/Write")
public class WriteCtrl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");	
		
		String [] idx = req.getParameterValues("choice");		
		String [] price = req.getParameterValues("price");
		String [] cstock = req.getParameterValues("stock");
		
		
		ServletContext application = this.getServletContext();		
		HttpSession ses = req.getSession();
		
		String id = "";
		
		try {
			id = ses.getAttribute("USER_ID").toString();				
		} catch (Exception e) {
		}
		if(id==null) {		
		//로그인 하지 않았을경우 로그인 페이지로 보냄 jsp로 포워드만 처리
		req.getRequestDispatcher("../member/login.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String [] idx = req.getParameterValues("choice");
		
		int sucOrFail=0;
		
		String [] price = req.getParameterValues("price");
		
		String [] cstock = req.getParameterValues("stock");
		
		ServletContext app = this.getServletContext();		
		HttpSession ses = req.getSession();
		
		String id = "";
		
		int rs=1;
		
		try {
			id = ses.getAttribute("USER_ID").toString();				
		} 
		catch (Exception e) {}
		if(id==null) {			
			rs=0;
		}				
		if (rs == 0) {
			PrintWriter out=resp.getWriter();			
			out.println("<script>alert('로그인을 해주세요');</script>");	
			out.println("<script>location.href='../member/login.jsp';</script>");	
			out.close();			
		}
		else {					
			
			for(int i =0; i<idx.length; i++) {
			
			DeliDTO dto = new DeliDTO();
			
			dto.setId(id);
			dto.setIdx(idx[i]);
			dto.setCstock(cstock[i]);
			dto.setPrice(price[i]);
			
			DeliDAO dao = new DeliDAO(app);
			
			sucOrFail = dao.insertReply(dto);
			
			System.out.println(id);
			System.out.println(idx[i]);
			System.out.println(cstock[i]);
			System.out.println(price[i]);
			}
		}		
		if(sucOrFail==1) {
			/*
			글쓰기와 파일업로드를 성공했을때는 게시판 리스트로 이동 
			req.getRequestDispatcher("/DataRoom/DataList").forward(req,resp);
			 */
			
			/*
			post로 요청된 상태에서 forward를 걸게되면 해당페이지에서 
			새로고침 하는경우 폼값을 다시 전송할지 물어보게 되므로
			여러번 전송되는 문제가 발생할수 있다. 이런 경우에는 
			새로운 페이지에 요청을 위해 redirect하는것이 좋다.  
			 */
			/*
			req.getRequestDispatcher("/deli/List").forward(req,resp);*/
			resp.sendRedirect("../deli/List");		
		}
		else {
			//글쓰기 실패시 쓰기페이지로 포워드 한다.
			resp.sendRedirect("../deli/Write");	
		}
	}
}
