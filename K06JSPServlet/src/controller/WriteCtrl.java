package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import util.FileUtil;
/*
글쓰기 페이지의 경우 
	doGet() : 글쓰기 페이지로 진입할때의 요청을 처리
	doPost() : 글작성후 submit()했을때의 요청을 처리
 */
public class WriteCtrl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//글쓰기 페이지를 보여주기 위해 jsp로 포워드만 처리
		req.getRequestDispatcher("/11ServletBoard/DataWrite.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		//물리적 경로
		String saveDirectory = req.getServletContext().getRealPath("/Upload");
		//파일업로드를 위해 Multipart객체 생성(FileUtil에서)
		MultipartRequest mr = FileUtil.upload(req, saveDirectory);
		
		int sucOrFail;
		
		if(mr != null) {
			//파일업로드가 정상처리되었다면 파일 외 나머지 폼값을 받아서 처리한다.
			String name = mr.getParameter("name");
			String title = mr.getParameter("title");
			String pass = mr.getParameter("pass");
			String content = mr.getParameter("content");			

			//서버에 저장된 실제파일명을 가져온다.
			String ofileName = mr.getFilesystemName("attachedfile");		 
			String nowTime = new SimpleDateFormat("yyyy_MM_dd_H_m_s_S").format(new Date());
			int idx = -1;
			idx = ofileName.lastIndexOf(".");//확장자따내기
			String sFileName = nowTime + ofileName.substring(idx, ofileName.length());
			//파일객체 만들기
			File oldFile = new File(saveDirectory+"/"+ofileName);//원본파일명
			File newFile = new File(saveDirectory+"/"+sFileName);//변경될파일명
			//저장된 파일명을 변경한다. 
			oldFile.renameTo(newFile);
			//파일명 변경로직 end
			
			//DTO객체에 폼값 입력
			DataRoomDTO dto = new DataRoomDTO();
			dto.setContent(content);
			dto.setTitle(title);
			dto.setName(name);
			dto.setPass(pass);			
			dto.setOfile(ofileName);
			dto.setSfile(sFileName);
			
			System.out.println(ofileName);
			System.out.println(sFileName);
			
			//application내장객체를 서블릿으로 가져온 후 DB에 연결해서 insert처리한다.
			ServletContext app = this.getServletContext();
			DataRoomDAO dao = new DataRoomDAO(app);
			//입력성공이면 1이 반환된다.

			//파일첨부형 게시판 구현시 사용(답변글X)
			//sucOrFail = dao.insert(dto);
			//파일첨부형 + 답변형 게시판 구현시 사용
			sucOrFail = dao.insertReply(dto);
			dao.close();			
		}
		else {
			//파일업로드가 실패하면 글쓰기가 실패한 것으로 간주한다.
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
			resp.sendRedirect("../DataRoom/DataList");
		}
		else {
			//글쓰기 실패시 쓰기페이지로 포워드 한다.
			req.getRequestDispatcher("/11ServletBoard/DataWrite.jsp").forward(req, resp);
			
		}
	}
}
