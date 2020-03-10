package com.koreavc.k08spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import di.AvengerInfo;
import di.Avengers;
import di.CalculatorDTO;

@Controller
public class DIController {

	@RequestMapping("di/myCalculator")
	public String myCal(Model model	) {
		/*
		ApplicationContext 파일의 위치를 문자열에 저장한다.
		물리적 경로는 /src/main/resources 디렉토리 하위이다.
		 */
		String configLocation = "classpath:DIAppCtxCalculator.xml";
		
		/*
		스프링 컨테이넌 생성 : xml파일을 파싱하여 파싱된 내용을
		기반으로 참조변수에 할당한다.
		 */
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		/*
		XML설정파일에서 생성한 Bean(빈, 객체)을 getBean()메소드를 통해
		주입받아 참조변수에 할당한다. new 연산자를 통해 생성한 것과
		동일하지만, 외부에서 생성하여 해당 컨트롤러로
		주입(Injection)하게 된다.
		 */
		CalculatorDTO myCal = ctx.getBean("myCal", CalculatorDTO.class);
		/*
		주입받은 빈을 통해 해당 클래스에 정의된 메소드를 호출하여
		연산을 진행한다.
		 */
		model.addAttribute("addResult", myCal.add());
		model.addAttribute("subResult", myCal.sub());
		model.addAttribute("mulResult", myCal.mul());
		model.addAttribute("divResult", myCal.div());
		
		//뷰 호출
		return "03DI/myCalculator";
	}
	
	@RequestMapping("di/myAvengers")
	public ModelAndView myAvengers() {
		//XML설정파일의 경로를 설정한다.
		String configLocation = "classpath:DIAppCtxAvengers.xml";
		//스프링 컨테이너를 생성한다
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		//캡틴 빈을 주입받은 후 정보출력을 위한 문자열 저장
		AvengerInfo avengerInfo = ctx.getBean("AvengersInfo1", AvengerInfo.class);
		
		String captainAmerica = avengerInfo.AvengersView();
		//아이언맨 정보를 출력하기 위한 객체생성
		Avengers avengers = ctx.getBean("hero2", Avengers.class);
		//setter를 통해 avengersInfo빈을 생성
		avengerInfo.setAvengers(avengers);
		//정보출력을 위한 문자열 저장
		String ironMan = avengerInfo.AvengersView();
		
		
		Avengers blackWidow = ctx.getBean("hero3", Avengers.class);
		avengerInfo.setAvengers(blackWidow);
		String blackWidow2 = avengerInfo.AvengersView();
		
		//ModelAndView 객체를 통해 뷰 설정 및 데이터 저장
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("03DI/myAvengers");
		mv.addObject("captainAmerica",captainAmerica);
		mv.addObject("ironMan",ironMan);
		mv.addObject("blackWidow",blackWidow2);
		//스프링 컨테이너 자원반납(해제)
		ctx.close();
		return mv;
	}
}
