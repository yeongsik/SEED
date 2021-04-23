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
		request.setCharacterEncoding("utf-8");
		
		
		//DTO 생성
		TipDTO dto = new TipDTO();

		dto.setBoard_category(request.getParameter("board_category"));
		dto.setName("name1");
		dto.setBoard_subject(request.getParameter("board_subject"));
		dto.setBoard_content(request.getParameter("board_content"));
		
		//DAO 생성
		TipDAO dao = TipDAO.getInstance();

		int result = dao.insert(dto);

		if(result == 1) {
			System.out.println("글작성 성공");
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(true);
		forward.setPath("./TipListAction.seed");
		
		return forward;
	}

}
