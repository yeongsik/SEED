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
import service.live.LiveAddAction;
import service.live.LiveDelete;
import service.live.LiveDetailAction;
import service.live.LiveListAction;
import service.live.LiveModify;
import service.live.LiveModifyAction;
import service.member.MemberLogIn;
import service.news.NewsAddAction;
import service.news.NewsDetailAction;
import service.news.NewsListAction;
import service.news.NewsModify;
import service.news.NewsModifyAction;

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
		
		// Member 
		// login form
		if (command.equals("/MemberLogInForm.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/loginform.jsp");
		} else if (command.equals("/MemberLogIn.seed")) {
			try {
				action = new MemberLogIn();
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// tip ( 승국님 ) 
		
		// free ( 혜영님 ) 
		
		// live ( 유중님 ) 
				// 글작성
				if(command.equals("LiveAddAction.seed")) {
					try {
						action = new LiveAddAction();
						forward = action.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				// 글작성 폼	
				}else if(command.equals("/live_board_write.seed")) {
					forward = new SeedActionForward();
					forward.setRedirect(false);
					forward.setPath("liveboard/live_board_write.jsp");
					
				// 글목록	
				}else if(command.equals("/LiveListAction.seed")) {
					try {
						action = new LiveListAction();
						forward = action.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				// 상세 페이지	
				}else if(command.equals("LiveDetailAction.seed")) {
					try {
						action = new LiveDetailAction();
						forward = action.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
				}
				//수정 폼	
					
				  }else if(command.equals("/LiveModifyAction.seed")) { 
					 try { action = new LiveModifyAction(); 
					 	 forward = action.execute(request, response);
				  
				  }catch(Exception e) { 
					    e.printStackTrace(); 
				  }
				 
				  // 수정 
				  }else if(command.equals("/LiveModify.seed")) {
				  	 try { action = new LiveModify(); 
				  		 forward = action.execute(request, response); 
				  
				  	 } catch(Exception e) { 
				  		 e.printStackTrace(); 
				  	}
				  
				  // 삭제 폼 
				  }else if(command.equals("/LiveDeleteAction.seed")) { 
					  forward = new SeedActionForward(); 
					  forward.setRedirect(false); 
					  forward.setPath("./live_board_delete.jsp");
				  
				  // 삭제 
				  }else if(command.equals("/LiveDelete.seed")) { 
					  try { action = new LiveDelete(); 
					  forward = action.execute(request, response); 
					  
					  } catch(Exception e) { 
						  e.printStackTrace(); }
				 
				  }	
		// qa ( 수환님 ) 
		
		
		// news 게시판 ( ys )
		// news write form
		if ( command.equals("/NewsAddActionForm.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(true);
			forward.setPath("./news/board_news_write.jsp");
		
		// news write 
		} else if ( command.equals("/NewsAddAction.seed")) {
			try {
				action = new NewsAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		// news list 
		} else if (command.equals("/NewsListAction.seed")) {
			try {
				action = new NewsListAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		// news view 
		} else if (command.equals("/NewsDetailAction.seed")) {
			try {
				action = new NewsDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e ) {
				e.printStackTrace();
			}
		// news modify form
		} else if (command.equals("/NewsModifyAction.seed")) {
			try {
				action = new NewsModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				
			}
		// news modify
		} else if (command.equals("/NewsModify.seed")) {
			try {
				action = new NewsModify();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		
		
		
		if (forward != null) {
			if(forward.isRedirect()) {
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
