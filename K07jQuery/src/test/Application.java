package test;

import javax.servlet.ServletContext;

public class Application {

	public String getRealPath(ServletContext application) {
		return application.getRealPath("/images");
	}

}
