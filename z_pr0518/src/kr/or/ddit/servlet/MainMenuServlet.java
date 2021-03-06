package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.context.ApplicationContext;
import kr.or.ddit.service.MemberService;

@WebServlet("/index.htm")
public class MainMenuServlet extends HttpServlet {
    
	private MemberService memberService = (MemberService) ApplicationContext.getApplicationContext().get("memberService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/common/indexPage.jsp";
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
