package service.tip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipDAO;
import model.TipDTO;
import service.SeedAction;
import service.SeedActionForward;

public class TipAddAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TipAddAction");
		
		
		
		//DTO 생성
		TipDTO board = new TipDTO();
		//첨부파일 기능을 사용하지 않는 경우getParameter 를를 어떻게 처리해야 할지..
		board.setBoard_category(request.getParameter("board_category"));
		board.setName("name1");
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		
		//DAO 생성
		TipDAO dao = TipDAO.getInstance();

		int result = dao.insert(board);

		
		if(result == 1) {
			System.out.println("글작성 성공");
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(true);
		forward.setPath("./TipListAction.tip");
		
		return forward;
	}

}
