package service.live;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LiveDAO;
import model.LiveDTO;
import service.SeedAction;
import service.SeedActionForward;


public class LiveAddAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LiveAddAction옴");
		request.setCharacterEncoding("utf-8");
		LiveDTO live = new LiveDTO();
		
		live.setBoard_category(request.getParameter("board_category"));
		live.setName("name1");
		live.setBoard_subject(request.getParameter("board_subject"));
		live.setBoard_content(request.getParameter("board_content"));
		System.out.println("글 쓰게해줘요");
		
		LiveDAO dao = LiveDAO.getInstance();
		int result = dao.insert(live);
		if(result == 1) {
			System.out.println("글이 작성되었습니다.");
		} else {
			System.out.println("글 작성 실패");
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		System.out.println("리스트액션");
		forward.setPath("LiveListAction.seed");
		
		return forward;
	}

}
