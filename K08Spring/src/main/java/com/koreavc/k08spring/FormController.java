package com.koreavc.k08spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.MemberDTO;


/*
스프링 프레임워크는 사용자의 요청을 받은 후 제일 먼저 기본 패키지를
스캔하여 컨트롤러 클래스를 찾는다. 그리고 해당 요청명에 매핑되는
메소드를 찾아 해당 요청을 실행한다.


@Controller
	: 해당 클래스를 컨트롤러로 사용하고 싶을 때 클래스명 앞에
	선언한다. 패키지를 스캔할때 해당 어노테이션이 있는 클래스를
	우선적으로 찾게 된다.
 */
@Controller
public class FormController {

	/*
	@RequestMapping
		: 요청명을 매핑한다. 요청명은 컨택스트 루트를 제외한
		나머지 경로명으로 이루어진다. 요청명의 매핑정보를
		통해 메소드를 호출하게 되므로 메소드명은 큰 의미가 없다.
		개발자가 구분하기 좋은 정도의 이름으로 설정한다.
	 */
	@RequestMapping("/form/servletRequest")
	public String loginMember(HttpServletRequest req, Model model) {
		/*
		폼값받기1] 파라미터로 전달된 값을 HttpServletRequest객체를 통해서
		받는다. JSP나 Servlet에서 받는 것과 동일한 방법으로 받을 수 있다.
		 */
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		/*
		View영역으로 전송할 데이터를 Model객체에 저장한다.
		JSP에서 사용하는 영역과 비슷하다 생각하면 된다.
		 */
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("message", "로그인 정보 전달됨");
		/*
		View페이지명을 반환한다.
		아래처럼 뷰 경로를 반환하면 ViewResolver가 경로를 조립하여
		해당 View를 웹브라우저에 출력하게 된다.
		(설정파일 : servlet-context.xml)			
		 */
		return "01Form/servletRequest";
	}
	/*
	폼값받기2] @RequestParam 어노테이션으로 폼값받기
		파라미터 형식으로 아래와 같이 폼값을 받아 변수에 즉시 할당한다.
		해당 변수는 함수내에서 사용이 가능하다.
	 */
	@RequestMapping("/form/requestParam.do")
	public String joinMember(Model model, 
			@RequestParam("name") String name,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("email") String email) {
		MemberDTO memberDTO = new MemberDTO(id, pw, name, email);
		
		model.addAttribute("memberInfo", memberDTO);
		
		return "01Form/requestParam";
	}
	/*
	폼값받기3] @PathVariable 어노테이션으로 폼값받기
		요청명뒤에 따라오는 값들이 메소드에서 사용가능한
		파라미터가 된다. 아래는 4개의 파라미터를 받아서 메소드
		내에서 사용하게 된다. 단 이 경우 웹브라우저는 파라미터를
		경로로 인식하므로 이미지의 경로에 주의해야 한다.
	 */
	@RequestMapping("/form/{mId}/{mName}/{mPw}/{mEmail}")
	public String pathVar(Model model,
			@PathVariable String mId,
			@PathVariable String mName,
			@PathVariable String mPw,
			@PathVariable String mEmail) {
		
		model.addAttribute("m_id", mId);
		model.addAttribute("m_name", mName);
		model.addAttribute("m_pw", mPw);
		model.addAttribute("m_email", mEmail);
		
		return "01Form/pathVariable";
	}
	
	/*
	폼값받기4] 커맨드 객체를 이용해서 폼값 한번에 받기
	- 커맨드객체를 사용할 때는 클래스명 앞글자를 소문자로 변경한 형태의
	매개변수를 사용해야 한다.
	-DTO생성시 반드시 getter/setter가 생성되어야 한다.
	-파라미터의 갯수가 다른 것은 허용되나, 
	파라미터명과 멤버변수명은 반드시 동일해야 한다.
	
	※커맨드객체의 이름을 변경해서 View로 전달하고 싶을때는
	@ModelAttribute 어노테이션을 사용하면 된다.
	 */
	@RequestMapping("/form/commandObject.do")
	public String commandObject(MemberDTO memberDTO) {
		
		return "01Form/commandObject";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
