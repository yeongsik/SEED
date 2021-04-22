package service.qna;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class DetailAction implements SeedAction {
    
	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DetailAction");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		QnADAO dao = QnADAO.getInstance();
		dao.viewUpdate(board_num);	
		
		QnADTO board = dao.getDetail(board_num);
		
		String board_content = board.getBoard_content().replace("\n", "<br>");
		
		request.setAttribute("board_content", board_content);
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("./qna/qna_board_view.jsp");
		
		return forward;
	}

}
