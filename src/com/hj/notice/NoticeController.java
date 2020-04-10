package com.hj.notice;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        this.noticeService = new NoticeService();
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
		int res = 0;
		int num = 0;
		
		try {
		switch (command) {
		case "/noticeList":
			ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();
			ar = noticeService.noticeList();
			request.setAttribute("list", ar);
			path="../WEB-INF/views/notice/noticeList.jsp";
			break;
			
		case "/noticeSelect":
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNo(Integer.parseInt(request.getParameter("no")));
			break;

		case "/noticeAdd":
			
			break;
			
		case "/noticeDelete":
			
			break;
			
		case "/noticeMod":
			
			break;
			
		default:
			System.out.println("ECT");
			break;
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(chk) {
			//포워드 방식
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		} else {
			//리다이렉트 방식 
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
