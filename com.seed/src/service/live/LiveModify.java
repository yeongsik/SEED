package service.live;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Action;

import dao.LiveDAO;
import model.LiveDTO;
import service.SeedAction;
import service.SeedActionForward;

public class LiveModify implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardModify");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		LiveDTO board = new LiveDTO();
		board.setBoard_num(board_num);
		board.setName(request.getParameter("board_name"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		
		LiveDAO dao = LiveDAO.getInstance();
		LiveDTO old = dao.getDetail(board_num);
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/LiveDetailAction.seed?board_num="+board_num+"&page="+page);
		
		return forward;
	}

}
