package prodController;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUtil {
	
	//매개변수 : 요청정보를 저장한 request객체와 물리적경로를 받음.
	public static MultipartRequest upload(HttpServletRequest req, String saveDirectory) {
		
		MultipartRequest mr = null;
		try {//해당 객체가 생성됨과 동시에 파일은 서버로 업로드 된다. 예외발생시 경로or용량을 확인.
			mr = new MultipartRequest(req, saveDirectory, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mr;
	}

	public static void deleteFile(HttpServletRequest req,
			String directory, String filename) {
		
		//서버의 물리적경로 가져오기
		String saveDirectory = 
			req.getServletContext().getRealPath(directory);
		
		//기존에 저장된 파일에 대한 객체생성
		File f = new File(saveDirectory+File.separator+filename);
		
		//만약 파일이 존재한다면 해당 파일 삭제처리
		if(f.exists()) {
			f.delete();
		}
	}

	//파일 다운로드 로직
	public static void download(
						HttpServletRequest request,
						HttpServletResponse response,
						String directory){
		
		String ofile = request.getParameter("ofile");
		String sfile = request.getParameter("sfile");
		
		/*
		파일다운로드 원리
		1.웹브라우저가 인식하지 못하는 컨텐츠타입을 응답헤더에 설정해주면
		웹브라우저는 자체 다운로드 창을 띄운다.
		
		2.서버에 저장된 파일을 출력스트림을 통해 웹브라우저에 출력한다.
		*/
		try{
			//파일이 저장된 물리적인 경로를 가져온다.
			String saveDirectory 
			= request.getServletContext().getRealPath(directory);
			
			//3.파일 크기를 얻기 위한 파일객체 생성
			// - 다운로드시 프로그래스바를 표시하기 위함.
			File f = new File(saveDirectory+File.separator+sfile);			
			long length = f.length();
			
			//다운로드를 위한 응답헤더 설정
			//4.다운로드창을 보여주기 위한 응답헤더 설정
			//4-1.웹브라우저가 인식하지 못하는 컨텐츠타입(MIME)을 설정
			response.setContentType("binary/octect-stream");
			//4-2.다운로드시 프로그래스바를 표시하기위한 컨텐츠길이 설정
			response.setContentLengthLong(length);
			
			
			
			String client = request.getHeader("User-Agent");
			response.reset() ;
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Description", "JSP Generated Data");
			if(client.indexOf("MSIE") != -1){				 
				response.setHeader ("Content-Disposition", "attachment; filename="+
						new String(ofile.getBytes("KSC5601"),"ISO8859_1"));
			}else{				 
				ofile = new String(ofile.getBytes("utf-8"),"iso-8859-1");
				response.setHeader("Content-Disposition", "attachment; filename=\"" +
						ofile + "\"");
				response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
			} 
			 
			response.setHeader ("Content-Length", ""+f.length() );
			
			
			
			
			
			/*
			IO작업을 통해서 서버에 있는 파일을 웹브라우저에 바로 출력
			
			데이터소스 : 파일 - 노드스트림 : FileInputStream
								필터스트림 : BufferedInputStream
			데이터목적지 : 웹브라우저 - 노드스트림 : response.getOutputStream();
										필터스트림 : BufferedOutputStream
			*/
			//5.서버에 있는 파일에 연결할 입력스트림 생성
			BufferedInputStream bis 
				= new BufferedInputStream(
						new FileInputStream(f));
			//6.웹브라우저에 연결할 출력스트림 생성
			BufferedOutputStream bos 
				= new BufferedOutputStream(
						response.getOutputStream());
			//7.bis로 읽고 bos로 웹브라우저에 출력
			int data;
			while((data=bis.read()) != -1){
				bos.write(data);
			}
			//8.스트림 닫기
			bis.close();
			bos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	
}
