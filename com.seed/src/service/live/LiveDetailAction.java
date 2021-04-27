package service.live;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LiveDAO;
import model.LiveDTO;
import service.SeedAction;
import service.SeedActionForward;



public class LiveDetailAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LiveDetailAction");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		LiveDAO dao = LiveDAO.getInstance();
		dao.readcountUpdate(board_num);			   
		LiveDTO board = dao.getDetail(board_num);
		
		String board_content=board.getBoard_content().replace("\n","<br>");
		
		request.setAttribute("board_content", board_content);
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);  
		forward.setPath("./live/live_detail_view.jsp");
		
		return forward; 
	}

}
