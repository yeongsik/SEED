package service.live;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LiveDAO;
import model.Live_reDTO;
import service.SeedAction;
import service.SeedActionForward;

public class LiveReply implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardReply");
		
		request.setCharacterEncoding("utf-8");  // 한글 인코딩
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int re_ref = Integer.parseInt(request.getParameter("board_re_ref"));
		int re_lev = Integer.parseInt(request.getParameter("board_re_lev"));
		int re_seq = Integer.parseInt(request.getParameter("board_re_seq"));
		String page = request.getParameter("page");
		
		Live_reDTO live = new Live_reDTO();
		live.setBoard_num(board_num);
		live.setRe_ref(re_ref);;
		live.setRe_lev(re_lev);
		live.setRe_seq(re_seq);
		live.setName(request.getParameter("board_name"));
		live.setRe_content(request.getParameter("board_content"));
		
		
		LiveDAO dao = LiveDAO.getInstance();
		int result = dao.LiveReply(live);   // 댓글 작성
		if(result == 1) {
			System.out.println("댓글 작성되었습니다.");
		}		
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(true);
		forward.setPath("./LiveReListAction.seed?page=" + page);
		
		return forward;
	}

}
