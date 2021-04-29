package service.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeDAO;
import model.FreeDTO;
import service.SeedAction;
import service.SeedActionForward;

public class FreeModifyAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FreeModifyAction");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		FreeDAO dao = FreeDAO.getInstance();
		FreeDTO board = dao.getDetail(board_num);	// 상세정보 구하기
		
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);		// dispatcher 방식으로 포워딩
		forward.setPath("./board/free_board_content.jsp");	// 수정 폼
		
		return forward;
	}

}
