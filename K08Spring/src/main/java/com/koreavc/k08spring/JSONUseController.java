package com.koreavc.k08spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mybatis.MemberVO;
import mybatis.MybatisMember;

@Controller
public class JSONUseController {

	@RequestMapping("/jsonUse/jsonView.do")
	@ResponseBody
	public Map<String, Object> responseBodyView(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("String", "나는 문자열이다");
		map.put("Number", 1004);
		map.put("Message", "@ResponseBody 슈퍼그뤠잇~");
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Collection");
		list.add("모르면");
		list.add("스튜핏~");
		
		map.put("list", list);
		
		
		return map;
	}
	
	@RequestMapping("/jsonUse/login.do")	
	public String login() {
		
		return "07JsonUse/login";
	}
	//마이바티스 빈을 자동주입
	@Autowired
	private SqlSession sqlSession;
	
	//로그인 처리
	@RequestMapping("/jsonUse/loginAction.do")
	@ResponseBody
	public Map<String, Object> loginAction(HttpServletRequest req, HttpSession session){
	
		Map<String, Object> map = new HashMap<String, Object>();
		
		MemberVO vo = 
				sqlSession.getMapper(MybatisMember.class).login(
						req.getParameter("id"), 
						req.getParameter("pass"));
		
		if(vo==null) {
			map.put("loginResult", 0);
			map.put("loginMessage", "로그인 실패");
		}
		else {
			session.setAttribute("siteUserInfo", vo);
			map.put("loginResult", 1);
			map.put("loginMessage", "로그인 성공");
			map.put("loginHtml", 
					"<div class='row' style='border:2px solid #cccccc;padding:10px;'>"	+	
					"<h4>아이디:"+ vo.getId() +"</h4>"+
					"<h4>이름:"+ vo.getName() +"</h4>"+	
					"<br /><br />"+
					"<button class='btn btn-danger' "+
					"onclick=\"location.href='logout.do';\">\r\n" + 
					"로그아웃</button></div>");
		}
		
		return map;
	}
}