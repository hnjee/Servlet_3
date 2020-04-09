package com.hj.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private MemberService memberService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        memberService = new MemberService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//한글 Encoding 처리 
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//pathInfo
		String command = request.getPathInfo();
		//Method
		String method = request.getMethod();
		//Forward, Redirect 선택 
		boolean chk = true; //forward: true, redirect: false
		//path 담을 변수 
		String path = "";

		int num = 0;
		
		try {
		switch (command) {
		case "/memberJoin":
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setEmail(request.getParameter("email"));
				
				int res = memberService.memberJoin(memberDTO);
				chk = false;
				path="../";
			} else {
				System.out.println("회원가입 폼 가져오기 "+chk);
				path="../WEB-INF/views/member/memberJoin.jsp";
			}
			break;
			
		case "/memberLogin":
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				MemberDTO res = memberService.memberLogin(memberDTO);
				if(res!=null) {
					System.out.println("로그인성공");
					HttpSession session = request.getSession();
					session.setAttribute("member", memberDTO);
					chk = false;
					path="../";
				} else {
					request.setAttribute("result", "Login Fail");
					request.setAttribute("path", "./memberLogin");
					path="../WEB-INF/views/common/result.jsp";
				}
			} else {
				System.out.println("로그인 폼 가져오기 "+chk);
				path="../WEB-INF/views/member/memberLogin.jsp";
			}
			break;
		case "/memberLogout":
			HttpSession session = request.getSession();
			//session.removeAttribute("member");
			session.invalidate();
			chk = false;
			path="../";
		case "/memberDelete":
			
			break;		
			
		case "/memberUpdate":
			if(method.equals("POST")) {
			} else {
				
			}
			break;
			
		case "/memberPage":
			System.out.println("멤버페이지 가져오기");
			path="../WEB-INF/views/member/memberPage.jsp";
			break;

		default:
			break;
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(chk) {
			//Forward
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		} else {
			//Redirect
			response.sendRedirect(path);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
