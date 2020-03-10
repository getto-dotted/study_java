package prodController;

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

@WebServlet("/prod/Edit")
public class EditCtrl extends HttpServlet{
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
		else {
				
		
		String idx = req.getParameter("idx");
		String nowPage = req.getParameter("nowPage");
		String ofilename = "";
		String sfilename = "";
		
	
					
		try {
			String saveDirectory = req.getServletContext().getRealPath("/Upload");
			MultipartRequest mr = FileUtil.upload(req, saveDirectory);				
			sfilename = mr.getParameter("sfilename");	
			ofilename = mr.getParameter("ofilename");	 
		} catch (Exception e) {
			System.out.println("this is not a multipart/form data");
			sfilename = req.getParameter("sfilename");	
			ofilename = req.getParameter("ofilename");
		}
		
		System.out.println(ofilename);
		System.out.println(sfilename);
		System.out.println(nowPage);
		System.out.println(idx);
		
		ProdDAO dao = new ProdDAO(application);
		
		ProdDTO dto = dao.selectView(idx);
		
		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("/prod/Edit.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String saveDirectory = req.getServletContext().getRealPath("/Upload");
		MultipartRequest mr = FileUtil.upload(req, saveDirectory);
		
		
		int sucOrFail;
		
		if(mr != null) {
			//파일업로드가 정상처리되었다면 파일 외 나머지 폼값을 받아서 처리한다.
			String name = mr.getParameter("name");
			String info = mr.getParameter("info");
			String price = mr.getParameter("price");
			String dispoint = mr.getParameter("dispoint");	
			String stock = mr.getParameter("stock");
			String deliv = mr.getParameter("deliv");
			String dprice = mr.getParameter("dprice");
			String etc = mr.getParameter("etc");	
			String idx = mr.getParameter("idx");
			
			String ofilename = "";
			String sfilename = "";
			
			try {
				//서버에 저장된 실제파일명을 가져온다.
				ofilename = mr.getFilesystemName("attachedfile");		 
				String nowTime = new SimpleDateFormat("yyyy_MM_dd_H_m_s_S").format(new Date());
				int idx1 = -1;
				idx1 = ofilename.lastIndexOf(".");//확장자따내기
				sfilename = nowTime + ofilename.substring(idx1, ofilename.length());
				//파일객체 만들기
				File oldFile = new File(saveDirectory+"/"+ofilename);//원본파일명
				File newFile = new File(saveDirectory+"/"+sfilename);//변경될파일명
				//저장된 파일명을 변경한다. 
				oldFile.renameTo(newFile);
				//파일명 변경로직 end
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			ProdDTO dto = new ProdDTO();
			dto.setName(name);
			dto.setInfo(info);
			dto.setPrice(price);
			dto.setDispoint(dispoint);
			dto.setDeliv(deliv);
			dto.setDprice(dprice);
			dto.setStock(stock);
			dto.setOfile(ofilename);
			dto.setSfile(sfilename);			
			dto.setEtc(etc);
			dto.setIdx(idx);
			
			//application내장객체를 서블릿으로 가져온 후 DB에 연결해서 insert처리한다.
			ServletContext app = this.getServletContext();
			ProdDAO dao = new ProdDAO(app);
			//입력성공이면 1이 반환된다.

			//파일첨부형 게시판 구현시 사용(답변글X)
			//sucOrFail = dao.insert(dto);
			//파일첨부형 + 답변형 게시판 구현시 사용
			sucOrFail = dao.updateReply(dto);
			dao.close();	
		}
		else {
			//파일업로드를 하지 않은 경우
			String name = req.getParameter("name");
			String info = req.getParameter("info");
			String price = req.getParameter("price");
			String dispoint = req.getParameter("dispoint");	
			String stock = req.getParameter("stock");
			String deliv = req.getParameter("deliv");
			String dprice = req.getParameter("dprice");
			String etc = req.getParameter("etc");	
			
			String idx = req.getParameter("idx");
			
			String ofilename = "";
			String sfilename = "";
			
			try {
				//서버에 저장된 실제파일명을 가져온다.
				ofilename = req.getParameter("ofilename");	 
				sfilename = req.getParameter("sfilename");	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
						
			
			System.out.println(ofilename);
			System.out.println(sfilename);
			
			ProdDTO dto = new ProdDTO();
			dto.setName(name);
			dto.setInfo(info);
			dto.setPrice(price);
			dto.setDispoint(dispoint);
			dto.setDeliv(deliv);
			dto.setDprice(dprice);
			dto.setStock(stock);
			dto.setOfile(ofilename);
			dto.setSfile(sfilename);			
			dto.setEtc(etc);	
			dto.setIdx(idx);		
			
			ServletContext app = this.getServletContext();
			ProdDAO dao = new ProdDAO(app);
			
			sucOrFail = dao.updateReply(dto);
			dao.close();			
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
			resp.sendRedirect("../prod/List");
		}
		else {			
			resp.sendRedirect("../prod/Write");			
			
		}
		
	}
	
}
