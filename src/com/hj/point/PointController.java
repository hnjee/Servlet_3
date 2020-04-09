package com.hj.point;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PointController2
 */
@WebServlet("/PointController2")
public class PointController extends HttpServlet {
	private PointService pointService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
        this.pointService = new PointService();
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
		int res = 0;
		int num = 0;
		try {
		switch (command) {
		case "/pointList":
			ArrayList<PointDTO> ar = pointService.pointList();
			request.setAttribute("list", ar);
			path = "../WEB-INF/views/point/pointList.jsp";
			break;
			
		case "/pointSelect":
			if(method.equals("POST")) {
			} else {
				num = Integer.parseInt(request.getParameter("num"));
				PointDTO pointDTO = pointService.pointSelect(num);
				request.setAttribute("dto", pointDTO);
				path = "../WEB-INF/views/point/pointSelect.jsp";
			}
			break;
			
		case "/pointDelete":
			chk=false;
			num = Integer.parseInt(request.getParameter("num"));
			res = pointService.pointDelete(num);
			if(res>0) {
				path = "./pointList";
			}
			break;
			
		case "/pointAdd":
			if(method.equals("POST")) {
				PointDTO pointDTO = new PointDTO();
				pointDTO.setName(request.getParameter("name"));
				pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
				pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
				pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
				pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
				request.setAttribute("dto", pointDTO);
				res = pointService.pointAdd(pointDTO);
				String msg ="점수 등록 실패";
				if(res>0) msg="점수 등록 성공";
				request.setAttribute("result", msg);
				request.setAttribute("path", "./pointList");
				path="../WEB-INF/views/common/result.jsp";
			} else {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/point/pointAdd.jsp");
				//WEB-INF는 백엔드에서만 접속 가능하다 (보안) 
				view.forward(request, response);
			}
			break;
		case "/pointMod":
		
			if(method.equals("POST")) {
				PointDTO pointDTO = new PointDTO();
				pointDTO.setName(request.getParameter("name"));
				pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
				pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
				pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
				pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
				
				res = pointService.pointMod(pointDTO);
				String msg = "점수 수정 실패";
				if(res>0) {
					msg="점수 수정 성공";
					request.setAttribute("path", "./pointSelect?num="+pointDTO.getNum());
				} else {
					request.setAttribute("path", "./pointList");
				}
				request.setAttribute("result", msg);
				path="../WEB-INF/views/common/result.jsp";
			} else {
				num = Integer.parseInt(request.getParameter("num"));
				PointDTO pointDTO = pointService.pointSelect(num); 
				request.setAttribute("dto", pointDTO);
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/point/pointMod.jsp");
				view.forward(request, response);
			}
			break;
			
		default:
			System.out.println("Ect");
			break;
		}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		if(chk) { //forward
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		} else { //redirect
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
