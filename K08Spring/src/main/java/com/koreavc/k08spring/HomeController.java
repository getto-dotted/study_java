package com.koreavc.k08spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.DBConnect;
import model.DTO;
import model.MemberDTO;
import util.EnvFileReader;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
				
		return "home";
	}
	
	
	@RequestMapping("/home/helloSpring")
	public String helloSpring(Model model) {
		
		String firstMessage = "My First Spring MVC 컨트롤러";
		model.addAttribute("firstMessage", firstMessage);
		
		return "helloSpring";
	}
	
	@RequestMapping("/test/dbConnection.do")
	public String dbconn() {
		
		//드라이버와 url을 가져와서 생성자 호출
		String drv = EnvFileReader.getValue("OracleInfo.properties", "oinfo.driver");
		String url = EnvFileReader.getValue("OracleInfo.properties", "oinfo.url");
		DBConnect dao = new DBConnect(drv, url);
		
		return "dbConnection";
	}
	
	
	
}
