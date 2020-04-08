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
				int num = Integer.parseInt(request.getParameter("num"));
				PointDTO pointDTO = pointService.pointSelect(num);
				request.setAttribute("dto", pointDTO);
				path = "../WEB-INF/views/point/pointSelect.jsp";
			}
			break;
		case "/pointDelete":
			chk=false;
			int num = Integer.parseInt(request.getParameter("num"));
			int res = pointService.pointDelete(num);
			System.out.println(res);
			if(res>0) {
				path = "./pointList";
			}
			break;
		case "/pointAdd":
			if(method.equals("POST")) {
				chk = false;
				PointDTO pointDTO = new PointDTO();
				pointDTO.setName(request.getParameter("name"));
				pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
				pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
				pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
				pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
				pointDTO.setTot(Integer.parseInt(request.getParameter("tot")));
				pointDTO.setAvg(Integer.parseInt(request.getParameter("avg")));
				
				int res2 = pointService.pointAdd(pointDTO);
		
				if(res2>0) {
					path = "./pointList";
				}
			} else {
				System.out.println("점수 입력창으로 이동");
				RequestDispatcher view = request.getRequestDispatcher("../WebContent/WEB-INF/views/point/pointAdd.jsp");
				//WEB-INF는 백엔드에서만 접속 가능하다 (보안) 
				view.forward(request, response);
			}
			
			
			path = "../WEB-INF/views/point/pointAdd.jsp";
			break;
		case "/pointMod":
			if(method.equals("POST")) {
			} else {
				chk = true;
				path = "../WEB-INF/views/point/pointMod.jsp";
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
