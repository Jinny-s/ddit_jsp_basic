package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.exception.ExistIdException;
import com.servlet.service.IMemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/view/register.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/view/save.jsp";
		
		MemberVO mv = new MemberVO();
		IMemberService service = MemberServiceImpl.getInstance();
		String memId = request.getParameter("memId");

		mv.setMemId(memId);
		mv.setMemPw(request.getParameter("memPw"));
		mv.setMemEmail(request.getParameter("memEmail"));
		mv.setMemHp(request.getParameter("memHp"));
		
		int cnt = service.insertMember(mv);

		if(cnt > 0) {
			request.setAttribute("msg", "회원 등록이 완료되었습니다.");
			request.setAttribute("url", request.getContextPath() + "/main");
		} else {
			try {
				MemberVO member = service.checkMember(memId);
			} catch (ExistIdException e) {
				request.setAttribute("msg", e.getMessage());
				request.setAttribute("url", request.getContextPath() + "/register");
			} catch (SQLException e) {
				request.setAttribute("msg", "회원 등록이 실패하였습니다.");
				request.setAttribute("url", request.getContextPath() + "/main");
			}
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

}
