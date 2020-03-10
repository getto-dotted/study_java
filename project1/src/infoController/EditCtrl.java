package infoController;

import java.io.File;
import java.io.IOException;
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


@WebServlet("/info/Edit")
public class EditCtrl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idx = req.getParameter("idx");
		
		ServletContext application = this.getServletContext();
		InfoDAO dao = new InfoDAO(application);
		
		InfoDTO dto = dao.selectView(idx);
		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("/info/Edit.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String saveDirectory = req.getServletContext().getRealPath("/Upload");
		MultipartRequest mr = FileUtil.upload(req, saveDirectory);
		
		int sucOrFail;
		if(mr != null) {
			String idx = mr.getParameter("idx");
			String nowPage = mr.getParameter("nowPage");
			//수정처리후 상세보기로 이동하므로 영역에 속성을 저장한다.
			req.setAttribute("idx", idx);
			req.setAttribute("nowPage", nowPage);
			String name = mr.getParameter("name");
			String title =mr.getParameter("title");
			String content = mr.getParameter("content");
			String pass = mr.getParameter("pass");
			String email = mr.getParameter("email");
			HttpSession session = req.getSession();
			String id = "";
			try {
				id = session.getAttribute("USER_ID").toString();				
			} 
			catch (Exception e) {
			}
			if(id==null) {
				System.out.println("로그인필요");
				
			}
			
			
			String ofileName = "";
			String sFileName = "";
			
			try {
				//서버에 저장된 실제파일명을 가져온다.
				ofileName = mr.getFilesystemName("attachedfile");		 
				String nowTime = new SimpleDateFormat("yyyy_MM_dd_H_m_s_S").format(new Date());
				int idx2 = -1;
				idx2 = ofileName.lastIndexOf(".");//확장자따내기
				sFileName = nowTime + ofileName.substring(idx2, ofileName.length());
				//파일객체 만들기
				File oldFile = new File(saveDirectory+"/"+ofileName);//원본파일명
				File newFile = new File(saveDirectory+"/"+sFileName);//변경될파일명
				//저장된 파일명을 변경한다. 
				oldFile.renameTo(newFile);
				//파일명 변경로직 end
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//dto객체에 수정할 내용 세팅
			InfoDTO dto = new InfoDTO();
			dto.setContent(content);
			dto.setTitle(title);
			dto.setName(name);
			dto.setPass(pass);
			dto.setEmail(email);		
			dto.setOfile(ofileName);
			dto.setSfile(sFileName);
			dto.setId(id);
			//게시물 수정을 위한 idx세팅
			dto.setIdx(idx);
			
			ServletContext app = this.getServletContext();
			InfoDAO dao = new InfoDAO(app);
			sucOrFail = dao.updateReply(dto);
			
			dao.close();
			}
		else {
				sucOrFail = -1;
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
			resp.sendRedirect("../info/List");
			FileUtil.deleteFile(req, req.getServletContext().getRealPath("/Upload"),mr.getFilesystemName("sfile") );
		}
		else {
			//글쓰기 실패시 쓰기페이지로 포워드 한다.
			req.getRequestDispatcher("/info/Write.jsp").forward(req, resp);
			
		}
		
	}
	
}
