package service.news;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewsDAO;
import model.NewsDTO;
import model.NewsReDTO;
import service.SeedAction;
import service.SeedActionForward;

public class NewsDetailAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NewsDetailAction");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = null;
		if(request.getParameter("page")== null) {
			page = "1";
		} else {
			page = request.getParameter("page");
		}
//		HttpSession session = request.getSession();		
//		String session_name = (String)session.getAttribute("name");
		
		NewsDAO dao = NewsDAO.getInstance();
		NewsDTO news = dao.getDetail(board_num);
		String board_content = news.getBoard_content().replace("\n" , "<br>");
		request.setAttribute("board_content", board_content);
		request.setAttribute("news", news);
		request.setAttribute("page", page);
		
		dao.viewUpdate(board_num);
		
//		int relistcount = dao.getReCount(board_num);
//		List<NewsReDTO> relist = dao.getReList(board_num);
//		
//		
//		request.setAttribute("relistcount", relistcount);
//		request.setAttribute("relist", relist);
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("./news/board_news_view.jsp");
		return forward;
	}

}
