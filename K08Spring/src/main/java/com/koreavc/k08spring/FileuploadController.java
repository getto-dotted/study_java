package com.koreavc.k08spring;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileuploadController {

	@RequestMapping("/fileUpload/uploadPath.do")
	public void uploadPath(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//request 객체를 통해 물리전인 경로를 얻어온다.
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		//response 객체를 통해 화면에 즉시 출력한다.		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("/upload 폴더의 물리적 경로 출력:");
		writer.print(path);
	}
	@RequestMapping("/fileUpload/uploadForm.do")
	public String uploadForm() {
		return "05FileUpload/uploadForm";
	}
	/*
	파일업로드 처리 메소드
		:파일업로드는 무조건 post방식이어야 하므로 method지정함.
		method를 지정하는 경우 value도 동시에 지정해야함
	 */
	@RequestMapping(value="/fileUpload/uploadAction.do", method=RequestMethod.POST)
	public String uploadAction(HttpServletRequest req, Model model) {
		//서버의 물리적경로 가져오기
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		//View로 전달할 데이터 저장용 맵 컬렉션 생성
		Map returnObj = new HashMap();
		try {
			/*
			파일업로드를 위한 Multipart객체를 생성한다. 생성과 동시에
			업로드는 완료되고 나머지 폼값을 통째로 받아서 처리한다.
			 */
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
			//업로드폼의 file속성 필드의 이름을 모두 읽어온다.
			Iterator itr = mhsr.getFileNames();
			
			//업로드된 파일명 처리를 위한 변수와 컬렉션 생성
			MultipartFile mfile = null;
			String fileName ="";
			List resultList = new ArrayList();
			
			//파일외 폼값 받아오기
			String title = mhsr.getParameter("title");
			
			//업로드폼의 file속성 필드갯수만큼 반복함(2회)
			while(itr.hasNext()) {
				fileName = (String)itr.next();
				
				//서버로 업로드된 임시파일명 가져오기
				mfile = mhsr.getFile(fileName);
				System.out.println("mfile="+mfile);
				
				//한글깨짐방지 처리후 업로드된 파일명을 가져옴
				String originalName = new String(mfile.getOriginalFilename().getBytes(),"UTF-8");
				if("".equals(originalName)) {
					/*
					만약 업로드된 파일명이 공백문자라면 업로드가 되지 않은 것으로 간주하고
					반복의 처음으로 이동한다.
					 */
					continue;
				}
				//파일의 확장자 가져오기
				String ext = originalName.substring(originalName.lastIndexOf('.'));
				//UUID를 통해 생성된 문자열과 확장자 결합
				String saveFileName = getUuid() +ext;
				/*
				File.separator : 윈도우와 리눅스는 서로 디렉토리를 구분하는
				기호가 다르므로, 해당 OS에 맞는 기호를 자동으로 붙여준다.
				윈도우는 \(역슬러시), 리눅스는 /(슬러시)를 사용하게 된다.
				 */
				File serverFullName = new File(path+File.separator+saveFileName);
				//조립된 경로에 해당 파일 저장
				mfile.transferTo(serverFullName);
				
				Map file = new HashMap();
				file.put("originalName", originalName);//원본파일명
				file.put("saveFileName", saveFileName);//저장된파일명
				file.put("serverFullName", serverFullName);//서버에 저장된 전체 경로 및 파일명
				file.put("title", title);
				
				//Map에 저장된 파일정보를 List에 추가한다.
				resultList.add(file);
			}
			returnObj.put("files", resultList);			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("returnObj", returnObj);
		
		return "05FileUpload/uploadAction";
	}
	/*
	UUID(Universally Unique Identifier)
		: 범용 고유 식별자. 문자열을 생성하면 하이픈이 4개
		포함된 32자의 랜덤한 문자열이 생성된다. JDK에서 
		기본제공되는 클래스이다.
	 */
	public static String getUuid() {
		String uuid = UUID.randomUUID().toString();
		System.out.println("UUID:"+uuid);
		uuid = uuid.replaceAll("-", "");
		System.out.println("생성된 UUID:"+uuid);
		return uuid;
	}
	@RequestMapping("/fileUpload/uploadList.do")
	public String uploadList(HttpServletRequest req, Model model) {
		//물리적 경로 가져오기
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		
		//경로를 통해서 File객체 생성
		File file = new File(path);
		//해당경롱의 파일목록을 배열형태로 가져오기
		File[] fileArray = file.listFiles();
		/*
		파일정보를 저장하기 위해 Map컬렉션 생성. Key값은 파일명,
		Value값은 파일의 용량을 저장한다.
		 */
		Map<String, Integer> fileMap = new HashMap<String, Integer>();
		for(File f : fileArray) {
			fileMap.put(f.getName(), (int)Math.ceil(f.length()/1024.0));			
		}
		
		model.addAttribute("fileMap", fileMap);	
		return "05FileUpload/uploadList";
	}
	@RequestMapping("/fileUpload/download.do")
	public ModelAndView download(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		String fileName = req.getParameter("fileName");
		String oriFileName = req.getParameter("oriFileName");
		
		String saveDirectory = req.getSession().getServletContext().getRealPath("/resources/upload");
		
		File downloadFile = new File(saveDirectory+"/"+fileName);
		
		if(!downloadFile.canRead()) {
			throw new Exception("파일을 찾을 수 없습니다");
		}
		ModelAndView mv = new ModelAndView();
		//servlet-context.xml에서 생성한 다운로드 관련 빈을
		//View로 지정하여 파일을 다운로드 처리한다.
		mv.setViewName("fileDownloadView");
		mv.addObject("downloadFile", downloadFile);
		mv.addObject("oriFileName", oriFileName);
		return mv;
	}
}
