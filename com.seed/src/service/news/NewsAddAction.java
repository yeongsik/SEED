package service.news;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewsDAO;
import model.NewsDTO;
import service.SeedAction;
import service.SeedActionForward;


public class NewsAddAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NewsAddAction");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		NewsDTO news = new NewsDTO();
		
		news.setBoard_category(request.getParameter("board_category"));
		news.setName(name);
		news.setBoard_subject(request.getParameter("board_subject"));
		news.setBoard_content(request.getParameter("board_content"));
		
		
		NewsDAO dao = NewsDAO.getInstance();
		int result = dao.newsWrite(news);
		if(result ==1) {
			System.out.println("글작성완료");
			
		} else {
			System.out.println("글작성 실패");
			return null;
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/NewsListAction.seed");
		return forward;
	}

}
