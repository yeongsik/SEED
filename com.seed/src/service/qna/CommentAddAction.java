package service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class CommentAddAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stubr
		System.out.println("CommentAddAction");
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		String user_name = (String) session.getAttribute("user_name");
		
		QnADTO board = new QnADTO();
		board.setName(user_name);
		board.setRe_content(request.getParameter("smartEditor"));
		board.setBoard_num(board_num);

		QnADAO dao = QnADAO.getInstance();
		int result = dao.commentInsert(board);
		
		if(result == 1) {
			System.out.println("댓글 작성 성공");
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/DetailAction.seed");
		
		return forward;
	}

}
