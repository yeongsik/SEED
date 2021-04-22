package service.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeDAO;
import model.FreeDTO;
import service.SeedAction;
import service.SeedActionForward;

public class FreeDetailAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FreeDetailAction");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		FreeDAO dao = FreeDAO.getInstance();
		dao.readcountUpdate(board_num);			  	// 조회수 증가
		FreeDTO board = dao.getDetail(board_num);	// 상세정보 구하기
		
		// 글내용에서 줄바꿈
		String board_content=board.getBoard_content().replace("\n","<br>");
		
		// 공유 설정
		request.setAttribute("board_content", board_content);
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("./board/qna_board_view.jsp");
		
		return forward;
	}

}
