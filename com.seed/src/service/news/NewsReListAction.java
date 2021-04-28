package service.news;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SeedAction;
import service.SeedActionForward;

public class NewsReListAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NewsReListAction");
		
		int page = Integer.parseInt(request.getParameter("page"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		
		int rePage = 1;
		int reLimit = 20;
		
		if(request.getParameter("rePage")!= null ) {
			rePage = Integer.parseInt(request.getParameter("rePage"));
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath(null);
		return forward;
	}

}
