package service.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeDAO;
import model.FreeDTO;
import service.SeedAction;
import service.SeedActionForward;

public class FreeModify implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FreeModify");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		FreeDAO dao = FreeDAO.getInstance();
		FreeDTO board = dao.getDetail(board_num);	// 상세정보 구하기
		
		board.setName("name1");
		board.setBoard_num(board_num);
		board.setBoard_category(request.getParameter("board_category"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);		// dispatcher 방식으로 포워딩
		forward.setPath("/FreeDetailAction.seed?board_num="+board_num+"&page="+page);	// 수정 폼
		
		return forward;
	}

}
