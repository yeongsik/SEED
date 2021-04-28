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
import service.main.MainAction;
import service.member.MemberLogIn;
import service.news.NewsAddAction;
import service.news.NewsDelete;
import service.news.NewsDetailAction;
import service.news.NewsListAction;
import service.news.NewsModify;
import service.news.NewsModifyAction;
import service.news.NewsReAddAction;
import service.news.NewsReListAction;


import service.tip.TipAddAction;
import service.tip.TipDelete;
import service.tip.TipDetailAction;
import service.tip.TipListAction;
import service.tip.TipModify;
import service.tip.TipModifyAction;


import service.qna.AddAction;
import service.qna.CommentAddAction;
import service.qna.CommentDeleteAction;
import service.qna.CommentModifyAction;
import service.qna.DeleteAction;
import service.qna.DetailAction;
import service.qna.HateDownUpdate;
import service.qna.HateUpdate;
import service.qna.LikeDownUpdate;
import service.qna.LikeUpdate;
import service.qna.ListAction;
import service.qna.ModifyAction;
import service.qna.ModifyFormAction;


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
    		// 글작성
		
		if(command.equals("/TipAddAction.seed")) {
			try {
				action = new TipAddAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 글작성 폼
		}else if(command.equals("/BoardForm.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("/tip/board_tip_write.jsp");
			
			
		// 글 목록
		}else if(command.equals("/TipListAction.seed")) {
			try {
				action = new TipListAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 상세 페이지
		}else if(command.equals("/TipDetailAction.seed")) {
			try {
				action = new TipDetailAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 수정 폼
		}else if(command.equals("/TipModifyAction.seed")) {
			try {
				action = new TipModifyAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 수정
		}else if(command.equals("/TipModify.seed")) {
			try {
				action = new TipModify();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 삭제 폼
		}else if(command.equals("/TipDeleteAction.seed")) {
			try {
				forward = new SeedActionForward();
				forward.setRedirect(false);// param 사용하기위해서 false
				forward.setPath("./tip/board_tip_delete.jsp");
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 삭제
		}else if(command.equals("/TipDelete.seed")) {
			try {
				action = new TipDelete();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		// free ( 혜영님 ) 
		
		
		
		// live ( 유중님 ) 
		
    
		// qa ( 수환님 ) 
		if(command.equals("/AddAction.seed")) {
			try {
				action = new AddAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		} else if(command.equals("/CommentAddAction.seed")){
			try {
				action = new CommentAddAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/BoardWrite.seed")) { 
			forward = new SeedActionForward();
			forward.setRedirect(true);
			forward.setPath("./qna/qna_board_write.jsp");
			
		} else if(command.equals("/ListAction.seed")) {
			try {
				action = new ListAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/DetailAction.seed")) {
			try {
				action = new DetailAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/ModifyFormAction.seed")) {
			try {
				action = new ModifyFormAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/ModifyAction.seed")) {
			try {
				action = new ModifyAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CommentModifyAction.seed")) {
			try {
				action = new CommentModifyAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/LikeUpdate.seed"))  { 
			try {
				action = new LikeUpdate();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/LikeDownUpdate.seed")) {
			try {
				action = new LikeDownUpdate();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/HateUpdate.seed")) { 
			try {
				action = new HateUpdate();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/HateDownUpdate.seed")) {
			try {
				action = new HateDownUpdate();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CommentDeleteAction.seed")) {
			try {
				action = new CommentDeleteAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/DeleteAction.seed")) {
			try {
				action = new DeleteAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		

		// -------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------
		
		
		// news 게시판 ( ys )

		// news 게시판 ( 영식 )

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
				forward= action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		// news delete form 	
		} else if (command.equals("/NewsDeleteAction.seed")) {
			forward = new SeedActionForward();
			forward.setRedirect(false);
			forward.setPath("./news/board_news_delete.jsp");
		// news delete	
		} else if (command.equals("/NewsDelete.seed")) {
			try {
				action = new NewsDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		// news re_write
		} else if (command.equals("/NewsReAddAction.seed")) {
			try {
				action = new NewsReAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		// news_re_list
		} else if (command.equals("/NewsReListAction.seed")) {
			try {
				action = new NewsReListAction();
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
    
    
		// main 화면 컨트롤러 
		if ( command.equals("/MainAction.seed")) {
			try {
				action = new MainAction();
				forward = action.execute(request, response);
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
