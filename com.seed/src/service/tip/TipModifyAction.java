package service.tip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipDAO;
import model.TipDTO;
import service.SeedAction;
import service.SeedActionForward;

public class TipModifyAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TipModifyAction");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		TipDAO dao = TipDAO.getInstance();
		TipDTO dto = dao.getDetail(board_num);				// 상세정보 구하기
		
		request.setAttribute("dto", dto);
		request.setAttribute("page", page);
		
		SeedActionForward forward = new SeedActionForward(); 
		forward.setRedirect(false);
		forward.setPath("./tip/board_tip_modify.jsp");		// 수정폼
		
		
		
		return forward;
	}

}
