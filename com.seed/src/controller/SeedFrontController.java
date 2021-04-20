package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SeedAction;
import service.SeedActionForward;

/**
 * Servlet implementation class SeedFrontController
 */
@WebServlet("*.seed")
public class SeedFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doProcess(HttpServletRequest request , HttpServletResponse response)throws ServletException , IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println("requestURI :" + requestURI);
		System.out.println("contextPath :" + contextPath);
		System.out.println("command :" + command);
		
		SeedAction action = null;
		SeedActionForward forward = null;
		
		
		
		
		
		
		
		
		
		if ( forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
				
			} else {
				RequestDispatcher dispatcher =
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}	
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		doProcess(request, response);
	}

}
