package service.news;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;
import model.NewsDTO;
import service.SeedAction;
import service.SeedActionForward;

public class NewsDelete implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NewsDelete");
		request.setCharacterEncoding("utf-8");
		
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		String name = (String)request.getParameter("name");
		
		NewsDAO dao = NewsDAO.getInstance();
		
		NewsDTO old = dao.getDetail(board_num);
		
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
		forward.setPath("/NewsListAction.seed?page="+page);
		return forward;
	}

}
