package com.koreavc.k08spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnvironmentController {

	@RequestMapping("/environment/main.do")
	public String mainFunc(Model model	) {
		//1.스프링 컨테이너 생성
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		//2.Environment 객체 생성
		ConfigurableEnvironment env = ctx.getEnvironment();
		//3.getPropertySources() 메소드를 통해 외부파일을 읽을 준비를 함.
		MutablePropertySources propertySources = env.getPropertySources();
		//외부파일에서 읽어온 내용을 저장할 변수
		String driver = "";
		String url = "";
		
		try {/*
			4.외부 프로퍼티 파일의 경로를 지정한 후 addLast()를 통해
			프로퍼티소스에 추가한다.
			*/
			String envPath = "classpath:OracleInfo.properties";
			propertySources.addLast(new ResourcePropertySource(envPath));
			//5.파일의 내용을 읽어서 변수에 저장함
			driver = env.getProperty("oinfo.driver");
			url = env.getProperty("oinfo.url");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("driver", driver);
		model.addAttribute("url", url);		
		
		return "04Environment/main";
	}
}
