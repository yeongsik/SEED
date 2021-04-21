package service.news;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;
import model.NewsDTO;
import service.SeedAction;
import service.SeedActionForward;

public class NewsDetailAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NewsDetailAction");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		NewsDAO dao = NewsDAO.getInstance();
		dao.viewUpdate(board_num);
		NewsDTO news = dao.getDetail(board_num);
		String board_content = news.getBoard_content().replace("\n" , "<br>");
		request.setAttribute("board_content", board_content);
		request.setAttribute("news", news);
		request.setAttribute("page", page);
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("./news/board_news_view.jsp");
		return forward;
	}

}
