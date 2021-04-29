package service.live;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LiveDAO;
import model.Live_reDTO;
import service.SeedAction;
import service.SeedActionForward;

public class LiveReplyAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardReplyAction");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		LiveDAO dao = LiveDAO.getInstance();
		Live_reDTO live = dao.LiveReply(board_num); 
		
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);   // dispatcher 방식으로 포워딩
		forward.setPath("./board/qna_board_reply.jsp"); //댓글 폼
		
		return forward;
	}

}
