package service.live;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LiveDAO;
import model.LiveDTO;
import service.SeedAction;
import service.SeedActionForward;

public class LiveDetailAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LiveDetailAction");

		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");

		LiveDAO dao = LiveDAO.getInstance();
		// 조회수 증가 기능, 한개의 메소드에서 update와 select sql문을 두개다 사용할 수는 있지만 그렇게 하면 재사용이 불가능하기
		// 때문에 두개로 나눠서 생성
		dao.readcountUpdate(board_num);
		// 상세정보 구하기
		LiveDTO board = dao.getDetail(board_num);

		// 글내용에서 줄바꿈
		String board_content = board.getBoard_content().replace("\n", "<br>");

		// 공유 설정
		request.setAttribute("board_content", board_content);
		request.setAttribute("LiveDTO", board);
		request.setAttribute("page", page);

		SeedActionForward forward = new SeedActionForward();
		// request 객체로 공유가 되어있기 때문에 dispatcher 방식으로 포워딩이 되어야 공유한 값을 view페이지에 사용가능
		forward.setRedirect(false); // false - dispatcher방식
		forward.setPath("./live/live_detail_view.jsp");

		return forward;
	}
}
