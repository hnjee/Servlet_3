package com.hj.point;

import java.io.IOException;
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
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
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
		
		switch (command) {
		case "/pointList":
			System.out.println("List");
			break;
		case "/pointAdd":
			System.out.println("Add");
			break;
		case "/pointMod":
			System.out.println("Mod");
			break;
		case "/pointSelect":
			System.out.println("Select");
			break;
		case "/pointDelete":
			System.out.println("Delete");
			break;
		default:
			System.out.println("Ect");
			break;
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
