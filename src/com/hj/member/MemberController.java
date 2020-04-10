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
		//변수들 
		String path = "";
		int num = 0;
		int res = 0;
		HttpSession session = null;
		MemberDTO memberDTO = null;
		boolean chkOut = false; //true: 보통 로그아웃, false: 탈퇴 로그아웃
		try {
		switch (command) {
		case "/memberJoin":
			if(method.equals("POST")) {
				memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setEmail(request.getParameter("email"));
				
				res = memberService.memberJoin(memberDTO);
				chk = false;
				path="../";
				//리다이렉트 방식 
			} else {
				System.out.println("회원가입 폼 가져오기 "+chk); 
				path="../WEB-INF/views/member/memberJoin.jsp";
				//포워드 방식 
			}
			break;
			
		case "/memberLogin":
	
			if(method.equals("POST")) {
				memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				memberDTO = memberService.memberLogin(memberDTO);
				if(memberDTO!=null) {
					System.out.println("로그인성공");
					session = request.getSession();
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
			if (chkOut) {
				//기본 로그아웃 
				session = request.getSession();
				//session.removeAttribute("member");
				session.invalidate();
				chk = false;
				path="../";
			} else {
				//탈퇴 로그아웃 
				session = request.getSession();
				//session.removeAttribute("member");
				session.invalidate();
				String msg ="정상적으로 탈퇴되었습니다.";
				request.setAttribute("result", msg);
				request.setAttribute("path", "../");
				path="../WEB-INF/views/common/result.jsp";
			}
			
			break;
			
		case "/memberDelete":
			session = request.getSession();
			memberDTO = (MemberDTO)session.getAttribute("member");
			System.out.println(memberDTO.getPw());
			memberDTO.setPw(request.getParameter("pw"));
			System.out.println(memberDTO.getPw());
		
			res = memberService.memberDelete(memberDTO);
		
			if(res>0) {
				chkOut=false; //탈퇴 로그아웃 
				chk=false;
				path="./memberLogout";	
			}
			else {
				String msg ="비밀번호가 일치하지 않습니다. 다시 입력해주세요.";
				request.setAttribute("result", msg);
				request.setAttribute("path", "./memberPage");
				path="../WEB-INF/views/common/result.jsp";
			}
			
			break;		
			
		case "/memberUpdate":
			if(method.equals("POST")) {
				memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setEmail(request.getParameter("email"));
				res = memberService.memberUpdate(memberDTO);
				
				request.setAttribute("method", method);
				request.setAttribute("result", res);
				if(res>0) {
					session = request.getSession();
					session.setAttribute("member", memberDTO);
					chk=false;
					path="../";
				} else {
					path="../WEB-INF/views/member/memberUpdate.jsp";
				}
				
			} else {
				System.out.println("수정 폼 가져오기 "+chk);
				path="../WEB-INF/views/member/memberUpdate.jsp";
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
