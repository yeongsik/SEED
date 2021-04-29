package service.live;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LiveDAO;
import model.LiveDTO;
import service.SeedAction;
import service.SeedActionForward;

public class LiveDelete implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LiveDelete");
	
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		String name = (String)request.getParameter("name");
		
		LiveDAO dao = LiveDAO.getInstance();
		LiveDTO old = dao.getDetail(board_num);
		
		if(old.getName().equals(name)) {
			int result = dao.delete(board_num);
			if ( result ==1 ) {
				System.out.println("글 삭제 성공");
			}
		} else {
			return null;
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/LiveListAction.seed?page="+page);
		
		return forward;
	}

}
