package service.live;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LiveDAO;
import model.LiveDTO;
import service.SeedAction;
import service.SeedActionForward;

public class LiveModifyAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LiveModifyAction");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		LiveDAO dao = LiveDAO.getInstance();
		LiveDTO board = dao.getDetail(board_num);
		
		request.setAttribute("board", board);	    
		request.setAttribute("page", page);
		 
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false); 
		forward.setPath("/live/live_board_modify.jsp"); 
		
		return forward;
	}

}
