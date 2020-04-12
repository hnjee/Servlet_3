package com.hj.notice;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
		int no = 0;
		NoticeDTO noticeDTO = null;
		
		try {
			System.out.println(command);
		switch (command) {
		case "/noticeList":
			//GET방식 
			ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();
			ar = noticeService.noticeList();
			request.setAttribute("list", ar);
			path="../WEB-INF/views/notice/noticeList.jsp"; //포워드 
			break;

		case "/noticeSelect":
			noticeDTO = new NoticeDTO();
			no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			noticeDTO = noticeService.noticeSelect(no);
			request.setAttribute("dto", noticeDTO);
			path="../WEB-INF/views/notice/noticeSelect.jsp";
			
			break;

		case "/noticeAdd":
			if(method.equals("POST")) {
				noticeDTO = new NoticeDTO();
				noticeDTO.setName(request.getParameter("name"));
				noticeDTO.setSubject(request.getParameter("subject"));
				noticeDTO.setContents(request.getParameter("contents"));
				res = noticeService.noticeAdd(noticeDTO);
				chk=false;
				path="./noticeList";
			}else {
				path="../WEB-INF/views/notice/noticeAdd.jsp";
			}
			
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
