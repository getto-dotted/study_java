package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터 받기
		String fNum = req.getParameter("firstNum");
		String sNum = req.getParameter("secondNum");
		
		try {
			//사칙연산을 수행하기 위해 숫자형으로 변경
			int fnum = Integer.parseInt(fNum);
			int snum = Integer.parseInt(sNum);
			String op = req.getParameter("operator");
			
			int returnValue;
			
			switch(op) {
			case "+":
				returnValue = fnum+snum;
				break;
			case "-":
				returnValue = fnum-snum;
				break;
			case "*":
				returnValue = fnum*snum;
				break;
			case "/":
				returnValue = fnum/snum;
				break;
			default:
				returnValue = 0;
			}
			//연산결과를 리퀘스트 영역에 저장
			req.setAttribute("calResult", "연산의 결과:"+returnValue);			
			
		} catch (Exception e) {
			System.out.println("연산중 오류발생");
			e.printStackTrace();
			req.setAttribute("calResult", "연산중 오류발생 ㅠ ");
		}
		//jsp파일로 포워드해서 영역 공유
		req.getRequestDispatcher("/10Servlet/HelloServlet.jsp").forward(req, resp);
		
		
	}
}
