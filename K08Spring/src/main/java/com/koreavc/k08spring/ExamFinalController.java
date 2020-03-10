package com.koreavc.k08spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.DTO;
import model.MemberDTO;

@Controller
public class ExamFinalController extends HttpServlet{
	
	@RequestMapping("/commandFormView")
	public String cview() {
		return "commandFormView";
	}
	
	@RequestMapping("/commandFormAction.do")
	public String commandObject(DTO dto) {		
		
		return "/commandFormView";
	}
	
	@RequestMapping("/commandChangeAction")
	public String model() {		
		
		return "/commandChangeAction";
	}
	
	@RequestMapping("/commandChangeAction.do")
	public String modelAt(@ModelAttribute("z")DTO dto) {		
		
		return "/commandChangeAction";
	}
	
	@RequestMapping("/jsonPrinter.do")
	@ResponseBody
	public Map<String, Object> responseBodyView(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("year", "2020");
		map.put("ganzi", "경자년");
		map.put("dream", "[\"취업\",\"높은 연봉\", \"끝장나는 복지\"]");
		map.put("goodbye", "모두들 고생 많으셨어요^^*");
		
		return map;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/envReader")
	public String envReader() {		
		
		return "/envReader";
	}
	
	@RequestMapping("/envReader.do")
	public String mainFunc(Model model	) {
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		String stationName = "";
		String lineNumber = "";
		
		try {/*
			4.외부 프로퍼티 파일의 경로를 지정한 후 addLast()를 통해
			프로퍼티소스에 추가한다.
			*/
			String envPath = "classpath:myExternalFile.properties";
			propertySources.addLast(new ResourcePropertySource(envPath));
			//5.파일의 내용을 읽어서 변수에 저장함
			stationName = env.getProperty("stationName");
			lineNumber = env.getProperty("lineNumber");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("stationName", stationName);
		model.addAttribute("lineNumber", lineNumber);		
		
		return "envReader";
	}
	

}
