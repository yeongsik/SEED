package service.qna;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class ModifyFormAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ModifyFormAction");
		
		HttpSession session = request.getSession();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		QnADAO dao = QnADAO.getInstance();
		QnADTO board = dao.getDetail(board_num);
		
		System.out.println("board : " + board);
		
		session.setAttribute("b", board);
		session.setAttribute("p", page);
		/*
		 * request.setAttribute("board", board); request.setAttribute("page", page);
		 */
		
		SeedActionForward forward = new SeedActionForward();
		
		forward.setRedirect(true);
		forward.setPath("./qna/qna_board_modify.jsp");
		
		return forward;
	}

}
