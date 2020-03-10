package com.koreavc.k08spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybatis.MemberVO;
import mybatis.MyBoardDTO;
import mybatis.MybatisDAO;
import mybatis.MybatisMember;
import mybatis.ParameterDTO;
import util.EnvFileReader;
import util.PagingUtil;

@Controller
public class MybatisController {

	/*
	servlet-context.xml에서 생성한 빈을 자동으로 주입받아
	Mybatis를 사용할 준비를 한다. @Autowired는 타입만 일치하면
	빈을 자동으로 주입받을 수 있다. 
	
	@Autowired 어노테이션
	-의존관계를 자동으로 설정해주는 역할을 한다.
	-생성자, 멤버변수, 메소드에 적용 가능하다.
	-setXXX()와 같은 setter 메소드가 아니어도 적용 가능하다.
	-타입(형)을 이용해 자동적으로 프로퍼티의 값을 설정하므로
	해당 타입의 빈이 2개이상 존재하거나, 없을경우 예외가 발생하게 된다.
	 */
	private SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("@Autowired->DB연결성공");
	}
	//방명록 리스트
	@RequestMapping("/mybatis/list.do")
	public String list(Model model, HttpServletRequest req) {
		
		String addQueryString = "";
		Map param = new HashMap();
		
		String searchColumn = req.getParameter("searchColumn");
		String searchWord = req.getParameter("searchWord");
		String startIdx = req.getParameter("startIdx");
		String endIdx = req.getParameter("endIdx");
		if(searchColumn!=null) {
			//전달된 파라미터가 있을때만 아래 문장 수행
			addQueryString = String.format("searchColumn=%s&searchWord=%s&", searchColumn, searchWord);
			param.put("searchColumn", searchColumn);
			param.put("searchWord", searchWord);
		}
		if(startIdx!=null) {
			param.put("startIdx", startIdx);
			addQueryString += String.format("startIdx=%s&", startIdx);
		}
		if(endIdx!=null) {
			param.put("endIdx", endIdx);
			addQueryString += String.format("endIdx=%s&", endIdx);
		}
		
		
		/*
		페이지처리를 위한 레코드수 카운트
		getTotalCount()는 MybatisDAO 인터페이스에 정의된 추상메소드로.
		해당 호출로 실제 동작을 하는 것은 Mapper에 정의된 id="getTotalCount"엘리먼트의
		쿼리문이 된다.
		 */
		int totalRecordCount = sqlSession.getMapper(MybatisDAO.class).getTotalCount(param);
		
		//페이지 처리를 위한 설정값
		int pageSize = 
				Integer.parseInt(EnvFileReader.getValue("Paging.properties", "pageSize")); 				
		int blockPage = 
				Integer.parseInt(EnvFileReader.getValue("Paging.properties", "blockPage")); 
		//전체 페이지수 계산
		int totalPage = (int)Math.ceil((double)totalRecordCount/pageSize);
		//현재 페이지번호 파라미터로 받기
		int nowPage = req.getParameter("nowPage")==null? 1 : Integer.parseInt(req.getParameter("nowPage"));
		//쿼리의 start, end값 구하기
		int start = (nowPage-1) * pageSize +1;
		int end = nowPage * pageSize;
		param.put("start", start);
		param.put("end", end);
		
		//ArrayList<MyBoardDTO> lists = sqlSession.getMapper(MybatisDAO.class).list();
		//페이지 처리 있는 메소드
		ArrayList<MyBoardDTO> lists = sqlSession.getMapper(MybatisDAO.class).listPage(param);
		//페이지 처리를 위한 static메소드 호출
		String pagingImg = PagingUtil.pagingImg(totalRecordCount, pageSize, blockPage, nowPage,	
				req.getContextPath()+"/mybatis/list.do?"+addQueryString);
		
		model.addAttribute("pagingImg", pagingImg);
		
		//내용에 대한 줄바꿈 처리 부분
		for(MyBoardDTO dto : lists) {
			String temp = dto.getContents().replace("\r\n", "<br/>");
			dto.setContents(temp);
		}
		
		//모델객체에 저장후 뷰 호출
		model.addAttribute("lists", lists);	
		
		return "06Mybatis/list";
	}
	//글쓰기
	@RequestMapping("/mybatis/write.do")
	public String write(Model model, HttpSession session, HttpServletRequest req) {
		//글쓰기 페이지에 진입했을때 세션 영역에 데이터가 없으면
		if(session.getAttribute("siteUserInfo")==null) {
			//로그인후 쓰기 페이지로 돌아오기 위해 뷰를 저장한 후
			model.addAttribute("backUrl","06Mybatis/write");
			//로그인 페이지로 즉시 이동한다.
			return "redirect:login.do";
		}		
		//로그인 된 상태라면 쓰기 페이지로 바로 진입
		return "06Mybatis/write";
	}
	//로그인페이지
	@RequestMapping("/mybatis/login.do")
	public String login(Model model) {
		
		return "06Mybatis/login";
	}
	//로그아웃 처리
	@RequestMapping("/mybatis/logout.do")
	public String logout(HttpSession session) {
		//세션영역을 비운 후 로그인 페이지로 이동한다.
		session.setAttribute("siteUserInfo", null);
		return "redirect:login.do";
	}
	//로그인프로세스
	@RequestMapping("/mybatis/loginAction.do")
	public ModelAndView loginAction(HttpServletRequest req, HttpSession session) {
		
		//Mapper의 id="login"인 엘리먼트를 인터페이스를 통해 호출한다.
		MemberVO vo = sqlSession.getMapper(MybatisMember.class).login(req.getParameter("id"),req.getParameter("pass"));
		
		ModelAndView mv = new ModelAndView();
		
		if(vo==null) {
			//로그인에 실패한 경우
			mv.addObject("LoginNg", "아이디/패스워드가 틀렸습니다.");
			//로그인 페이지로 다시이동
			mv.setViewName("06Mybatis/login");
			return mv;
		}
		else {
			//로그인에 성공한 경우 Session영역에 속성저장
			session.setAttribute("siteUserInfo", vo);
		}
		
		//로그인 후 페이지 이동
		String backUrl = req.getParameter("backUrl");
		if(backUrl==null || backUrl.equals("")) {
			//다시 로그인 페이지로 이동함.
			mv.setViewName("06Mybatis/login");
		}
		else {
			//로그인후 글쓰기 페이지로 이동함
			mv.setViewName(backUrl);
		}
		return mv;
		
	}
	//글쓰기 프로세스
	@RequestMapping(value="/mybatis/writeAction.do", method=RequestMethod.POST)
	public String writeAction(Model model, HttpServletRequest req, HttpSession session) {
		//글쓰기 처리전 세션이 없다면 로그인 페이지로 이동한다.
		if(session.getAttribute("siteUserInfo")==null) {
			return "redirect:login.do";
		}
		sqlSession.getMapper(MybatisDAO.class).write(
				req.getParameter("name"), 
				req.getParameter("contents"),
				((MemberVO)session.getAttribute("siteUserInfo")).getId());
		
		//글쓰기 완료시 리스트로 이동
		return "redirect:list.do";
	}	
	
	//기존 게시물 내용 가져와서 수정폼에 삽입하기
	@RequestMapping("/mybatis/modify.do")
	public String modify(Model model, HttpServletRequest req, HttpSession session) {
		
		if(session.getAttribute("siteUserInfo")==null) {
			return "redirect:login.do";
		}
		//Mapper쪽으로 전달할 파라미터값을 저장할 DTO객체 생성
		ParameterDTO parameterDTO = new ParameterDTO();
		parameterDTO.setBoard_idx(req.getParameter("idx"));
		parameterDTO.setUser_id(((MemberVO)session.getAttribute("siteUserInfo")).getId());
		//Interface 호출을 통해 Mapper로 전달
		MyBoardDTO dto = sqlSession.getMapper(MybatisDAO.class).view(parameterDTO);
		
		model.addAttribute("dto", dto);
		return "06Mybatis/modify";
		
	}
	//전송된 폼값으로 수정처리하기
	@RequestMapping("/mybatis/modifyAction.do")
	public String modifyAction(Model model, HttpServletRequest req, HttpSession session) {
		
		if(session.getAttribute("siteUserInfo")==null) {
			return "redirect:login.do";
		}
		
		sqlSession.getMapper(MybatisDAO.class).modify(
				req.getParameter("idx"),
				req.getParameter("name"),
				req.getParameter("contents"),
				((MemberVO)session.getAttribute("siteUserInfo")).getId());
		
	
		
		return "redirect:list.do";
	}
	
	@RequestMapping("/mybatis/delete.do")
	public String delete(Model model, HttpServletRequest req, HttpSession session) {
		
		if(session.getAttribute("siteUserInfo")==null) {
			return "redirect:login.do";
		}
		sqlSession.getMapper(MybatisDAO.class).delete(
				req.getParameter("idx"),				
				((MemberVO)session.getAttribute("siteUserInfo")).getId());
		
		return "redirect:list.do";
	}
	
	
}
